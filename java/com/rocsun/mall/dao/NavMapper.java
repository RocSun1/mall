package com.rocsun.mall.dao;

import com.rocsun.mall.po.Nav;

import java.util.List;

/**
 * 数据访问层（持久化层）
 */

public interface NavMapper {
    /**
     * 查询出导航中的分类和对应的品牌
     * @return
     */
    List<Nav> getNav();
}
