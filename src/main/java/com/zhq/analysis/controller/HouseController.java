package com.zhq.analysis.controller;

import com.alibaba.fastjson.JSON;
import com.zhq.analysis.service.HouseService;
import com.zhq.crawler.pojo.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/data")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @ResponseBody
    @RequestMapping(value = "/getdata",method = RequestMethod.POST)
    public List<HouseInfo> showData(){
        List<HouseInfo> houseInfoListArrayList = new ArrayList<>();
        houseInfoListArrayList = houseService.selectAll();
        return houseInfoListArrayList;
    }
    @GetMapping("/getAnaly")
    public String getAnData(@RequestParam("cate") String cate){
        List<HashMap<String, String>> data = houseService.selectAnalysis(cate);
        return "{\n\"data\":" + JSON.toJSONString(data) +"\n}";
    }
    @GetMapping("/getAnaly2")
    public String getAnData2(){
        List<HashMap<String, String>> data = houseService.selectAnalysis2();
        return "{\n\"data\":" + JSON.toJSONString(data) +"\n}";
    }
    @GetMapping("/getAnaly3")
    public String getAnData3(){
        List<HashMap<String, String>> data = houseService.selectAnalysis3();
        return "{\n\"data\":" + JSON.toJSONString(data) +"\n}";
    }
    @GetMapping("/getAnaly4")
    public String getAnData4(){
        List<HashMap<String, String>> data = houseService.selectAnalysis4();
        return "{\n\"data\":" + JSON.toJSONString(data) +"\n}";
    }
}
