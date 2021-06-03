package com.zhq.crawler.task;


import com.zhq.crawler.ip.KuaiDaiLiIP;
import com.zhq.crawler.pojo.HouseInfo;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;
import java.util.Iterator;
import java.util.List;


@Component
public class HouseProcessor implements PageProcessor{

    @Autowired
    private HouseDataPipeline houseDataPipeline;
    @Autowired
    private KuaiDaiLiIP kuaiDaiLiIP;

    private String url = "https://hf.58.com/chuzu/?PGTID=0d100000-0034-5448-1684-b72bc1e684da&ClickID=4";
    @Override
    public void process(Page page) {
        //解析页面，获取租房信息的详情的url地址
        List<Selectable> list = page.getHtml().css("ul.house-list li.house-cell").nodes();
        //判断获取的集合是否为空
        if (list.size() == 0){
            //如果为空，表示这是租房详情页，解析页面获取租房信息，保存数据
            this.saveHouseInfo(page);
        }else {
            //如果不为空则表示这是列表页,解析详情页的url，放到队列中
            for (Selectable selectable:list) {
                //获取url地址
                String houseInfoUrl = selectable.css("div.img-list").links().toString();
                //System.out.println(houseInfoUrl);
                //把获取的url放到任务队列中
                page.addTargetRequest(houseInfoUrl);
            }
            //获取下一页的url
            String nextPageUrl = page.getHtml().css("div.pager a.next").nodes().get(0).links().toString();
            //System.out.println(nextPageUrl);
            //把url放到任务队列中
            page.addTargetRequest(nextPageUrl);
        }
    }
    //解析页面获取租房信息，保存数据
    private void saveHouseInfo(Page page) {
        //创建租房详情对象
        HouseInfo houseInfo = new HouseInfo();
        //解析页面
        Html html = page.getHtml();
        int statusCode = page.getStatusCode();
        Selectable title = html.css("title");
        String s = title.toString();
        if (statusCode == 200 && !s.contains("请输入验证码") && !s.contains("请完成登录")) {
            //获取照片的URL
            List<String> picUrl = html.xpath("//div[@class='basic-pic-list']/ul/li").css("img", "src").all();
            Iterator<String> it = picUrl.iterator();
            String picUrls = "";
            while (it.hasNext()) {
                String picU = it.next();
                picUrls += picU + " ";
            }
            //获取数据封装到对象中
            houseInfo.setHouseTitle(html.css("div.house-title h1", "text").toString());
            houseInfo.setHousePay(Jsoup.parse(html.css("div.house-pay-way  span.c_ff552e").nodes().get(0).toString()).text());
            houseInfo.setHousePayWay(html.css("div.house-pay-way span.instructions", "text").toString());
            houseInfo.setRentWay(Jsoup.parse(html.css("div.house-desc-item ul.f14 li span").nodes().get(1).toString()).text());
            String type = Jsoup.parse(html.css("div.house-desc-item ul.f14 li span.strongbox").nodes().get(0).toString()).text();
            String[] types = type.split(String.valueOf(' '));
            houseInfo.setHouseType(types[0]);
            houseInfo.setHouseArea(types[1] + types[2]);
            houseInfo.setHouseDecora(types[3]);
            String tf = Jsoup.parse(html.css("div.house-desc-item ul.f14 li span.strongbox").nodes().get(1).toString()).text();
            String[] tfs = tf.split(String.valueOf(' '));
            for (int i = 0; i < tfs.length; i++) {
                if (i == 0) {
                    houseInfo.setToward(tfs[i]);
                }else if ( i == 1){
                    houseInfo.setFloor(tfs[i]);
                }
                if (tfs.length >= 4) {
                    houseInfo.setFloorHeight(tfs[3]);
                } else {
                    houseInfo.setFloorHeight("");
                }
            }
            houseInfo.setHouseEstate(Jsoup.parse(html.css("div.house-desc-item ul.f14 li span a.ah").nodes().get(0).toString()).text());
            houseInfo.setArea(Jsoup.parse(html.css("div.house-desc-item ul.f14 li span a.ah").nodes().get(1).toString()).text());
            houseInfo.setAddress(Jsoup.parse(html.css("div.house-desc-item ul.f14 li span.dz").nodes().get(0).toString()).text());
            houseInfo.setPic(picUrls);
            houseInfo.setTime(html.css("div.house-title p.house-update-info", "text").toString());
            houseInfo.setAgentName(html.css("div.agent-info-block p.agent-name a", "text").toString());
            String houseDis = Jsoup.parse(html.css("ul.house-disposal").nodes().toString()).text();
            int startDis = houseDis.indexOf("[") + 1;
            int endDis = houseDis.length() - 1;
            String houseDisposal1 = houseDis.substring(startDis, endDis);
            houseInfo.setHouseDisposal(houseDisposal1);
            houseInfo.setHouseSpot(Jsoup.parse(html.css("div.house-word-introduce ul.introduce-item li span.a2").nodes().get(0).toString()).text());
            String desc = Jsoup.parse(html.css("div.house-word-introduce ul.introduce-item li span").nodes().toString()).text();
            int start = desc.indexOf("房源描述") + 5;
            int end = desc.length() - 1;
            String describe = desc.substring(start, end);
            houseInfo.setHouseDesc(describe);
            houseInfo.setUrl(page.getUrl().toString());
            //把结果保存起来
            page.putField("houseInfo", houseInfo);
        }
    }

    private Site site = Site.me()
            .setCharset("utf8")//设置编码方式
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36")
            .setTimeOut(300*1000)//设置超时时间
            .setRetryTimes(3000)//设置重试的时间间隔
            .setCycleRetryTimes(3);//设置重试的次数
    @Override
    public Site getSite() {
        return site;
    }
    //initialDelay:当任务启动后多久执行方法
    //fixedDelay:每隔多久执行方法
    //@Scheduled(initialDelay = 1000,fixedDelay = 100*1000)
    //开启定时任务，每隔5秒爬一次
    @Scheduled(cron = "*/5 * * * * *")
    public void process(){
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        String ipList = kuaiDaiLiIP.getIPList();
        if (!ipList.isEmpty()){
            String[] split = ipList.split(":");
            httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
                    new Proxy(split[0],Integer.parseInt(split[1]))));
        }

        Spider.create(this)
                .addUrl(url)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))//设置布隆过滤器，对100000条数据进行去重
                .thread(10)
                .setDownloader(httpClientDownloader)
                .addPipeline(houseDataPipeline)
                .run();
    }
}
