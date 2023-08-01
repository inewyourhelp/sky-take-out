package com.sky.mapper;

import com.sky.dto.SetmealDTO;
import com.sky.entity.Setmeal;
import com.sky.dto.SetmealPageQueryDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author xiaolu
 * @date 2023/7/17 11:41
 */
@Mapper
public interface SetmealMapper {

    @Update("update catepory set type = #{type}  where id = #{id}")
    Integer updateById(Long id, Integer type);


    List<Setmeal> getSetmealPage(SetmealPageQueryDTO setmealPageQueryDTO);

    Integer addSetmeal(Setmeal setmeal);

    Integer updateSetmeal(SetmealDTO setmealDTO);

    @Delete("delete from setmeal where id = #{id}")
    Integer deleteSetmeal(Long id);
}
