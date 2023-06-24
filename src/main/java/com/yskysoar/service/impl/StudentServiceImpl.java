package com.yskysoar.service.impl;

import com.yskysoar.entity.Moveout;
import com.yskysoar.entity.Student;
import com.yskysoar.mapper.DormitoryMapper;
import com.yskysoar.mapper.StudentMapper;
import com.yskysoar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 20:43
 * @description 学生业务的接口实现类
 */
@Service
public class StudentServiceImpl implements StudentService {
    //相关数据的注入
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    /**
     * 展示所有学生列表
     * @return 所有学生列表
     */
    @Override
    @Transactional
    public List<Student> list() {
        return this.studentMapper.list();
    }

    /**
     * 指定信息模糊查询学生列表
     * @param key 指定的查询方式(1.学号 2.姓名)
     * @param value 查询的结果集
     * @return 查询的结果集模糊查询的数据
     */
    @Override
    @Transactional
    public List<Student> search(String key, String value) {
        if (value.equals("")) {//空查询，返回默认表单
            return this.studentMapper.list();
        }
        List<Student> studentList = null;
        switch (key) {
            case "number": {
                studentList = this.studentMapper.searchByNumber(value);
                break;
            }
            case "name": {
                studentList = this.studentMapper.searchByName(value);
                break;
            }
        }
        return studentList;
    }

    /**
     * 添加学生
     * @param student 学生信息
     */
    @Override
    @Transactional
    public void save(Student student) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        student.setCreateDate(format.format(new Date()));
        try {
            this.studentMapper.save(student);
            this.dormitoryMapper.subAvailable(student.getDormitoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新学生信息
     * @param student 待更新的学生信息
     */
    @Override
    @Transactional
    public void update(Student student) {
        try {
            this.studentMapper.update(student);
            if (!student.getDormitoryId().equals(student.getOldDormitoryId())) {
                this.dormitoryMapper.subAvailable(student.getDormitoryId());
                this.dormitoryMapper.addAvailable(student.getOldDormitoryId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除学生信息
     * @param student 待删除学生信息
     */
    @Override
    @Transactional
    public void delete(Student student) {
        try {
            this.studentMapper.delete(student);
            this.dormitoryMapper.addAvailable(student.getDormitoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 展示所有的学生列表
     * @return 学生列表
     */
    @Override
    public List<Student> moveoutList() {
        return this.studentMapper.moveoutList();
    }

    /**
     * 指定信息模糊查询迁出学生
     * @param key 指定的查询方式(1.学号 2.姓名)
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    @Override
    public List<Student> searchForMoveoutList(String key, String value) {
        if (value.equals("")) {//空查询，返回默认表单
            return this.studentMapper.moveoutList();
        }
        List<Student> moveoutList = null;
        switch (key) {
            case "number": {
                moveoutList = this.studentMapper.searchForMoveoutByNumber(value);
                break;
            }
            case "name": {
                moveoutList = this.studentMapper.searchForMoveoutByName(value);
            }
        }
        return moveoutList;
    }

    /**
     * 迁出登记
     * @param moveout 迁出学生信息
     */
    @Override
    public void moveout(Moveout moveout) {
        try {
            this.dormitoryMapper.addAvailable(moveout.getDormitoryId());
            this.studentMapper.updateStateById(moveout.getStudentId());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            moveout.setCreateDate(format.format(new Date()));
            this.studentMapper.moveout(moveout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据指定寝室id查询对应学生列表
     * @param id 指定的寝室id
     * @return 学生列表
     */
    @Override
    public List<Student> findByDormitoryId(Integer id) {
        return this.studentMapper.findByDormitoryId(id);
    }
}
