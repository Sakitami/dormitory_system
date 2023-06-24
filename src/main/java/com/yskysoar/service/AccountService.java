package com.yskysoar.service;

import com.yskysoar.dto.AccountDto;
import com.yskysoar.form.AccountForm;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 10:03
 * @description 登录所需业务的接口
 */
public interface AccountService {
    public AccountDto login(AccountForm accountForm);
}
