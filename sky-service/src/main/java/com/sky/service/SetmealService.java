package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.vo.CategoryVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaolu
 * @date 2023/7/17 11:39
 */

public interface CategoryService {

    public Integer updateCategory(Category category);

    public List<Category> getCategoryList(CategoryVo categoryVo);

    Integer addCategory(CategoryDTO categoryDTO);

    Integer updateCategoryStatus(Integer status,Long id);

    Integer deleteCategory(Long id);

    List<Category> findCategoryByType(Integer type);
}
