package com.yskysoar.entity;

import lombok.Data;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 20:51
 * @description
 */
@Data
public class Moveout {
    private Integer id;
    private Integer studentId;
    private String studentName;
    private Integer dormitoryId;
    private String dormitoryName;
    private String reason;
    private String createDate;
}

