package com.yskysoar.entity;

import lombok.Data;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 20:32
 * @description 学生实体类
 */
@Data
public class Student {
    private Integer id;
    private String number;
    private String name;
    private String gender;
    private Integer dormitoryId;
    private Integer oldDormitoryId;
    private String dormitoryName;
    private String state;
    private String createDate;
}