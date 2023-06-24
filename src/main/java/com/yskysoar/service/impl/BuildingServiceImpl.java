package com.yskysoar.service.impl;

import com.yskysoar.entity.Building;
import com.yskysoar.mapper.BuildingMapper;
import com.yskysoar.mapper.DormitoryMapper;
import com.yskysoar.mapper.StudentMapper;
import com.yskysoar.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 22:51
 * @description
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    //相关数据的注入
    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Building> list() {
        return buildingMapper.list();
    }

    /**
     * 指定信息模糊查询楼宇列表
     * @param key 指定的查询方式(1.名称 2.介绍)
     * @param value 模糊查询的数据
     * @return 查询的结果集合
     */
    @Override
    public List<Building> search(String key, String value) {
        if (value.equals("")) {//空查询
            return this.buildingMapper.list();
        }
        List<Building> buildingList = null;
        switch (key) {//判断查询方式
            case "name": {
                buildingList = this.buildingMapper.searchByName(value);
                break;
            }
            case "introduction": {
                buildingList = this.buildingMapper.searchByIntroduction(value);
                break;
            }
        }
        return buildingList;
    }

    /**
     * 添加楼宇
     * @param building 楼宇信息
     */
    @Override
    public void save(Building building) {
        try {
            this.buildingMapper.save(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新楼宇信息
     * @param building 新的楼宇信息
     */
    @Override
    public void update(Building building) {
        try {
            this.buildingMapper.update(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定id的楼宇(对应寝室也进行删除，学生自动分配)
     * @param id 待删除楼宇的id
     */
    @Override
    public void delete(Integer id) {
        try {
            //找到building包含的所有寝室
            List<Integer> dormitoryIdList = this.dormitoryMapper.findDormitoryByBuildingId(id);
            //找到寝室包含的所有学生
            for (Integer dormitoryId : dormitoryIdList) {
                List<Integer> studentIdList = this.studentMapper.findStudentIdByDormitoryId(dormitoryId);
                for (Integer studentId : studentIdList) {
                    //给学生重新分配寝室
                    Integer availableDormitoryId = this.dormitoryMapper.findAvailableDormitoryId();
                    this.studentMapper.resetDormitoryId(studentId, availableDormitoryId);
                    this.dormitoryMapper.subAvailable(availableDormitoryId);
                }
                //删除待删除的寝室
                this.dormitoryMapper.delete(dormitoryId);
            }
            //删除待删除的楼宇
            this.buildingMapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
