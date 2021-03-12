# 58同城租房信息的爬取与分析
## 说明
  实现了58同城租房信息的爬取，并保存到MariaDB数据库中，代理IP可以自己去快代理购买，设置白名单，换成自己的快代理API链接。做好定时任务，可以放在那让它自己爬取。  
后端使用Springboot+mybatis+MariaDB数据库+WebMagic，前端使用Vue+echarts,后端提供API接口给前端，完全的前后的分离。
## 开发环境
开发语言：Java  
集成开发环境：IntelliJ IDEA、Visual Studio Code  
数据库：MariaDB  
Web服务器： Tomcat
## 运行前说明
crawler:爬虫，启动即可对58同城租房数据进行爬取  
analysis：提供数据分析的后端，启动,浏览器输入http://localhost:8888/index.html#/home，看到数据分析界面。
## 参考
可以去B站观看Webmagic、Vue+echarts的教学视频，对代码将有更多的了解。  
WebMagic:【Java爬虫】网络爬虫 HttpClient Jsoup WebMagic  
Vue+Echarts:电商平台数据可视化实时监控系统-Echarts-vue项目综合练习-pink老师推荐(持续更新)素材已经更新
****
## 界面展示
### 数据爬取
![数据爬取](https://github.com/Uluoyu/58rent-crawler/blob/master/images/1.png)  
![数据插入数据库](https://github.com/Uluoyu/58rent-crawler/blob/master/images/2.png)
### 房屋数据分析主界面
![房屋数据分析](https://github.com/Uluoyu/58rent-crawler/blob/master/images/3.png)
![主题切换](https://github.com/Uluoyu/58rent-crawler/blob/master/images/4.png)
### 各区域租房平均单价数据统计
![各区域租房平均单价](https://github.com/Uluoyu/58rent-crawler/blob/master/images/5.png)
### 房屋地区数据统计
![房屋地区数据分析](https://github.com/Uluoyu/58rent-crawler/blob/master/images/6.png)
### 房屋面积与租金数据统计
![房屋面积与租金](https://github.com/Uluoyu/58rent-crawler/blob/master/images/7.png)
### 房屋类型数据统计
![房屋类型数据分析](https://github.com/Uluoyu/58rent-crawler/blob/master/images/8.png)
### 房屋租金支付方式数据统计
![房屋租金支付方式数据分析](https://github.com/Uluoyu/58rent-crawler/blob/master/images/9.png)
### 租房面积数据统计
![租房面积数据分析](https://github.com/Uluoyu/58rent-crawler/blob/master/images/10.png)
