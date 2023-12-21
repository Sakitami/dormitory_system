package com.yskysoar.controller;

import com.yskysoar.entity.DormitoryAdmin;
import com.yskysoar.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 15:21
 * @description 寝室管理员的控制器
 */

@Controller
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {
    //相关业务操作的注入
    @Autowired
    private DormitoryAdminService dormitoryAdminService;

    /**
     * 展示所有的寝室管理员列表
     * @return 视图解析器
     */
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list", this.dormitoryAdminService.list());//返回寝室管理员列表的结果集
        return modelAndView;
    }

    /**
     * 指定信息模糊查询寝室管理员列表
     * @param key   指定的方式(1.用户名 2.姓名 3.电话)
     * @param value 模糊查询的数据
     * @return 视图解析器
     */
    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list", this.dormitoryAdminService.search(key, value));//返回模糊查询的结果集
        return modelAndView;
    }

    /**
     * 添加寝室管理员
     * @param dormitoryAdmin 寝室管理员信息
     * @return 重定向到list方法
     */
    @PostMapping("/save")
    public String save(DormitoryAdmin dormitoryAdmin) {
        this.dormitoryAdminService.save(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }//不需要重新加载数据，直接重定向到list方法即可(list已经完成数据加载)

    /**
     * 根据id删除指定寝室管理员
     * @param id 指定寝室管理员的id
     * @return 重定向到list方法
     */
    @PostMapping("/delete")
    public String delete(Integer id) {
        this.dormitoryAdminService.delete(id);
        return "redirect:/dormitoryAdmin/list";
    }//不需要重新加载数据，直接重定向到list方法即可(list已经完成数据加载)

    /**
     * 更新寝室管理员信息
     * @param dormitoryAdmin 更新的寝室管理员信息
     * @return 重定向到list方法
     */
    @PostMapping("/update")
    public String update(DormitoryAdmin dormitoryAdmin) {
        this.dormitoryAdminService.update(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }//不需要重新加载数据，直接重定向到list方法即可(list已经完成数据加载)
}
