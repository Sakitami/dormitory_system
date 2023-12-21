package com.yskysoar.controller;

import com.yskysoar.entity.*;
import com.yskysoar.service.AbsentService;
import com.yskysoar.service.BuildingService;
import com.yskysoar.service.DormitoryService;
import com.yskysoar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 21:55
 * @description 缺寝登记的控制器
 */

@Controller
@RequestMapping("/absent")
public class AbsentController {
    //相关业务操作的注入
    @Autowired
    private AbsentService absentService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private StudentService studentService;

    /**
     * 展示缺寝学生列表
     *
     * @return 视图解析器
     */
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("absentrecord");//设置跳转的页面
        modelAndView.addObject("list", this.absentService.list());//返回学生列表的结果集
        return modelAndView;
    }

    /**
     * 指定信息模糊查询缺寝学生列表
     *
     * @param key   指定的查询方式(1.楼宇 2.寝室)
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("absentrecord");//设置跳转的页面
        modelAndView.addObject("list", this.absentService.search(key, value));//返回查询的结果集
        return modelAndView;
    }

    /**
     * 缺寝登记的表单初始化(三级联动，默认展示第一个数据)
     *
     * @return 初始化的表单数据
     */
    @GetMapping("/init")
    public ModelAndView init() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("absentregister");//设置跳转的页面
        List<Building> buildingList = this.buildingService.list();//获取所有的楼宇列表
        modelAndView.addObject("buildingList", buildingList);//返回楼宇列表的结果集
        List<Dormitory> dormitoryList = this.dormitoryService.findByBuildingId(buildingList.get(0).getId());//获取楼宇内所有的寝室列表
        modelAndView.addObject("dormitoryList", dormitoryList);//返回寝室列表的结果集
        List<Student> studentList = this.studentService.findByDormitoryId(dormitoryList.get(0).getId());//获取寝室内所有的学生列表
        modelAndView.addObject("studentList", studentList);//返回学生列表的结果集
        return modelAndView;
    }

    /**
     * 添加缺寝记录
     *
     * @param absent  缺寝信息
     * @param session 当前的寝室管理员
     * @return 重定向到初始化方法
     */
    @PostMapping("/save")
    public String save(Absent absent, HttpSession session) {
        DormitoryAdmin dormitoryAdmin = (DormitoryAdmin) session.getAttribute("dormitoryAdmin");//获取当前会话的对象
        absent.setDormitoryAdminId(dormitoryAdmin.getId());//设置登记缺寝的寝室管理员
        this.absentService.save(absent);//将缺寝信息进行登记
        return "redirect:/absent/init";//重定向到初始化方法
    }
}
