package com.zhq.crawler.service.impl;

import com.zhq.crawler.dao.HouseInfoDao;
import com.zhq.crawler.pojo.HouseInfo;
import com.zhq.crawler.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {

    @Autowired
    private HouseInfoDao houseInfoDao;
    @Override
    public void save(HouseInfo houseInfo) {
        //根据url来查询数据
        HouseInfo param = new HouseInfo();
        param.setUrl(houseInfo.getUrl());
        //执行查询
        List<HouseInfo> list = this.findHouseInfo(param);
        //判断查询结果是否为空
        if (list.size() == 0){
            //如果查询结果为空，表示租房信息数据不存在，或者已经更新了，需要新增或更新数据库
            this.houseInfoDao.saveAndFlush(houseInfo);
        }
    }

    @Override
    public List<HouseInfo> findHouseInfo(HouseInfo houseInfo) {
        //设置查询条件
        Example example = Example.of(houseInfo);
        //执行查询
        List list = this.houseInfoDao.findAll(example);

        return list;
    }
}
