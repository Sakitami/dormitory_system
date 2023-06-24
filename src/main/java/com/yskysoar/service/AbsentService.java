package com.yskysoar.service;

import com.yskysoar.entity.Absent;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 21:56
 * @description
 */
public interface AbsentService {
    public List<Absent> list();

    public List<Absent> search(String key, String value);

    public void save(Absent absent);
}
