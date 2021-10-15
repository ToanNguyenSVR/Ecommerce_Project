package com.nashtech.nashtech_shop.Service;

import com.nashtech.nashtech_shop.model.dto.CategoryDTO;
import com.nashtech.nashtech_shop.model.dto.SubCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public List<CategoryDTO> getAllCategory() ;
    public List<SubCategoryDTO> getAllSubCategory() ;

}
