package com.yskysoar.mapper;

import com.yskysoar.entity.Moveout;
import com.yskysoar.entity.Student;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 20:34
 * @description 处理学生相关数据
 */
public interface StudentMapper {
    /**
     * 展示所有学生列表
     *
     * @return 学生列表
     */
    public List<Student> list();

    /**
     * 指定学号模糊查询学生列表
     *
     * @param value 学号
     * @return 学生列表
     */
    public List<Student> searchByNumber(String value);

    /**
     * 指定姓名模糊查询学生列表
     *
     * @param value 姓名
     * @return 学生列表
     */
    public List<Student> searchByName(String value);

    /**
     * 添加学生
     *
     * @param student 学生信息
     */
    public void save(Student student);

    /**
     * 更新学生信息
     *
     * @param student 待更新的学生信息
     */
    public void update(Student student);

    /**
     * 删除学生信息
     *
     * @param student 待删除学生信息
     */
    public void delete(Student student);

    /**
     * 根据指定寝室id查询对应学生列表
     *
     * @param dormitoryId 指定的寝室id
     * @return 查询的学生列表结果集合
     */
    public List<Integer> findStudentIdByDormitoryId(Integer dormitoryId);

    /**
     * 重新分配学生
     *
     * @param studentId   待分配学生id
     * @param dormitoryId 寝室id
     */
    public void resetDormitoryId(Integer studentId, Integer dormitoryId);

    /**
     * 展示所有的学生列表
     *
     * @return 学生列表
     */
    public List<Student> moveoutList();

    /**
     * 指定学号模糊查询迁出学生
     *
     * @param value 学号
     * @return 查询的结果集合
     */
    public List<Student> searchForMoveoutByNumber(String value);

    /**
     * 指定姓名模糊查询迁出学生
     *
     * @param value 姓名
     * @return 查询的结果集合
     */
    public List<Student> searchForMoveoutByName(String value);

    /**
     * 根据学生id修改状态
     *
     * @param id 学生id
     */
    public void updateStateById(Integer id);

    /**
     * 迁出登记
     *
     * @param moveout 迁出学生信息
     */
    public void moveout(Moveout moveout);

    /**
     * 根据寝室id查询学生
     *
     * @param id 寝室id
     * @return 学生列表
     */
    public List<Student> findByDormitoryId(Integer id);

}
