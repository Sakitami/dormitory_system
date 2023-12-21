package com.yskysoar.mapper;

import com.yskysoar.entity.DormitoryAdmin;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 20:58
 * @description 处理寝室管理员相关数据
 */
public interface DormitoryAdminMapper {

    /**
     * 根据用户名查询管理员信息
     * @param username 管理员用户名
     * @return 管理员用户名列表集
     */
    public DormitoryAdmin findByUserName(String username);

    /**
     * 新增寝室管理员
     * @param dormitoryAdmin 寝室管理员信息
     */
    public void saveUserToDormitory(DormitoryAdmin dormitoryAdmin);

    /**
     * 展示寝室管理员列表
     * @return 寝室管理员列表
     */
    public List<DormitoryAdmin> list();

    /**
     * 根据用户名模糊查找寝室管理员
     * @param value 模糊查询的数据
     * @return 查询的结果结合
     */
    public List<DormitoryAdmin> searchByUsername(String value);

    /**
     * 根据姓名模糊查找寝室管理员
     * @param value 模糊查询的数据
     * @return 查询的结果结合
     */
    public List<DormitoryAdmin> searchByName(String value);

    /**
     * 根据手机号模糊查找寝室管理员
     * @param value 模糊查询的数据
     * @return 查询的结果结合
     */
    public List<DormitoryAdmin> searchByTelephone(String value);

    /**
     * 新增寝室管理员
     * @param dormitoryAdmin 寝室管理员信息
     */
    public void save(DormitoryAdmin dormitoryAdmin);

    /**
     * 根据id删除寝室管理员
     * @param id 指定寝室管理员的id
     */
    public void delete(Integer id);

    /**
     * 更新寝室管理员
     * @param dormitoryAdmin 更新的寝室管理员信息
     */
    public void update(DormitoryAdmin dormitoryAdmin);

}