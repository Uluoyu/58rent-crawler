package com.zhq.crawler.ip;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class KuaiDaiLiIP {
    public String getIPList(){
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpGet对象，发起响应的地址
        HttpGet httpGet = new HttpGet("http://dps.kdlapi.com/api/getdps/?orderid=932046070754723&num=1&pt=1&sep=1");
        //使用HttpClient对象，发起响应，获得response
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                //通过工具类将获得的数据以UTF-8的编码方式获得，转为字符类型
                String ipList = EntityUtils.toString(response.getEntity(), "utf8");
                return ipList;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //关闭浏览器
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "获取IP失败";
    }
}
