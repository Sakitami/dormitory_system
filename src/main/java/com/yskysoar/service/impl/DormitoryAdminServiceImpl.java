package com.yskysoar.service.impl;

import com.yskysoar.entity.DormitoryAdmin;
import com.yskysoar.mapper.DormitoryAdminMapper;
import com.yskysoar.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 21:04
 * @description 寝室管理员管理接口的实现类
 */

@Service
public class DormitoryAdminServiceImpl implements DormitoryAdminService {
    //相关数据的注入
    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    /**
     * 展示所有的寝室管理员列表
     * @return 寝室管理员列表
     */
    @Override
    @Transactional
    public List<DormitoryAdmin> list() {
        return this.dormitoryAdminMapper.list();
    }

    /**
     * 指定信息模糊查询寝室管理员列表
     * @param key   指定的方式(1.用户名 2.姓名 3.电话)
     * @param value 模糊查询的数据
     * @return 查询的结果结合
     */
    @Override
    @Transactional
    public List<DormitoryAdmin> search(String key, String value) {
        if (key.equals("")) {//空选择，返回表单所有结果
            return this.dormitoryAdminMapper.list();
        }
        //创建对象获取查询的数据
        List<DormitoryAdmin> dormitoryAdminList = null;
        switch (key) {
            case "username": {
                dormitoryAdminList = this.dormitoryAdminMapper.searchByUsername(value);
                break;
            }
            case "name": {
                dormitoryAdminList = this.dormitoryAdminMapper.searchByName(value);
                break;
            }
            case "telephone": {
                dormitoryAdminList = this.dormitoryAdminMapper.searchByTelephone(value);
                break;
            }
        }
        return dormitoryAdminList;
    }

    /**
     * 添加寝室管理员
     * @param dormitoryAdmin 寝室管理员信息
     */
    @Override
    @Transactional
    public void save(DormitoryAdmin dormitoryAdmin) {
        try {
            this.dormitoryAdminMapper.save(dormitoryAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id删除指定寝室管理员
     * @param id 指定寝室管理员的id
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        try {
            this.dormitoryAdminMapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新寝室管理员信息
     * @param dormitoryAdmin 更新的寝室管理员信息
     */
    @Override
    @Transactional
    public void update(DormitoryAdmin dormitoryAdmin) {
        try {
            this.dormitoryAdminMapper.update(dormitoryAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
