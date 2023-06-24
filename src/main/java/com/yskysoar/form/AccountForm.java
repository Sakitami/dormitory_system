package com.yskysoar.form;

import lombok.Data;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 10:00
 * @description 封装账户信息的实体类
 */
@Data
public class AccountForm {
    private String username;//用户名
    private String password;//密码
    private String type;//登录人员类型
}
