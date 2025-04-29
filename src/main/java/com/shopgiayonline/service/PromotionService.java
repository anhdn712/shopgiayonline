package com.shopgiayonline.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.shopgiayonline.entity.Promotion;
import com.shopgiayonline.model.dto.ProductInfoDto;
import com.shopgiayonline.model.request.CreatePromotionReq;

@Service
public interface PromotionService {
    public List<ProductInfoDto> checkPublicPromotion(List<ProductInfoDto> products);

    public Promotion checkPublicPromotion();

    public Promotion checkPromotion(String code);

    public long calculatePromotionPrice(Long price, Promotion promotion);

    public Page<Promotion> adminGetListPromotion(String code, String name, String ispublic, String active, int page);

    public Promotion createPromotion(CreatePromotionReq req);

    public void updatePromotion(long id, CreatePromotionReq req);

    public void deletePromotion(long id);

    public Promotion getPromotionById(long id);

    public List<Promotion> getAllValidPromotion();
}
