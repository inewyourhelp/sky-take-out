package com.sky.service.impl;

import com.github.pagehelper.PageHelper;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.mapper.SetmealMapper;
import com.sky.service.SetmealService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaolu
 * @date 2023/7/17 11:40
 */
@Service
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealMapper setmealMapper;


    @Override
    public Integer updateSetmeal(SetmealDTO setmealDTO) {
        Integer count = setmealMapper.updateSetmeal(setmealDTO);
        return count;
    }

    @Override
    public List<Setmeal> getSetmealList(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageHelper.startPage(setmealPageQueryDTO.getPage(), setmealPageQueryDTO.getPageSize());
        List<Setmeal> setmealList = setmealMapper.getSetmealPage(setmealPageQueryDTO);
        return setmealList;
    }

    @Override
    public Integer addSetmeal(SetmealDTO setmealDTO) {
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO, setmeal);
        setmeal.setStatus(0);
        Integer count = setmealMapper.addSetmeal(setmeal);
        return count;
    }

    @Override
    public Integer updateSetmealStatus(Integer status, Long id) {
        SetmealDTO setmeal = new SetmealDTO();
        setmeal.setStatus(status);
        setmeal.setId(id);
        Integer count = setmealMapper.updateSetmeal(setmeal);
        return count;
    }

    @Override
    public Integer deleteSetmeal(Long id) {
        Integer count = setmealMapper.deleteSetmeal(id);
        return null;
    }


}
