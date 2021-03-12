package com.zhq.analysis.service.impl;

import com.zhq.analysis.mapper.HouseMapper;
import com.zhq.analysis.service.HouseService;
import com.zhq.crawler.pojo.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<HouseInfo> selectAll() {
        return this.houseMapper.selectAll();
    }

    @Override
    public List<HashMap<String,String>> selectAnalysis(String cate) {
        return this.houseMapper.selectAnalysis(cate);
    }

    @Override
    public List<HashMap<String, String>> selectAnalysis2() {
        return houseMapper.selectAnalysis2();
    }

    @Override
    public List<HashMap<String, String>> selectAnalysis3() {
        return houseMapper.selectAnalysis3();
    }

    @Override
    public List<HashMap<String, String>> selectAnalysis4() {
        return houseMapper.selectAnalysis4();
    }

}
