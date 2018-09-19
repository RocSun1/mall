package com.rocsun.mall.service;

import com.rocsun.mall.po.Member;

public interface AccountService {
    Member login(String name, String pass);
}
