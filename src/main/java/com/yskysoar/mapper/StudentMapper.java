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
     * @return 学生列表
     */
    public List<Student> list();

    /**
     * 根据姓名模糊查询学生
     * @param value 姓名
     * @return 学生列表
     */
    public List<Student> searchByName(String value);

    /**
     * 根据学号模糊查询学生
     * @param value 学号
     * @return 学生列表
     */
    public List<Student> searchByNumber(String value);

    /**
     * 新增学生
     * @param student 学生信息
     */
    public void save(Student student);

    /**
     * 更新学生
     * @param student 待更新的学生信息
     */
    public void update(Student student);

    /**
     * 删除学生
     * @param student 待删除学生信息
     */
    public void delete(Student student);

    /**
     * 根据寝室id展示寝室内学生
     * @param dormitoryId 指定的寝室id
     * @return 查询的学生列表结果集合
     */
    public List<Integer> findStudentIdByDormitoryId(Integer dormitoryId);

    /**
     * 重新分配学生
     * @param studentId   待分配学生id
     * @param dormitoryId 寝室id
     */
    public void resetDormitoryId(Integer studentId, Integer dormitoryId);

    /**
     * 展示迁出学生列表
     * @return 学生列表
     */
    public List<Student> moveoutList();

    /**
     * 根据学号模糊查找迁出学生
     * @param value 学号
     * @return 查询的结果集合
     */
    public List<Student> searchForMoveoutByNumber(String value);

    /**
     * 根据姓名模糊查找迁出学生
     * @param value 姓名
     * @return 查询的结果集合
     */
    public List<Student> searchForMoveoutByName(String value);

    /**
     * 根据学生id更新状态
     * @param id 学生id
     */
    public void updateStateById(Integer id);

    /**
     * 迁出登记
     * @param moveout 迁出学生信息
     */
    public void moveout(Moveout moveout);

    /**
     * 根据寝室id查找学生
     * @param id 寝室id
     * @return 学生列表
     */
    public List<Student> findByDormitoryId(Integer id);

}
