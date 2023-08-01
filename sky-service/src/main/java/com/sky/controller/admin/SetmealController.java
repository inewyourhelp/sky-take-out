package com.sky.controller.admin;


import com.sky.dto.CategoryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import com.sky.vo.CategoryVo;
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
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/update")
    public Result<Integer> updateCategory(Category category) {
        Integer count = categoryService.updateCategory(category);
        return Result.success(count);
    }

    @ApiOperation(value = "获取分类列表getCategoryList")
    @GetMapping("/page")
    public Result<PageResult> getCategoryList(CategoryVo categoryVo) {
        List<Category> categoryList = categoryService.getCategoryList(categoryVo);
        return Result.success(new PageResult(categoryList.size(), categoryList));
    }

    @ApiOperation(value = "添加菜品分类")
    @PostMapping
    public Result<String> save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增分类：{}", categoryDTO);
        categoryService.addCategory(categoryDTO);
        return Result.success();
    }


    @ApiOperation(value = "修改分类状态")
    @PostMapping("/status/{status}")
    public Result<String> updateCategoryStatus(@PathVariable Integer status,Long id){
        log.info("修改分类状态 ID:{} ",id);
       Integer i = categoryService.updateCategoryStatus(status,id);
        return Result.success();
    }

    @ApiOperation(value = "删除分类信息")
    @DeleteMapping
    public  Result<String> delete(Long id){
        log.info("删除分类信息 id:{} ",id);
        Integer i = categoryService.deleteCategory(id);
        return Result.success();
    }

    @ApiOperation(value = "根据类型查询分类")
    @GetMapping("/list")
    public  Result<List<Category>> findCategoryByType(Integer type){
        log.info("根据类型查询分类 type:{}",type);
        List<Category> categoryList = categoryService.findCategoryByType(type);
        return Result.success(categoryList);
    }
}
