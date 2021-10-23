package com.nashtech.nashtech_shop.APIController.API;

import com.nashtech.nashtech_shop.APIController.exceptionHandler.APIHandlerException;
import com.nashtech.nashtech_shop.Service.CategoryService;
import com.nashtech.nashtech_shop.model.dto.CategoryDTO;
import com.nashtech.nashtech_shop.model.dto.SubCategoryDTO;

import com.nashtech.nashtech_shop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestControllerAdvice
@RestController
public class CategoryAPI {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/toann/public/api/1.0/categories", method = RequestMethod.GET)
    public ResponseEntity<?> getCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @RequestMapping(value = "/toann/public/api/1.0/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryByID(@PathVariable Integer id) {
        CategoryDTO categoryDTO = categoryService.findCategoryById(id);
        if (categoryDTO == null) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("Category " + id + "  Not Found "));
        }
        return ResponseEntity.ok(categoryDTO);

    }

    @RequestMapping(value = "/toann/public/api/1.0/subCategory/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSubCategoryByID(@PathVariable Integer id) {
        SubCategoryDTO subCategoryDTO = null;
        subCategoryDTO = categoryService.findSubCategoryById(id);
        if (subCategoryDTO == null) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("SubCategory " + id + "  Not Found "));
        }

        return ResponseEntity.ok(subCategoryDTO);
    }

    @PostMapping(value = "/toann/admin/api/1.0/Category/")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = null;
        category = categoryService.createCategory(categoryDTO.getImageUrl(), categoryDTO.getName());
        if (category == null) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("can't not creat Category " + categoryDTO.toString()));
        }

        return ResponseEntity.ok(category);
    }

    @PostMapping(value = "/toann/admin/api/1.0/SubCatgory/")
    public ResponseEntity<?> createSubCategory(@RequestBody SubCategoryDTO subCategoryDTO) {
        SubCategoryDTO subCategory = null;
        subCategory = categoryService.createSubCategory(subCategoryDTO.getName());
        if (subCategory == null) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("Can't not creat Category " + subCategoryDTO.toString()));
        }
        return ResponseEntity.ok(subCategory);
    }

    @PutMapping(value = "/toann/admin/api/1.0/Category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestParam(name = "value")List<String>categoryValues) {
        CategoryDTO category = null;
        Map<String, String> values = MyUtils.convertValueToMap(categoryValues);
        if (values != null) {
            category = categoryService.updateCategory(id, values);
            if (category == null) {
                return ResponseEntity.ok(APIHandlerException.NotFoundException("can't not update Category " + id));
            }
        } else {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("can't not update Category " + id));
        }
        return ResponseEntity.ok(category);
    }

    @PutMapping(value = "/toann/admin/api/1.0/SubCategory/{id}")
    public ResponseEntity<?> updateSubCategory(@PathVariable Integer id, @RequestParam(name = "value") List<String> subCategoryValues) {
        SubCategoryDTO subCategory = null;
        Map<String, String> values = MyUtils.convertValueToMap(subCategoryValues);
        if (values != null) {
            subCategory = categoryService.updateSubCategory(id, values);
            if (subCategory == null) {
                return ResponseEntity.ok(APIHandlerException.NotFoundException("can't not update SubCategory id " + id));
            }
        }else{
            return ResponseEntity.ok(APIHandlerException.NotFoundException("can't not update SubCategory id " + id));
        }
        return ResponseEntity.ok(subCategory);
    }
    @PutMapping(value = "/toann/admin/api/1.0/SubCategory/{id}/addSubCategory")
    public ResponseEntity<?> AddSubToCategory(@PathVariable Integer id, @RequestParam(name = "value") List<Integer> subCategoryValues) {
        CategoryDTO category = null;
            category = categoryService.addSubtoCatogory(id, subCategoryValues);
            if (category == null) {
                return ResponseEntity.ok(APIHandlerException.NotFoundException("can't not add SUbCategory   " +  subCategoryValues + " To Category " + id ));
            }

        return ResponseEntity.ok(category);
    }
    @PutMapping(value = "/toann/admin/api/1.0/SubCategory/{id}/addProduct")
    public ResponseEntity<?> AddProductToSubCategory(@PathVariable Integer id, @RequestParam(name = "value") List<Long> productIds) {
        SubCategoryDTO subCategory = null;
            subCategory = categoryService.addProucttoSubCatogory(id, productIds);
            if (subCategory == null) {
                return ResponseEntity.ok(APIHandlerException.NotFoundException("can't not add product "+productIds.toString() + " To SubCategory : "  + id));
            }

        return ResponseEntity.ok(subCategory);
    }
    @DeleteMapping(value = "/toann/admin/api/1.0/SubCategory/{id}/delete")
    public ResponseEntity<?> deleteSubCategory(@PathVariable Integer id){
        SubCategoryDTO subCategoryDTO = null ;
        subCategoryDTO = categoryService.deleteSubCategory(id);
        if(subCategoryDTO == null ){
            return ResponseEntity.ok(APIHandlerException.NotFoundException("can't Delete  SUbcategory "+ id ));
        }else{
            return ResponseEntity.ok(subCategoryDTO) ;
        }

    }
    @DeleteMapping(value = "/toann/admin/api/1.0/Category/{id}/delete")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        CategoryDTO categoryDTO = null ;
        categoryDTO = categoryService.deleteCategory(id);
        if(categoryDTO == null ){
            return ResponseEntity.ok(APIHandlerException.NotFoundException("can't Delete  SUbcategory "+ id ));
        }else{
            return ResponseEntity.ok(categoryDTO) ;
        }

    }
    @PutMapping(value = "/toann/admin/api/1.0/SubCategory/addProduct")
    public ResponseEntity<?> AddProduct( @RequestParam(name = "value") Map<String , String > productIds) {
        System.out.println(productIds);
        return ResponseEntity.ok(productIds);
    }

}
