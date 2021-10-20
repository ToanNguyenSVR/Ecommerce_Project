package com.nashtech.nashtech_shop.Service;

import com.nashtech.nashtech_shop.model.dto.CategoryDTO;
import com.nashtech.nashtech_shop.model.dto.SubCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public interface CategoryService {
    public Stream<Object> getAllCategory() ;

    public SubCategoryDTO findSubCategoryById (int id );
    public CategoryDTO findCategoryById (int id );
    public CategoryDTO createCategory( String imgUrl , String name  );
    public SubCategoryDTO createSubCategory( String name);

    public CategoryDTO updateCategory(int id , Map<String , String > value );
    public SubCategoryDTO updateSubCategory(int id , Map<String , String > value  );
    public CategoryDTO deleteCategory( int id );
    public SubCategoryDTO deleteSubCategory( int id  );
    public CategoryDTO addSubtoCatogory(int id , List<Integer> subId);
    public SubCategoryDTO addProucttoSubCatogory(int id , List<Long> productId);




}
