package com.zhq.analysis.service;

import com.zhq.crawler.pojo.HouseInfo;



import java.util.HashMap;
import java.util.List;


public interface HouseService {
    public List<HouseInfo> selectAll();

    public List<HashMap<String,String>> selectAnalysis(String cate);

    public List<HashMap<String,String>> selectAnalysis2();

    public List<HashMap<String,String>> selectAnalysis3();

    public List<HashMap<String,String>> selectAnalysis4();
}
