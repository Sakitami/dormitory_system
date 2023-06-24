package com.yskysoar.mapper;

import com.yskysoar.entity.Moveout;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 21:01
 * @description
 */
public interface MoveoutMapper {

    /**
     * 展示所有的学生列表
     * @return 学生列表
     */
    public List<Moveout> list();

    /**
     * 指定学号模糊查询迁出学生
     * @param value 学号
     * @return 查询的结果集合
     */
    public List<Moveout> searchByStudentName(String value);

    /**
     * 指定姓名模糊查询迁出学生
     * @param value 姓名
     * @return 查询的结果集合
     */
    public List<Moveout> searchByDormitoryName(String value);
}
