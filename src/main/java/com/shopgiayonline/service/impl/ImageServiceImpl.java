package com.shopgiayonline.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shopgiayonline.entity.Image;
import com.shopgiayonline.exception.BadRequestException;
import com.shopgiayonline.exception.InternalServerException;
import com.shopgiayonline.repository.ImageRepository;
import com.shopgiayonline.service.ImageService;

@Component
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void save(Image img) {
        imageRepository.save(img);
    }

    @Override
    public List<String> getListImageOfUser(long userId) {
        List<String> images = imageRepository.getListImageOfUser(userId);

        return images;
    }

    @Override
    @Transactional(rollbackFor = InternalServerException.class)
    public void deleteImage(String uploadDir, String filename) {
        String link = "/media/static/" + filename;
        Image img = imageRepository.findByLink(link);
        if (img == null) {
            throw new BadRequestException("File không tồn tại");
        }

        Integer inUse = imageRepository.checkImgInUse(link);
        if (inUse != null) {
            throw new BadRequestException("Ảnh đã được sử dụng không thể xóa");
        }

        imageRepository.delete(img);

        File file = new File(uploadDir + "/" + filename);
        if (file.exists()) {
            if (!file.delete()) {
                throw new InternalServerException("Lỗi khi xóa ảnh");
            }
        }
    }
}
