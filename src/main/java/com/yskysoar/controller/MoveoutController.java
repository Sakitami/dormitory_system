package com.yskysoar.controller;

import com.yskysoar.entity.Moveout;
import com.yskysoar.service.MoveoutService;
import com.yskysoar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 20:37
 * @description 迁出业务的控制器
 */
@Controller
@RequestMapping("/moveout")
public class MoveoutController {
    //相关业务操作的注入
    @Autowired
    private StudentService studentService;

    @Autowired
    private MoveoutService moveoutService;

    /**
     * 展示所有的学生列表
     *
     * @return 视图解析器
     */
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        modelAndView.addObject("list", this.studentService.moveoutList());//返回所有学生的结果集
        return modelAndView;
    }

    /**
     * 指定信息模糊查询迁出学生
     *
     * @param key   指定的查询方式(1.学号 2.姓名)
     * @param value 模糊查询的数据
     * @return 视图解析器
     */
    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        modelAndView.addObject("list", this.studentService.searchForMoveoutList(key, value));//模糊查询的结果集
        return modelAndView;
    }

    /**
     * 迁出登记
     *
     * @param moveout 迁出学生信息
     * @return 重定向到list方法
     */
    @PostMapping("/register")
    public String register(Moveout moveout) {
        this.studentService.moveout(moveout);//进行学生迁出操作
        return "redirect:/moveout/list";
    }

    /**
     * 迁出记录展示
     *
     * @return 视图解析器
     */
    @GetMapping("/record")
    public ModelAndView record() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        modelAndView.addObject("list", this.moveoutService.list());//返回所有迁出记录的结果集
        return modelAndView;
    }

    /**
     * 指定方式模糊查询迁出记录
     *
     * @param key   指定的查询方式(1.学生 2.寝室)
     * @param value 查询的结果集
     * @return 视图解析器
     */
    @PostMapping("/recordSearch")
    public ModelAndView recordSearch(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        modelAndView.addObject("list", this.studentService.search(key, value));//模糊查询的结果集
        return modelAndView;
    }

}
