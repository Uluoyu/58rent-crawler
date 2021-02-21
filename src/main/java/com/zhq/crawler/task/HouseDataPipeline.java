package com.zhq.crawler.task;

import com.zhq.crawler.pojo.HouseInfo;
import com.zhq.crawler.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
@Component
public class HouseDataPipeline implements Pipeline {

    @Autowired
    private HouseInfoService houseInfoService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        //获取封装好的租房详情对象
        HouseInfo houseInfo = resultItems.get("houseInfo");
        //判断数据是否不为空
        if (houseInfo != null){
            this.houseInfoService.save(houseInfo);
        }
    }
}
