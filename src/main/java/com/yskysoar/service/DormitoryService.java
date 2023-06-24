package com.yskysoar.service;

import com.yskysoar.entity.Dormitory;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-22 21:04
 * @description
 */
public interface DormitoryService {
    public List<Dormitory> availableList();//可用寝室

    public List<Dormitory> list();

    public List<Dormitory> search(String key, String value);

    public void save(Dormitory dormitory);

    public void update(Dormitory dormitory);

    public void delete(Integer id);

    public List<Dormitory> findByBuildingId(Integer buildingId);
}
