package com.sky.controller.admin;


import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.result.Result;

import com.sky.service.SetmealService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaolu
 * @date 2023/7/17 11:36
 */
@RestController
@RequestMapping("/admin/setmeal")
@Slf4j
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    @ApiOperation(value = "修改套餐信息updateSetmeal")
    @PutMapping
    public Result<Integer> updateSetmeal(SetmealDTO setmealDTO) {
        Integer count = setmealService.updateSetmeal(setmealDTO);
        return Result.success(count);
    }

    @ApiOperation(value = "获取分类列表getSetmealList")
    @GetMapping("/page")
    public Result<PageResult> getSetmealList(SetmealPageQueryDTO setmealPageQueryDTO) {
        List<Setmeal> setmealList = setmealService.getSetmealList(setmealPageQueryDTO);
        return Result.success(new PageResult(setmealList.size(), setmealList));
    }

    @ApiOperation(value = "添加套餐分类")
    @PostMapping
    public Result<String> save(@RequestBody SetmealDTO setmealDTO) {
        log.info("新增分类：{}", setmealDTO);
        setmealService.addSetmeal(setmealDTO);
        return Result.success();
    }


    @ApiOperation(value = "修改分类状态")
    @PostMapping("/status/{status}")
    public Result<String> updateSetmealStatus(@PathVariable Integer status, Long id) {
        log.info("修改分类状态 ID:{} ", id);
        Integer i = setmealService.updateSetmealStatus(status, id);
        return Result.success();
    }

    @ApiOperation(value = "删除分类信息")
    @DeleteMapping
    public Result<String> delete(Long id) {
        log.info("删除分类信息 id:{} ", id);
        Integer i = setmealService.deleteSetmeal(id);
        return Result.success();
    }

//    @ApiOperation(value = "根据类型查询分类")
//    @GetMapping("/list")
//    public  Result<List<Setmeal>> findSetmealByType(Integer type){
//        log.info("根据类型查询分类 type:{}",type);
//        List<Setmeal> setmealList = setmealService.findSetmealByType(type);
//        return Result.success(setmealList);
//    }
}
