package com.yskysoar.mapper;

import com.yskysoar.entity.Building;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 22:45
 * @description 处理寝室楼相关数据
 */
public interface BuildingMapper {

    /**
     * 展示寝室楼列表
     * @return 寝室楼列表结果集
     */
    public List<Building> list();

    /**
     * 根据名称模糊查询寝室楼
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    public List<Building> searchByName(String value);

    /**
     * 根据介绍模糊查询寝室楼
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    public List<Building> searchByIntroduction(String value);

    /**
     * 新增寝室楼
     * @param building 寝室楼信息
     */
    public void save(Building building);

    /**
     * 更新寝室楼信息
     * @param building 新的寝室楼信息
     */
    public void update(Building building);

    /**
     * 根据id删除寝室楼(对应寝室也进行删除，学生自动分配)
     * @param id 待删除寝室楼的id
     */
    public void delete(Integer id);

}
