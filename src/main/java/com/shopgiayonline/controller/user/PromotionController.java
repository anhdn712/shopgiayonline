package com.shopgiayonline.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopgiayonline.entity.Promotion;
import com.shopgiayonline.exception.BadRequestException;
import com.shopgiayonline.model.dto.CheckPromotion;
import com.shopgiayonline.service.PromotionService;

@Controller
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("/api/check-hidden-promotion")
    public ResponseEntity<?> checkPromotion(@RequestParam String code) {
        if (code == null || code == "") {
            throw new BadRequestException("Mã code trống");
        }

        Promotion promotion = promotionService.checkPromotion(code);
        if (promotion == null) {
            throw new BadRequestException("Mã code không hợp lệ");
        }
        CheckPromotion checkPromotion = new CheckPromotion();
        checkPromotion.setDiscountType(promotion.getDiscountType());
        checkPromotion.setDiscountValue(promotion.getDiscountValue());
        checkPromotion.setMaximumDiscountValue(promotion.getMaximumDiscountValue());
        return ResponseEntity.ok(checkPromotion);
    }
}
