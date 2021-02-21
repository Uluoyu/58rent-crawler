package com.zhq.crawler.service;

import com.zhq.crawler.pojo.HouseInfo;

import java.util.List;

public interface HouseInfoService {
    /**
     * 保存租房信息
     * @param houseInfo
     */
    public void save(HouseInfo houseInfo);

    /**
     * 根据条件查询房屋信息
     * @param houseInfo
     * @return
     */
    public List<HouseInfo> findHouseInfo(HouseInfo houseInfo);
}
