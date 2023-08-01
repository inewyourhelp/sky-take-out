package com.sky.mapper;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Employee;
import com.sky.vo.CategoryVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * @author xiaolu
 * @date 2023/7/17 11:41
 */
@Mapper
public interface CateporyMapper {

    @Update("update catepory set type = #{type}  where id = #{id}")
    Integer updateById(Long id, Integer type);


    List<Category> getCategoryPage(CategoryVo categoryVo);

    Integer addCategory(Category category);

    Integer updateCategory(Category category);

    @Delete("delete from category where id = #{id}")
    Integer deleteCategory(Long id);
}
