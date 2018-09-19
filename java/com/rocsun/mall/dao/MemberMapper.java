package com.rocsun.mall.dao;

import com.rocsun.mall.po.Member;

import java.util.Map;

public interface MemberMapper {

    /**
     * 用来登录的数据方法
     * @param param 包含用户名(name)和密码(pass)
     * @return 用户信息
     */
    Member query(Map<String,Object> param);
}
