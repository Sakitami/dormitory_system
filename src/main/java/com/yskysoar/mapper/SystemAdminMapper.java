package com.yskysoar.mapper;

import com.yskysoar.entity.SystemAdmin;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 10:14
 * @description 处理系统管理员相关数据
 */
public interface SystemAdminMapper {

    /**
     * 系统管理员用户名校验
     * @param name 用户名
     * @return 对应用户数据的结果集
     */
    public SystemAdmin findByUsername(String name);

    /**
     * 新增系统管理员
     * @param systemAdmin 系统管理员信息
     */
    public void saveUserToSystem(SystemAdmin systemAdmin);
}
