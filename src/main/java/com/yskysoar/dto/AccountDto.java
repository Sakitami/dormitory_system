package com.yskysoar.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 10:06
 * @description 控制登录的数据模型
 */
@Data
@ToString
public class AccountDto<T> {
    private Integer code;//0：登录成功  -1:用户名错误  -2：密码错误
    private T admin;//使用泛型来处理管理员类型
}
