package com.yskysoar.mapper;

import com.yskysoar.entity.Building;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 22:45
 * @description 处理楼宇的数据
 */
public interface BuildingMapper {

    /**
     * 展示所有楼宇列表
     *
     * @return 楼宇列表结果集
     */
    public List<Building> list();

    /**
     * 指定名称模糊查询楼宇列表
     *
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    public List<Building> searchByName(String value);

    /**
     * 指定介绍模糊查询楼宇列表
     *
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    public List<Building> searchByIntroduction(String value);

    /**
     * 添加楼宇
     *
     * @param building 楼宇信息
     */
    public void save(Building building);

    /**
     * 更新楼宇信息
     *
     * @param building 新的楼宇信息
     */
    public void update(Building building);

    /**
     * 删除指定id的楼宇(对应寝室也进行删除，学生自动分配)
     *
     * @param id 待删除楼宇的id
     */
    public void delete(Integer id);

}
