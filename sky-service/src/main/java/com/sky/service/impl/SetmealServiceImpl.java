package com.sky.service.impl;

import com.github.pagehelper.PageHelper;
import com.sky.dto.CategoryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CateporyMapper;
import com.sky.service.CategoryService;
import com.sky.vo.CategoryVo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaolu
 * @date 2023/7/17 11:40
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CateporyMapper cateporyMapper;


    @Override
    public Integer updateCategory(Category category) {
        Long id = category.getId();
        Integer type = category.getType();
        Integer count = cateporyMapper.updateById(id, type);
        return count;
    }

    @Override
    public List<Category> getCategoryList(CategoryVo categoryVo) {
        PageHelper.startPage(categoryVo.getPage(), categoryVo.getPageSize());
        List<Category> categoryList = cateporyMapper.getCategoryPage(categoryVo);
        return categoryList;
    }

    @Override
    public Integer addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        category.setStatus(0);
        Integer count = cateporyMapper.addCategory(category);
        return count;
    }

    @Override
    public Integer updateCategoryStatus(Integer status,Long id) {
        Category category = new Category();
        category.setStatus(status);
        category.setId(id);
        Integer count = cateporyMapper.updateCategory(category);
        return count;
    }

    @Override
    public Integer deleteCategory(Long id) {
        Integer count = cateporyMapper.deleteCategory(id);
        return null;
    }

    @Override
    public List<Category> findCategoryByType(Integer type) {
        CategoryVo categoryVo =new CategoryVo();
        categoryVo.setType(type);
        List<Category> categoryList = cateporyMapper.getCategoryPage(categoryVo);
        return categoryList;
    }


}
