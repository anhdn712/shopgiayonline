package com.shopgiayonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopgiayonline.entity.Brand;
import com.shopgiayonline.model.dto.BrandInfo;
import com.shopgiayonline.model.request.CreateBrandReq;

@Service
public interface BrandService {
    public List<Brand> getListBrand();

    public List<BrandInfo> getListBrandAndProductCount();

    public Brand createBrand(CreateBrandReq req);

    public void updateBrand(int id, CreateBrandReq req);

    public void deleteBrand(int id);
}
