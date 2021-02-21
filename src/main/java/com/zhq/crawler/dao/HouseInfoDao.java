package com.zhq.crawler.dao;

import com.zhq.crawler.pojo.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseInfoDao extends JpaRepository<HouseInfo,Long> {
}
