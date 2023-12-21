package com.yskysoar.controller;

import com.yskysoar.entity.Dormitory;
import com.yskysoar.entity.Student;
import com.yskysoar.service.BuildingService;
import com.yskysoar.service.DormitoryService;
import com.yskysoar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 19:39
 * @description 寝室相关业务的控制器
 */
@Controller
@RequestMapping("/dormitory")
public class DormitoryController {
    //相关业务操作的注入
    @Autowired
    private DormitoryService dormitoryService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private StudentService studentService;

    /**
     * 展示所有的寝室列表
     * @return 视图解析器
     */
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dormitorymanager");
        modelAndView.addObject("list", this.dormitoryService.list());//返回寝室列表的结果集
        modelAndView.addObject("buildingList", this.buildingService.list());//返回寝室对应寝室楼的结果集
        return modelAndView;
    }

    /**
     * 指定信息模糊查询寝室列表
     * @param key   指定的查询方式(1.名称 2.介绍)
     * @param value 模糊查询的数据
     * @return 视图解析器
     */
    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dormitorymanager");
        modelAndView.addObject("list", this.dormitoryService.search(key, value));//返回模糊查询的结果集
        modelAndView.addObject("buildingList", this.buildingService.list());//返回寝室对应寝室楼的结果集
        return modelAndView;
    }

    /**
     * 添加寝室
     * @param dormitory 寝室信息
     * @return 重定向到list方法
     */
    @PostMapping("/save")
    public String save(Dormitory dormitory) {
        this.dormitoryService.save(dormitory);//将寝室信息进行添加
        return "redirect:/dormitory/list";
    }

    /**
     * 更新寝室信息
     * @param dormitory 待更新寝室信息
     * @return 重定向到list方法
     */
    @PostMapping("/update")
    public String update(Dormitory dormitory) {
        this.dormitoryService.update(dormitory);//将寝室信息进行更新
        return "redirect:/dormitory/list";
    }

    /**
     * 根据指定寝室的id删除寝室(学生自动分配)
     * @param id 指定寝室的id
     * @return 重定向到list方法
     */
    @PostMapping("/delete")
    public String delete(Integer id) {
        this.dormitoryService.delete(id);//将寝室信息进行删除
        return "redirect:/dormitory/list";
    }

    /**
     * 根据指定寝室楼id寻找寝室
     * @param buildingId 指定寝室楼的id
     * @return 寝室楼内所有寝室信息的结果集(包括寝室内的学生信息)
     */
    @PostMapping("/findByBuildingId")
    @ResponseBody
    public List findByBuildingId(Integer buildingId) {
        List<Dormitory> dormitoryList = this.dormitoryService.findByBuildingId(buildingId);//获取当前寝室楼所有寝室的结果集
        List list = null;
        if (dormitoryList.size() > 0) {//若存在寝室
            List<Student> studentList = this.studentService.findByDormitoryId(dormitoryList.get(0).getId());//获取对应寝室内的学生列表结果集
            list = new ArrayList();
            list.add(dormitoryList);
            list.add(studentList);
        } else {//若不存在寝室
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
        }
        return list;
    }
}
