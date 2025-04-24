package com.shopgiayonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopgiayonline.entity.Category;
import com.shopgiayonline.model.dto.CategoryInfo;
import com.shopgiayonline.model.request.CreateCategoryReq;

@Service
public interface CategoryService {
    public List<Category> getListCategory();

    public List<CategoryInfo> getListCategoryAndProductCount();

    public Category createCategory(CreateCategoryReq req);

    public void updateCategory(int id, CreateCategoryReq req);

    public void deleteCategory(int id);
}
