package com.shopgiayonline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopgiayonline.entity.Image;

@Service
public interface ImageService {
    public void save(Image img);

    public List<String> getListImageOfUser(long userId);

    public void deleteImage(String uploadDir, String filename);
}
