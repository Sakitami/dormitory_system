package com.yskysoar.mapper;

import com.yskysoar.entity.Dormitory;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 21:01
 * @description 处理寝室相关数据
 */
public interface DormitoryMapper {
    /**
     * 查找有空闲位置的寝室
     * @return 寝室列表集合
     */
    public List<Dormitory> availableList();

    /**
     * 根据寝室id减少一个可用位置
     * @param dormitoryId 寝室id
     */
    public void subAvailable(Integer dormitoryId);

    /**
     * 根据寝室id添加一个可用位置
     * @param dormitoryId 寝室id
     */
    public void addAvailable(Integer dormitoryId);

    /**
     * 根据寝室楼id展示寝室列表
     * @param buildingId 寝室楼id
     * @return 所有寝室列表
     */
    public List<Integer> findDormitoryByBuildingId(Integer buildingId);

    /**
     * 查找有空闲位置的寝室id
     * @return 寝室ID
     */
    public Integer findAvailableDormitoryId();

    /**
     * 根据id删除寝室
     * @param id 寝室id
     */
    public void delete(Integer id);

    /**
     * 展示寝室列表
     * @return 所有的寝室列表
     */
    public List<Dormitory> list();

    /**
     * 根据寝室名称模糊查找寝室
     * @param value 模糊查询的数据
     * @return 查询的结果结合
     */
    public List<Dormitory> searchByName(String value);

    /**
     * 根据寝室联系电话模糊查找寝室
     * @param value 模糊查询的数据
     * @return 查询的结果结合
     */
    public List<Dormitory> searchByTelephone(String value);

    /**
     * 新增寝室
     * @param dormitory 寝室信息
     */
    public void save(Dormitory dormitory);

    /**
     * 更新寝室
     * @param dormitory 待更新寝室信息
     */
    public void update(Dormitory dormitory);

    /**
     * 根据id查找寝室楼
     * @param buildingId 指定寝室楼的id
     * @return 寝室楼内所有寝室信息的结果集(包括寝室内的学生信息)
     */
    public List<Dormitory> findBuildingId(Integer buildingId);
}
