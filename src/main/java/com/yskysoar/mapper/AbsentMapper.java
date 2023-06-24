package com.yskysoar.mapper;

import com.yskysoar.entity.Absent;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 21:59
 * @description
 */
public interface AbsentMapper {
    /**
     * 展示缺寝学生列表
     * @return 学生列表
     */
    public List<Absent> list();

    /**
     * 指定楼宇模糊查询缺寝学生列表
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    public List<Absent> searchByBuildingName(String value);

    /**
     * 指定寝室模糊查询缺寝学生列表
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    public List<Absent> searchByDormitoryName(String value);

    /**
     * 添加缺寝记录
     * @param absent 缺寝信息
     */
    public void save(Absent absent);
}
