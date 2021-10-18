package com.nashtech.nashtech_shop.Service;

import com.nashtech.nashtech_shop.entity.Category;
import com.nashtech.nashtech_shop.entity.SubCategory;
import com.nashtech.nashtech_shop.model.dto.CategoryDTO;
import com.nashtech.nashtech_shop.model.dto.SubCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public interface CategoryService {
    public Stream<Object> getAllCategory() ;

    public SubCategory findSubCategoryById (int id );
    public Category findCategoryById (int id );


}
