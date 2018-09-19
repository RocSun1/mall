package com.rocsun.mall.dao;

import com.rocsun.mall.po.Address;

import java.util.List;

public interface AddressMapper {
    List<Address> queryByMid(Integer mid);

    /*int doInsert(Address address);

    int doUpdate(Address address);*/
}
