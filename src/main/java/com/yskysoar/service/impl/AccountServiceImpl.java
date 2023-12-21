package com.yskysoar.service.impl;

import com.yskysoar.dto.AccountDto;
import com.yskysoar.entity.DormitoryAdmin;
import com.yskysoar.entity.SystemAdmin;
import com.yskysoar.form.AccountForm;
import com.yskysoar.mapper.DormitoryAdminMapper;
import com.yskysoar.mapper.SystemAdminMapper;
import com.yskysoar.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 10:12
 * @description 登录业务的实现类
 */
@Service
public class AccountServiceImpl implements AccountService {
    //相关数据的注入
    @Autowired
    private SystemAdminMapper systemAdminMapper;

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    /**
     * 登录校验
     *
     * @param accountForm 账户登录方式
     * @return 账户数据
     */
    @Override
    @Transactional
    public AccountDto login(AccountForm accountForm) {
        AccountDto dto = new AccountDto<>();//创建账户类型实体类
        //判断用户类型
        switch (accountForm.getType()) {
            case "systemAdmin": {
                SystemAdmin systemAdmin = this.systemAdminMapper.findByUsername(accountForm.getUsername());
                //判断用户名是否正确
                if (systemAdmin == null) {
                    dto.setCode(-1);//用户名错误
                } else {
                    //用户名正确，判断密码是否正确
                    if (!systemAdmin.getPassword().equals(accountForm.getPassword())) {
                        dto.setCode(-2);//密码错误
                    } else {//用户名和密码都正确
                        dto.setCode(0);//登录成功
                        dto.setAdmin(systemAdmin);//设置管理员类型
                    }
                }
                break;
            }
            case "dormitoryAdmin": {
                DormitoryAdmin dormitoryAdmin = this.dormitoryAdminMapper.findByUserName(accountForm.getUsername());
                //判断用户名是否正确
                if (dormitoryAdmin == null) {
                    dto.setCode(-1);//用户名错误
                } else {
                    //用户名正确，判断密码是否正确
                    if (!dormitoryAdmin.getPassword().equals(accountForm.getPassword())) {
                        dto.setCode(-2);//密码错误
                    } else {//用户名和密码都正确
                        dto.setCode(0);//登录成功
                        dto.setAdmin(dormitoryAdmin);//设置管理员类型
                    }
                }
                break;
            }
        }
        return dto;
    }
}
