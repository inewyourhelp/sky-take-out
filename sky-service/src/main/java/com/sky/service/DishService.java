package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;


import java.util.List;

/**
 * @author xiaolu
 * @date 2023/7/17 11:39
 */

public interface SetmealService {

    public Integer updateSetmeal(SetmealDTO setmealDTO);

    public List<Setmeal> getSetmealList(SetmealPageQueryDTO setmealPageQueryDTO);

    Integer addSetmeal(SetmealDTO setmealDTO);

    Integer updateSetmealStatus(Integer status,Long id);

    Integer deleteSetmeal(Long id);

}
