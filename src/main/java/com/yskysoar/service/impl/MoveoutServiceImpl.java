package com.yskysoar.service.impl;

import com.yskysoar.entity.Moveout;
import com.yskysoar.mapper.MoveoutMapper;
import com.yskysoar.service.MoveoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 21:08
 * @description 迁出登记的接口实现类
 */
@Service
public class MoveoutServiceImpl implements MoveoutService {
    //相关数据的注入
    @Autowired
    private MoveoutMapper moveoutMapper;

    /**
     * 展示所有的学生列表
     * @return 所有的学生列表
     */
    @Override
    public List<Moveout> list() {
        return this.moveoutMapper.list();
    }

    /**
     * 指定信息模糊查询迁出学生
     * @param key   指定的查询方式(1.学号 2.姓名)
     * @param value 模糊查询的数据
     * @return 查询的数据集合
     */
    @Override
    public List<Moveout> search(String key, String value) {
        if (key.equals("")) {//空查询，返回默认表单
            return this.moveoutMapper.list();
        }
        List<Moveout> moveoutList = null;
        switch (key) {
            case "studentName": {
                moveoutList = this.moveoutMapper.searchByStudentName(value);
                break;
            }
            case "dormitoryName": {
                moveoutList = this.moveoutMapper.searchByDormitoryName(value);
                break;
            }
        }
        return moveoutList;
    }
}
