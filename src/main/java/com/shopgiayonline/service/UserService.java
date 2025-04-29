package com.shopgiayonline.service;
import org.springframework.stereotype.Service;

import com.shopgiayonline.entity.User;
import com.shopgiayonline.model.request.ChangePasswordReq;
import com.shopgiayonline.model.request.CreateUserReq;
import com.shopgiayonline.model.request.UpdateProfileReq;

@Service
public interface UserService {
    public User createUser(CreateUserReq req);

    public void changePassword(User user, ChangePasswordReq req);

    public User updateProfile(User user, UpdateProfileReq req);
}
