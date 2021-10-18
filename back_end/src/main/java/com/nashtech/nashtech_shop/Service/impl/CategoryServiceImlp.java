package com.nashtech.nashtech_shop.Service.impl;

import com.nashtech.nashtech_shop.Service.CategoryService;
import com.nashtech.nashtech_shop.entity.Category;
import com.nashtech.nashtech_shop.entity.SubCategory;
import com.nashtech.nashtech_shop.model.dto.CategoryDTO;
import com.nashtech.nashtech_shop.reponsitory.CategoryReponsitory;
import com.nashtech.nashtech_shop.reponsitory.SubCategoryReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CategoryServiceImlp implements CategoryService {
    @Autowired
    CategoryReponsitory categoryReponsitory;
    @Autowired
    SubCategoryReponsitory subCategoryReponsitory;

    @Override
    public Stream<Object> getAllCategory() {

        List<Category> categories = categoryReponsitory.findAll();
        for (Category category : categories) {
            category.setSubCategories(
                    subCategoryReponsitory.findSubCategoriesByCategoryId(category.getId())
            );
        }
        return categories.stream().map(
                CategoryDTO::toCategoryDTO
        );
    }


    @Override
    public SubCategory findSubCategoryById(int id) {
        return subCategoryReponsitory.getById(id);

    }

    @Override
    public Category findCategoryById(int id) {
        return categoryReponsitory.getById(id);

    }
}
