package com.yskysoar.service;

import com.yskysoar.entity.DormitoryAdmin;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-19 21:03
 * @description 宿管管理所需业务的接口
 */
public interface DormitoryAdminService {
    public List<DormitoryAdmin> list();

    public List<DormitoryAdmin> search(String key, String value);

    public void save(DormitoryAdmin dormitoryAdmin);

    public void delete(Integer id);

    public void update(DormitoryAdmin dormitoryAdmin);


}
