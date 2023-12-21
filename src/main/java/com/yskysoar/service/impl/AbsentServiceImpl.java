package com.yskysoar.service.impl;

import com.yskysoar.entity.Absent;
import com.yskysoar.mapper.AbsentMapper;
import com.yskysoar.service.AbsentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 21:58
 * @description 缺寝登记的接口实现类
 */
@Service
public class AbsentServiceImpl implements AbsentService {
    //相关数据的注入
    @Autowired
    private AbsentMapper absentMapper;

    /**
     * 展示缺寝学生列表
     * @return 缺寝学生列表
     */
    @Override
    public List<Absent> list() {
        return this.absentMapper.list();
    }

    /**
     * 指定信息模糊查询缺寝学生列表
     * @param key   指定的查询方式(1.寝室楼 2.寝室)
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    @Override
    public List<Absent> search(String key, String value) {
        if (key.equals("")) {//空查询，返回默认表单
            return this.absentMapper.list();
        }
        List<Absent> absentList = null;
        switch (key) {
            case "buildingName": {
                absentList = this.absentMapper.searchByBuildingName(value);
                break;
            }
            case "dormitoryName": {
                absentList = this.absentMapper.searchByDormitoryName(value);
                break;
            }
        }
        return absentList;
    }

    /**
     * 添加缺寝记录
     * @param absent 缺寝信息
     */
    @Override
    public void save(Absent absent) {
        try {
            this.absentMapper.save(absent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
