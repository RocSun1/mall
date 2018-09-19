package com.rocsun.mall.po;

import java.util.List;

public class Nav extends Category{
    private List<Brand> brands;

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }
}
