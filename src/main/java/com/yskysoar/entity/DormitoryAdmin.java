package com.yskysoar.entity;

import lombok.Data;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 20:57
 * @description 寝室管理员实体类
 */

@Data
public class DormitoryAdmin {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private String telephone;
}
