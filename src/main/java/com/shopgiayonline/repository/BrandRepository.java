package com.shopgiayonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopgiayonline.entity.Brand;
import com.shopgiayonline.model.dto.BrandInfo;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Query(nativeQuery = true, name = "getListBrandAndProductCount")
    public List<BrandInfo> getListBrandAndProductCount();
}
