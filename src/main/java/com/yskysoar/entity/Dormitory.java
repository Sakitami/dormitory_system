package com.yskysoar.entity;

import lombok.Data;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 21:00
 * @description 寝室的实体类
 */

@Data
public class Dormitory {
    private Integer id;
    private Integer buildingId;
    private String buildingName;
    private String name;
    private Integer type;
    private Integer available;
    private String telephone;
}
