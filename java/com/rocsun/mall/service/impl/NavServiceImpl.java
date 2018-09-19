package com.rocsun.mall.service.impl;

import com.rocsun.mall.dao.NavMapper;
import com.rocsun.mall.po.Nav;
import com.rocsun.mall.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层 依赖数据层
 */

@Service
public class NavServiceImpl implements NavService{
    @Autowired
    private NavMapper navMapper;

    @Override
    public List<Nav> getNav(){
        return navMapper.getNav();
    }
}
