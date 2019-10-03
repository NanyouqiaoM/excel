package com.xiyu.test;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;
import java.util.List;

public class Demo {
    private String name;
    private Double money;
    private Date date;
    @ExcelProperty(value = "desc", converter = DescConverter.class)
    private Desc desc;
    private List<Hobby> hobbyList;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Desc getDesc() {
        return desc;
    }

    public void setDesc(Desc desc) {
        this.desc = desc;
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }
}
