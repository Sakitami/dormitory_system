package com.yskysoar.service;

import com.yskysoar.entity.Moveout;

import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-06-23 21:08
 * @description
 */

public interface MoveoutService {
    public List<Moveout> list();

    public List<Moveout> search(String key, String value);
}
