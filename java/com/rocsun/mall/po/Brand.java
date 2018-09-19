package com.rocsun.mall.po;


public class Brand {
    private Integer bid;
    private String name;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                '}';
    }
}
