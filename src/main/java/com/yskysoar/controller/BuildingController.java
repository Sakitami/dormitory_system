package com.yskysoar.controller;

import com.yskysoar.entity.Building;
import com.yskysoar.service.BuildingService;
import com.yskysoar.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 22:53
 * @description 寝室楼相关业务的控制器
 */
@Controller
@RequestMapping("/building")
public class BuildingController {
    //相关业务操作的注入
    @Autowired
    private BuildingService buildingService;

    @Autowired
    private DormitoryAdminService dormitoryAdminService;

    /**
     * 展示所有寝室楼列表
     * @return 视图解析器
     */
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("buildingmanager");
        modelAndView.addObject("list", this.buildingService.list());//返回寝室楼列表的结果集
        modelAndView.addObject("dormitoryAdminList", this.dormitoryAdminService.list());//返回寝室楼对应寝室管理员的结果集
        return modelAndView;
    }

    /**
     * 指定信息模糊查询寝室楼列表
     * @param key   指定的查询方式(1.名称 2.介绍)
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("buildingmanager");
        modelAndView.addObject("list", this.buildingService.search(key, value));//返回查询的结果集
        modelAndView.addObject("dormitoryAdminList", this.dormitoryAdminService.list());//返回寝室楼对应寝室管理员的结果集
        return modelAndView;
    }

    /**
     * 添加寝室楼
     * @param building 寝室楼信息
     * @return 重定向到list方法
     */
    @PostMapping("/save")
    public String save(Building building) {
        this.buildingService.save(building);//将寝室楼信息进行添加
        return "redirect:/building/list";//重定向到list方法
    }

    /**
     * 更新寝室楼信息
     * @param building 新的寝室楼信息
     * @return 重定向到list方法
     */
    @PostMapping("/update")
    public String update(Building building) {
        this.buildingService.update(building);//将寝室楼信息进行更新
        return "redirect:/building/list";//重定向到list方法
    }

    /**
     * 删除指定id的寝室楼(对应寝室也进行删除，学生自动分配)
     * @param id 待删除寝室楼的id
     * @return 重定向到list方法
     */
    @PostMapping("/delete")
    public String delete(Integer id) {
        this.buildingService.delete(id);//将寝室楼进行删除
        return "redirect:/building/list";//重定向到list方法
    }
}
