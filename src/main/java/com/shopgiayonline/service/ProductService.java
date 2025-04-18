package com.shopgiayonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopgiayonline.entity.Product;
import com.shopgiayonline.entity.ProductSize;
import com.shopgiayonline.model.dto.DetailProductInfoDto;
import com.shopgiayonline.model.dto.PageableDto;
import com.shopgiayonline.model.dto.ProductInfoDto;
import com.shopgiayonline.model.dto.ShortProductInfoDto;
import com.shopgiayonline.model.request.CreateProductReq;
import com.shopgiayonline.model.request.FilterProductReq;
import com.shopgiayonline.model.request.UpdateOnfeetImagesReq;
import com.shopgiayonline.model.request.UpdateSizeCountReq;

@Service
public interface ProductService {
    public List<ProductInfoDto> getListBestSellerProduct();

    public List<ProductInfoDto> getListNewProduct();

    public List<ProductInfoDto> getListSuggestProduct();

    public DetailProductInfoDto getDetailProductById(String id);

    public List<ProductInfoDto> getRelatedProducts(String id);

    public List<Integer> getListAvailableSize(String id);

    public PageableDto filterProduct(FilterProductReq req);

    public PageableDto searchProductByKeyword(String keyword, Integer page);

    public PageableDto adminGetListProduct(String id, String name, String category, String brand, String order,
            String direction, int page);

    public String createProduct(CreateProductReq req);

    public Product getProductById(String id);

    public void updateProduct(String id, CreateProductReq req);

    public void updateOnfeetImages(String id, UpdateOnfeetImagesReq req);

    public void updateSizeCount(UpdateSizeCountReq req);

    public void deleteProduct(String id);

    public List<ProductSize> getListSizeOfProduct(String id);

    public List<ShortProductInfoDto> getAllProduct();

    public List<ShortProductInfoDto> getAvailableProducts();

    public boolean checkProductSizeAvailable(String productId, int size);
}
