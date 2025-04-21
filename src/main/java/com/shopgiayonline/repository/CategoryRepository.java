package com.shopgiayonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopgiayonline.entity.Category;
import com.shopgiayonline.model.dto.CategoryInfo;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(nativeQuery = true, name = "getListCategoryAndProductCount")
    public List<CategoryInfo> getListCategoryAndProductCount();

    @Query(nativeQuery = true, value = "Select 1 from product_category where category_id = ?1")
    public int checkProductInCategory(int id);
}
