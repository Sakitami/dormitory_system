package com.yskysoar.entity;

import lombok.Data;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 22:44
 * @description 楼宇的实体类
 */

@Data
public class Building {
    private Integer id;
    private String name;
    private String introduction;
    private Integer adminId;
    private String adminName;
}
