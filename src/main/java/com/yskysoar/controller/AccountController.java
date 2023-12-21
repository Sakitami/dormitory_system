package com.yskysoar.controller;

import com.yskysoar.dto.AccountDto;
import com.yskysoar.form.AccountForm;
import com.yskysoar.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 9:57
 * @description 账户管理相关的控制器
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    //相关业务操作的注入
    @Autowired
    private AccountService accountService;

    /**
     * 账号登录控制器
     *
     * @param accountForm 封装前端传递的登录信息
     * @param httpSession 确认登录成功后开启的一次临时会话
     * @return 登录结果
     */
    @PostMapping("/login")
    public ModelAndView login(AccountForm accountForm, HttpSession httpSession) {
        AccountDto accountDto = this.accountService.login(accountForm);//获取登录的结果(状态码和管理员类型)
        ModelAndView modelAndView = new ModelAndView();//视图解析器
        switch (accountDto.getCode()) {//根据状态码分支执行操作
            case 0: {//状态：登录成功
                switch (accountForm.getType()) {//根据管理员类型分支执行操作
                    case "systemAdmin": {
                        modelAndView.setViewName("systemadmin");
                        httpSession.setAttribute("systemAdmin", accountDto.getAdmin());//存储一个系统管理员信息的会话(对象)
                        break;
                    }
                    case "dormitoryAdmin": {
                        modelAndView.setViewName("dormitoryadmin");
                        httpSession.setAttribute("dormitoryAdmin", accountDto.getAdmin());//存储一个寝室管理员信息的会话(对象)
                        break;
                    }
                }
                break;
            }
            case -1: {//状态：用户名不存在
                modelAndView.setViewName("login");
                modelAndView.addObject("usernameError", "用户名不存在");//返回当前状态
                break;
            }
            case -2: {////状态：密码错误
                modelAndView.setViewName("login");
                modelAndView.addObject("passwordError", "密码错误");//返回当前状态
                break;
            }
        }
        return modelAndView;
    }

    /**
     * 登出当前账户
     *
     * @param httpSession 当前执行的临时会话对象
     * @return 重定向到login页面
     */
    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();//无效化当前会话
        return "login";
    }
}
