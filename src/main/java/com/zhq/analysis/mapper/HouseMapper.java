package com.zhq.analysis.mapper;

import com.zhq.crawler.pojo.HouseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HouseMapper {

    public List<HouseInfo> selectAll();
    //根据某个条件查询数量
    public List<HashMap<String,String>> selectAnalysis(@Param("cate") String cate);
    //查询租金与建筑面积
    public List<HashMap<String,String>> selectAnalysis2();
    //查询每个地区的平均租金
    public List<HashMap<String,String>> selectAnalysis3();
    //查询租房面积的分布区间
    public List<HashMap<String,String>> selectAnalysis4();

}
