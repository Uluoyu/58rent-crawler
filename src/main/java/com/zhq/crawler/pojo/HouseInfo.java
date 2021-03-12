package com.zhq.crawler.pojo;


import javax.persistence.*;

@Entity
public class HouseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String houseTitle;
    private String housePay;
    private String housePayWay;
    private String rentWay;
    private String houseType;
    private String houseArea;
    private String houseDecora;
    private String toward;
    private String floor;
    private String floorHeight;
    private String houseEstate;
    private String area;
    private String address;
    private String pic;
    private String time;
    private String agentName;
    private String houseDisposal;
    private String houseSpot;
    private String houseDesc;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public String getHousePay() {
        return housePay;
    }

    public void setHousePay(String housePay) {
        this.housePay = housePay;
    }

    public String getHousePayWay() {
        return housePayWay;
    }

    public void setHousePayWay(String housePayWay) {
        this.housePayWay = housePayWay;
    }

    public String getRentWay() {
        return rentWay;
    }

    public void setRentWay(String rentWay) {
        this.rentWay = rentWay;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseDecora() {
        return houseDecora;
    }

    public void setHouseDecora(String houseDecora) {
        this.houseDecora = houseDecora;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(String floorHeight) {
        this.floorHeight = floorHeight;
    }

    public String getHouseEstate() {
        return houseEstate;
    }

    public void setHouseEstate(String houseEstate) {
        this.houseEstate = houseEstate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getHouseDisposal() {
        return houseDisposal;
    }

    public void setHouseDisposal(String houseDisposal) {
        this.houseDisposal = houseDisposal;
    }

    public String getHouseSpot() {
        return houseSpot;
    }

    public void setHouseSpot(String houseSpot) {
        this.houseSpot = houseSpot;
    }

    public String getHouseDesc() {
        return houseDesc;
    }

    public void setHouseDesc(String houseDesc) {
        this.houseDesc = houseDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HouseInfo{" +
                "id=" + id +
                ", houseTitle='" + houseTitle + '\'' +
                ", housePay='" + housePay + '\'' +
                ", housePayWay='" + housePayWay + '\'' +
                ", rentWay='" + rentWay + '\'' +
                ", houseType='" + houseType + '\'' +
                ", houseArea='" + houseArea + '\'' +
                ", houseDecora='" + houseDecora + '\'' +
                ", toward='" + toward + '\'' +
                ", floor='" + floor + '\'' +
                ", floorHeight='" + floorHeight + '\'' +
                ", houseEstate='" + houseEstate + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", pic='" + pic + '\'' +
                ", time='" + time + '\'' +
                ", agentName='" + agentName + '\'' +
                ", houseDisposal='" + houseDisposal + '\'' +
                ", houseSpot='" + houseSpot + '\'' +
                ", houseDesc='" + houseDesc + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
