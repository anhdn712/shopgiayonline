package com.shopgiayonline.model.mapper;

import java.util.ArrayList;

import com.github.slugify.Slugify;
import com.shopgiayonline.entity.Brand;
import com.shopgiayonline.entity.Category;
import com.shopgiayonline.entity.Product;
import com.shopgiayonline.model.dto.DetailProductInfoDto;
import com.shopgiayonline.model.request.CreateProductReq;

public class ProductMapper {
    public static DetailProductInfoDto toDetailProductInfoDto(Product product) {
        DetailProductInfoDto rs = new DetailProductInfoDto();
        rs.setId(product.getId());
        rs.setBrand(product.getBrand());
        rs.setDescription(product.getDescription());
        rs.setName(product.getName());
        rs.setSlug(product.getSlug());
        rs.setOnfeetImages(product.getOnfeetImages());
        rs.setProductImages(product.getProductImages());
        rs.setTotalSold(product.getTotalSold());
        rs.setPrice(product.getPrice());

        return rs;
    }

    public static Product toProduct(CreateProductReq req) {
        Product product = new Product();
        product.setName(req.getName());
        product.setDescription(req.getDescription());
        product.setPrice(req.getPrice());
        product.setAvailable(req.isAvailable());
        product.setProductImages(req.getProductImages());
        // Gen slug
        Slugify slg = new Slugify();
        product.setSlug(slg.slugify(req.getName()));
        // Set brand
        Brand brand = new Brand();
        brand.setId(req.getBrandId());
        product.setBrand(brand);
        // Set category
        ArrayList<Category> categories = new ArrayList<Category>();
        for (Integer id : req.getCategoryIds()) {
            Category category = new Category();
            category.setId(id);
            categories.add(category);
        }
        product.setCategories(categories);

        return product;
    }
}
