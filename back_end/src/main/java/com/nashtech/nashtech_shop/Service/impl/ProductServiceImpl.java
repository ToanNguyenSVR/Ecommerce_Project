package com.nashtech.nashtech_shop.Service.impl;


import com.nashtech.nashtech_shop.Service.ProductService;

import com.nashtech.nashtech_shop.entity.*;

import com.nashtech.nashtech_shop.model.dto.ProductDTO;

import com.nashtech.nashtech_shop.model.dto.ProductImageDTO;
import com.nashtech.nashtech_shop.reponsitory.*;

import com.nashtech.nashtech_shop.utils.MyUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductReponsitory productReponsitory;

    @Autowired
    ProductImageReponsitory productImageReponsitory;

    @Autowired
    BrandReponsitory brandReponsitory;
    @Autowired
    SubCategoryReponsitory subCategoryReponsitory;
    @Autowired
    PromotionReponsitory promotionReponsitory;
    @Autowired
    StatusProductReponsitory statusProductReponsitory;


    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOS = null;
        List<Product> products = null;
        try {
            products = productReponsitory.findAll();
            if (products != null) {
                productDTOS = products.stream().map(ProductDTO::ToProductDTO
                ).collect(Collectors.toList());
            }
        } catch (Exception e) {
            throw e;
        }
        return productDTOS;
    }

    @Override
    public List<ProductDTO> searchProduct(String key, Map<String, Integer> value) {
        List<ProductDTO> result = null;
        List<Product> products = null;
        boolean haveType = false;
        try {
            for (String type : MyUtils.searchType) {
                if (value.containsKey(type.toLowerCase())) {
                    haveType = true;

                }
            }
            if (haveType) {
                products = findProductByType(key, value);

            } else {
                if (value.containsKey(" ")) {
                    products = productReponsitory.findProductsByName("%" + key + "%");
                }
            }
            if (products != null && !products.isEmpty()) {
                result = products.stream().map(ProductDTO::ToProductDTO).collect(Collectors.toList());
            }


        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    private List<Product> findProductByType(String key, Map<String, Integer> value) {
        List<Product> result = null;

        for (String type : value.keySet()) {
            switch (type.trim().toLowerCase()) {
                case "category":
                    result = productReponsitory.getProductsByCategory("%" + key + "%", value.get(type));
                    break;
                case "subcategory":
                    result = productReponsitory.getProductsBySubID("%" + key + "%", value.get(type));
                    break;
                case "brand":
                    result = productReponsitory.getProductsByBrandId("%" + key + "%", value.get(type));
                    break;
                case "promotion":
                    result = productReponsitory.findProductsByPromotionId(value.get(type));
                    break;
            }

        }
        return result;
    }

    @Override
    public ProductDTO findById(Long id) {
        return ProductDTO.ToProductDTO(productReponsitory.findById(id).get());
    }

    @Override
    public ProductDTO createProduct(ProductDTO product, String[] imageUrl) throws Exception {
        Product result = null;
        Brand brand = null;
        SubCategory subCategory = null;
        Promotion promotion = null;
        try {
            brand = (product.getBrand().equals("null")) ?
                    null : brandReponsitory.findById(
                    Integer.parseInt(product.getBrand().trim()));
            subCategory = product.getSubCategory().equals("null") ?
                    null : subCategoryReponsitory.findById(
                    Integer.parseInt(product.getSubCategory().trim()), MyUtils.UnActive);
            promotion = product.getPromotion().equals("null") ?
                    null : promotionReponsitory.findById(
                    Long.parseLong(product.getPromotion().trim())).get();
            result = new Product(null
                    , product.getName()
                    , product.getPrice()
                    , product.getDecription()
                    , product.getImage()
                    , product.getSold()
                    , product.getQuantity()
                    , product.getCreateDate()
                    , null
                    , null
                    , subCategory
                    , statusProductReponsitory.findById(MyUtils.StatusNew).get()
                    , promotion
                    , brand
                    , null);
            result = productReponsitory.save(result);
            Boolean isCreateed = create(result.getId(), imageUrl);
            if (!isCreateed) {
                throw new Exception("Can't Not Add image to Product " + result.getId());
            }
        } finally {
            return ProductDTO.ToProductDTO(result);
        }

    }

    private Product updateProductByProperty(Product product, Map<String, String> values) {

        Product result = null;
        Boolean updated = false;
        for (String type : values.keySet()) {
            switch (type.trim().toLowerCase()) {
                case "subcategory":
                    product.setSubCategory(subCategoryReponsitory.getById(Integer.parseInt(values.get(type))));
                    updated = true;
                    break;
                case "brand":
                    product.setBrand(brandReponsitory.getById(Integer.parseInt(values.get(type))));
                    updated = true;
                    break;
                case "name":
                    product.setName(values.get(type));
                    updated = true;
                    break;
                case "price":
                    product.setPrice(Double.parseDouble(values.get(type)));
                    updated = true;
                    break;
                case "decription":
                    product.setDecription(values.get(type));
                    updated = true;
                    break;
                case "image":
                    product.setImage(values.get(type));
                    updated = true;
                    break;
                case "quantity":
                    product.setQuantity(Integer.parseInt(values.get(type)));
                    updated = true;
                    break;
                case "promotion":
                    product.setPromotion(promotionReponsitory.findById(Long.parseLong(values.get(type))).get());
                    updated = true;
                    break;
            }
        }
        if (updated) {
            result = product;
        }
        return result;
    }

    @Override
    public ProductDTO updateProduct(Long id, Map<String, String> value) {
        ProductDTO result = null;
        Product product = null;
        Boolean haveValue = false;

        product = productReponsitory.getById(id);
        for (String type : MyUtils.productProperty) {
            if (value.containsKey(type.toLowerCase())) {
                haveValue = true;

            }
        }
        if (haveValue) {
            product = updateProductByProperty(product, value);
            result = product != null ? ProductDTO.ToProductDTO(product) : null;
        }

        return result;

    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        Product productEntity = productReponsitory.findById(id).get();
        productEntity.setStatusProduct(statusProductReponsitory.findById(MyUtils.StatusDelete).get());
        return ProductDTO.ToProductDTO(productReponsitory.save(productEntity));

    }


    @Override
    public List<ProductImageDTO> findByProductID(Long id) {
        List<ProductImage> list = productImageReponsitory.findByProductId(id);
        return list.stream().map(ProductImageDTO::ToProductImageDTO).collect(Collectors.toList());
    }

    @Override
    public boolean create(Long id, String[] urls) {
        boolean result = false;
        if (id == -1) {
            return false;
        }
        Product product = productReponsitory.getById(id);
        List<ProductImage> productImages = product.getProductImages();
        for (String url : urls) {
            ProductImage productImage = new ProductImage(null, url, product);
            if (productImages == null ) {
                productImages = new ArrayList<>();
            }
            productImages.add(productImage);
            productImageReponsitory.save(productImage);
            result = true;

        }

        productReponsitory.save(product);

        return result;
    }

    @Override
    public boolean update(Map<Long, String> urls) {
        boolean result = false;
        try {
            for (Long imageId : urls.keySet()) {
                ProductImage image = productImageReponsitory.findById(imageId).get();

                image.setImageUrl(urls.get(imageId));
                productImageReponsitory.save(image);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
