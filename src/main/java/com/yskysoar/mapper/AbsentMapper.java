package com.yskysoar.mapper;

import com.yskysoar.entity.Absent;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 21:59
 * @description 处理缺寝相关数据
 */
public interface AbsentMapper {
    /**
     * 展示缺寝学生列表
     * @return 学生列表
     */
    public List<Absent> list();

    /**
     * 根据寝室楼模糊查找缺寝记录
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    public List<Absent> searchByBuildingName(String value);

    /**
     * 根据寝室号模糊查找缺寝记录
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    public List<Absent> searchByDormitoryName(String value);

    /**
     * 新增寝室记录
     * @param absent 缺寝信息
     */
    public void save(Absent absent);
}
