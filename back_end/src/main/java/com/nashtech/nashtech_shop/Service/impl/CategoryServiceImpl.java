package com.nashtech.nashtech_shop.Service.impl;

import com.nashtech.nashtech_shop.Service.CategoryService;
import com.nashtech.nashtech_shop.entity.Category;
import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.StatusCategory;
import com.nashtech.nashtech_shop.entity.SubCategory;
import com.nashtech.nashtech_shop.model.dto.CategoryDTO;
import com.nashtech.nashtech_shop.model.dto.SubCategoryDTO;
import com.nashtech.nashtech_shop.reponsitory.CategoryReponsitory;
import com.nashtech.nashtech_shop.reponsitory.ProductReponsitory;
import com.nashtech.nashtech_shop.reponsitory.StatusCategoryReponsitory;
import com.nashtech.nashtech_shop.reponsitory.SubCategoryReponsitory;
import com.nashtech.nashtech_shop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryReponsitory categoryReponsitory;
    @Autowired
    SubCategoryReponsitory subCategoryReponsitory;
    @Autowired
    StatusCategoryReponsitory statusCategoryReponsitory;
    @Autowired
    ProductReponsitory productReponsitory;


    @Override
    public Stream<Object> getAllCategory() {

        List<Category> categories = categoryReponsitory.findAll(MyUtils.UnActive);
        for (Category category : categories) {
            category.setSubCategories(
                    subCategoryReponsitory.findByCategoryId(category.getId() , MyUtils.UnActive)
            );
        }
        return categories.stream().map(
                CategoryDTO::toCategoryDTO
        );
    }


    @Override
    public SubCategoryDTO findSubCategoryById(int id) {
        SubCategory subCategory = subCategoryReponsitory.findById(id ,MyUtils.UnActive);
        if (subCategory == null) {
            return null;
        }
        return SubCategoryDTO.ToSubCategoryDTO(subCategory);
    }

    @Override
    public CategoryDTO findCategoryById(int id) {
        Category category = categoryReponsitory.getById(id);
        if (category == null) {
            return null;
        }
        return CategoryDTO.toCategoryDTO(category);
    }

    @Override
    public CategoryDTO createCategory(String imgUrl, String name) {

        Category category = new Category(0, imgUrl, name, statusCategoryReponsitory.findByStatus(MyUtils.Active), null);
        categoryReponsitory.save(category);
        return CategoryDTO.toCategoryDTO(category);

    }

    @Override
    public SubCategoryDTO createSubCategory(String name) {

        SubCategory subCategory = new SubCategory(0, name, statusCategoryReponsitory.findByStatus(MyUtils.Active), null, null);
        subCategoryReponsitory.save(subCategory);
        return SubCategoryDTO.ToSubCategoryDTO(subCategory);

    }

    @Override
    public CategoryDTO updateCategory(int id, Map<String, String> value) {
        Category category = categoryReponsitory.getById(id);
        boolean updated = false;
        try {
            if (category != null) {
                for (String type : value.keySet()) {
                    switch (type.toLowerCase()) {
                        case "name":
                            category.setName(value.get(type));
                            updated = true;
                            break;
                        case "imageurl":
                            category.setImageUrl(value.get(type));
                            updated = true;
                            break;
                        case "statusid":
                            int statusID = Integer.parseInt(value.get(type));
                            StatusCategory statusCategory = statusCategoryReponsitory.getById(statusID);
                            category.setStatusCategory(statusCategory);
                            updated = true;
                    }

                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return ((updated) ? CategoryDTO.toCategoryDTO(categoryReponsitory.save(category)) : null);
    }

    @Override
    public SubCategoryDTO updateSubCategory(int id, Map<String, String> value) {
        SubCategory subCategory = subCategoryReponsitory.getById(id);
        boolean updated = false;
        try {
            if (subCategory != null) {
                for (String type : value.keySet()) {
                    switch (type.toLowerCase()) {
                        case "name":
                            subCategory.setName(value.get(type));
                            updated = true;
                            break;
                        case "statusId":
                            int statusID = Integer.parseInt(value.get(type));
                            StatusCategory statusCategory = statusCategoryReponsitory.getById(statusID);
                            subCategory.setStatusSubCategory(statusCategory);
                            updated = true;
                    }
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();

        }
        return ((updated) ? SubCategoryDTO.ToSubCategoryDTO(subCategoryReponsitory.save(subCategory)) : null);

    }


    @Override
    public CategoryDTO deleteCategory(int id) {
        Category category = categoryReponsitory.getById(id);

        StatusCategory statusCategory = statusCategoryReponsitory.findByStatus(MyUtils.UnActive);
        if (category != null) {
            category.setStatusCategory(statusCategory);
            categoryReponsitory.save(category);
        }
        return CategoryDTO.toCategoryDTO(category);
    }

    @Override
    public SubCategoryDTO deleteSubCategory(int id) {
        SubCategory subCategory = subCategoryReponsitory.getById(id);

        StatusCategory statusCategory = statusCategoryReponsitory.findByStatus(MyUtils.UnActive);
        if (subCategory != null) {
            subCategory.setStatusSubCategory(statusCategory);
            subCategoryReponsitory.save(subCategory);
        }
        return SubCategoryDTO.ToSubCategoryDTO(subCategory);
    }

    @Override
    public CategoryDTO addSubtoCatogory(int id, List<Integer> subIds) {
        Category category;
        CategoryDTO result = null;

        List<SubCategory> subCategories;
        if (id != -1) {
            category = categoryReponsitory.getById(id);
            subCategories = category.getSubCategories();
            for (Integer subId : subIds) {
                SubCategory subCategory = subCategoryReponsitory.getById(subId);
                subCategories.add(subCategory);
            }
            category.setSubCategories(subCategories);
            result = CategoryDTO.toCategoryDTO(categoryReponsitory.save(category));

        }


        return result;
    }

    @Override
    public SubCategoryDTO addProucttoSubCatogory(int id, List<Long> productIds) {
        SubCategory subCategory;
        SubCategoryDTO result = null;
        List<Product> products;
        if (id != -1) {
            subCategory = subCategoryReponsitory.getById(id);
            products = subCategory.getProducts();
            for (Long productId : productIds) {
                Product product = productReponsitory.getById(productId);
                    products.add(product);
            }
            subCategory.setProducts(products);
            result = SubCategoryDTO.ToSubCategoryDTO(subCategoryReponsitory.save(subCategory));
        }

        return result;
    }


}
