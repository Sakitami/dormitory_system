package com.yskysoar.service.impl;

import com.yskysoar.entity.Dormitory;
import com.yskysoar.mapper.DormitoryMapper;
import com.yskysoar.mapper.StudentMapper;
import com.yskysoar.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 21:05
 * @description 寝室管理的接口实现类
 */
@Service
public class DormitoryServiceImpl implements DormitoryService {
    //相关数据的注入
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询有空闲位置的寝室
     * @return 寝室列表集合
     */
    @Override
    @Transactional
    public List<Dormitory> availableList() {
        return this.dormitoryMapper.availableList();
    }

    /**
     * 展示所有的寝室列表
     * @return 所有的寝室列表
     */
    @Override
    public List<Dormitory> list() {
        return this.dormitoryMapper.list();
    }

    /**
     * 指定信息模糊查询寝室列表
     * @param key   指定的查询方式(1.名称 2.电话)
     * @param value 模糊查询的数据
     * @return 查询的结果结合
     */
    @Override
    public List<Dormitory> search(String key, String value) {
        if (value.equals("")) {
            return this.dormitoryMapper.list();
        }
        List<Dormitory> dormitoryList = null;
        switch (key) {
            case "name": {
                dormitoryList = this.dormitoryMapper.searchByName(value);
                break;
            }
            case "telephone": {
                dormitoryList = this.dormitoryMapper.searchByTelephone(value);
                break;
            }
        }
        return dormitoryList;
    }

    /**
     * 添加寝室
     * @param dormitory 寝室信息
     */
    @Override
    public void save(Dormitory dormitory) {
        try {
            this.dormitoryMapper.save(dormitory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新寝室信息
     * @param dormitory 待更新寝室信息
     */
    @Override
    public void update(Dormitory dormitory) {
        try {
            this.dormitoryMapper.update(dormitory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据指定寝室的id删除寝室(学生自动分配)
     * @param id 指定寝室的id
     */
    @Override
    public void delete(Integer id) {
        try {
            List<Integer> studentIdList = this.studentMapper.findStudentIdByDormitoryId(id);
            for (Integer studentId : studentIdList) {
                //给学生重新分配寝室
                Integer availableDormitoryId = this.dormitoryMapper.findAvailableDormitoryId();
                this.studentMapper.resetDormitoryId(studentId, availableDormitoryId);
                this.dormitoryMapper.subAvailable(availableDormitoryId);
            }
            //删除待删除的寝室
            this.dormitoryMapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据指定寝室楼id寻找寝室
     * @param buildingId 指定寝室楼的id
     * @return 寝室楼内所有寝室信息的结果集(包括寝室内的学生信息)
     */
    @Override
    public List<Dormitory> findByBuildingId(Integer buildingId) {
        return this.dormitoryMapper.findBuildingId(buildingId);
    }
}
