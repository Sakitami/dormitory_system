package com.yskysoar.mapper;

import com.yskysoar.entity.SystemAdmin;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 10:14
 * @description 处理系统管理员数据
 */
public interface SystemAdminMapper {

    /**
     * 系统管理员用户名校验
     *
     * @param name 用户名
     * @return 对应用户数据的结果集
     */
    public SystemAdmin findByUsername(String name);
}
