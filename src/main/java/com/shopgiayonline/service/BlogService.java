package com.shopgiayonline.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.shopgiayonline.entity.Post;
import com.shopgiayonline.entity.User;
import com.shopgiayonline.model.dto.PageableDto;
import com.shopgiayonline.model.request.CreatePostReq;

@Service
public interface BlogService {
    public Post createPost(CreatePostReq req, User user);

    public void updatePost(CreatePostReq req, User user, long id);

    public void deletePost(long id);

    public Page<Post> getListPost(int page);

    public Post getPostById(long id);

    public List<Post> getLatestPostsNotId(long id);

    public List<Post> getLatestPost();

    public PageableDto adminGetListPost(String title, String status, int page, String order, String direction);
}
