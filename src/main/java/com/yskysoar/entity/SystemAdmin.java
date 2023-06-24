package com.yskysoar.entity;

import lombok.Data;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 9:56
 * @description 系统管理员实体类
 */
@Data
public class SystemAdmin {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String telephone;
}
