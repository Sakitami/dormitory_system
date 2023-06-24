package com.yskysoar.service;

import com.yskysoar.entity.Moveout;
import com.yskysoar.entity.Student;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 20:41
 * @description 学生信息相关业务
 */
public interface StudentService {
    public List<Student> list();

    public List<Student> search(String key, String value);

    public void save(Student student);

    public void update(Student student);

    public void delete(Student student);

    public List<Student> moveoutList();

    public List<Student> searchForMoveoutList(String key, String value);

    public void moveout(Moveout moveout);

    public List<Student> findByDormitoryId(Integer id);
}
