package com.yskysoar.controller;

import com.yskysoar.entity.Student;
import com.yskysoar.service.DormitoryService;
import com.yskysoar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 20:44
 * @description 学生业务的控制器
 */

@Controller
@RequestMapping("/student")
public class StudentController {
    //相关业务操作的注入
    @Autowired
    private StudentService studentService;

    @Autowired
    private DormitoryService dormitoryService;

    /**
     * 展示所有学生列表
     *
     * @return 视图解析器
     */
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list", this.studentService.list());//返回所有学生列表的结果集
        modelAndView.addObject("dormitoryList", this.dormitoryService.availableList());//返回学生对应寝室的结果集(可用)
        return modelAndView;
    }

    /**
     * 指定信息模糊查询学生列表
     *
     * @param key   指定的查询方式(1.学号 2.姓名)
     * @param value 查询的结果集
     * @return 视图解析器
     */
    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list", this.studentService.search(key, value));//模糊查询的结果集
        modelAndView.addObject("dormitoryList", this.dormitoryService.availableList());//返回学生对应寝室的结果集(可用)
        return modelAndView;
    }

    /**
     * 添加学生
     *
     * @param student 学生信息
     * @return 重定向到list方法
     */
    @PostMapping("/save")
    public String save(Student student) {
        this.studentService.save(student);
        return "redirect:/student/list";
    }

    /**
     * 更新学生信息
     *
     * @param student 待更新的学生信息
     * @return 重定向到list方法
     */
    @PostMapping("/update")
    public String update(Student student) {
        this.studentService.update(student);
        return "redirect:/student/list";
    }

    /**
     * 删除学生信息
     *
     * @param student 待删除学生信息
     * @return 重定向到list方法
     */
    @PostMapping("/delete")
    public String delete(Student student) {
        this.studentService.delete(student);
        return "redirect:/student/list";
    }

    /**
     * 根据指定寝室id查询对应学生列表
     *
     * @param dormitoryId 指定的寝室id
     * @return 查询的学生列表结果集合
     */
    @PostMapping("/findByDormitoryId")
    @ResponseBody
    public List<Student> findByDormitoryId(Integer dormitoryId) {
        return this.studentService.findByDormitoryId(dormitoryId);
    }
}
