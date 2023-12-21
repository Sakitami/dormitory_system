package com.yskysoar.mapper;

import com.yskysoar.entity.Dormitory;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 21:01
 * @description 寝室相关数据
 */
public interface DormitoryMapper {
    /**
     * 查询有空闲位置的寝室
     *
     * @return 寝室列表集合
     */
    public List<Dormitory> availableList();

    /**
     * 指定寝室id的可用位置减一
     *
     * @param dormitoryId 寝室id
     */
    public void subAvailable(Integer dormitoryId);

    /**
     * 指定寝室id的可用位置加一
     *
     * @param dormitoryId 寝室id
     */
    public void addAvailable(Integer dormitoryId);

    /**
     * 查询指定楼宇id的所有寝室列表
     *
     * @param buildingId 楼宇id
     * @return 所有寝室列表
     */
    public List<Integer> findDormitoryByBuildingId(Integer buildingId);

    /**
     * 查询有空闲位置的寝室ID
     *
     * @return 寝室ID
     */
    public Integer findAvailableDormitoryId();

    /**
     * 删除指定id的寝室
     *
     * @param id 寝室id
     */
    public void delete(Integer id);

    /**
     * 展示所有的寝室列表
     *
     * @return 所有的寝室列表
     */
    public List<Dormitory> list();

    /**
     * 指定名称模糊查询寝室列表
     *
     * @param value 模糊查询的数据
     * @return 查询的结果结合
     */
    public List<Dormitory> searchByName(String value);

    /**
     * 指定介绍模糊查询寝室列表
     *
     * @param value 模糊查询的数据
     * @return 查询的结果结合
     */
    public List<Dormitory> searchByTelephone(String value);

    /**
     * 添加寝室
     *
     * @param dormitory 寝室信息
     */
    public void save(Dormitory dormitory);

    /**
     * 更新寝室信息
     *
     * @param dormitory 待更新寝室信息
     */
    public void update(Dormitory dormitory);

    /**
     * 根据指定楼宇id寻找寝室
     *
     * @param buildingId 指定楼宇的id
     * @return 楼宇内所有寝室信息的结果集(包括寝室内的学生信息)
     */
    public List<Dormitory> findBuildingId(Integer buildingId);

}
