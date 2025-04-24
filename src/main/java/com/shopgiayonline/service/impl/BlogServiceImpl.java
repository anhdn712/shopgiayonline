package com.shopgiayonline.service.impl;

import static com.shopgiayonline.config.Constant.DRAFT_POST;
import static com.shopgiayonline.config.Constant.LIMIT_POST_PER_PAGE;
import static com.shopgiayonline.config.Constant.PUBLIC_POST;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.github.slugify.Slugify;
import com.shopgiayonline.entity.Post;
import com.shopgiayonline.entity.User;
import com.shopgiayonline.exception.BadRequestException;
import com.shopgiayonline.exception.InternalServerException;
import com.shopgiayonline.exception.NotFoundException;
import com.shopgiayonline.model.dto.PageableDto;
import com.shopgiayonline.model.dto.PostInfoDto;
import com.shopgiayonline.model.request.CreatePostReq;
import com.shopgiayonline.repository.PostRepository;
import com.shopgiayonline.service.BlogService;
import com.shopgiayonline.util.PageUtil;

@Component
public class BlogServiceImpl implements BlogService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(CreatePostReq req, User user) {
        Post post = new Post();

        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        Slugify slg = new Slugify();
        post.setSlug(slg.slugify(req.getTitle()));
        post.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        post.setCreatedBy(user);

        if (req.getStatus() == PUBLIC_POST) {
            // Public post
            if (req.getDescription().isEmpty()) {
                throw new BadRequestException("Để công khai bài viết vui lòng nhập mô tả");
            }
            if (req.getImage().isEmpty()) {
                throw new BadRequestException("Vui lòng chọn ảnh cho bài viết trước khi công khai");
            }
            post.setPublishedAt(new Timestamp(System.currentTimeMillis()));
        } else {
            if (req.getStatus() != DRAFT_POST) {
                throw new BadRequestException("Trạng thái bài viết không hợp lệ");
            }
        }
        post.setDescription(req.getDescription());
        post.setThumbnail(req.getImage());
        post.setStatus(req.getStatus());

        postRepository.save(post);

        return post;
    }

    @Override
    public void updatePost(CreatePostReq req, User user, long id) {
        Optional<Post> rs = postRepository.findById(id);
        if (rs.isEmpty()) {
            throw new NotFoundException("Bài viết không tồn tại");
        }

        Post post = rs.get();
        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        Slugify slg = new Slugify();
        post.setSlug(slg.slugify(req.getTitle()));
        post.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        post.setModifiedBy(user);
        if (req.getStatus() == PUBLIC_POST) {
            // Public post
            if (req.getDescription().isEmpty()) {
                throw new BadRequestException("Để công khai bài viết vui lòng nhập mô tả");
            }
            if (req.getImage().isEmpty()) {
                throw new BadRequestException("Vui lòng chọn ảnh cho bài viết trước khi công khai");
            }
            if (post.getPublishedAt() == null) {
                post.setPublishedAt(new Timestamp(System.currentTimeMillis()));
            }
        } else {
            if (req.getStatus() != DRAFT_POST) {
                throw new BadRequestException("Trạng thái bài viết không hợp lệ");
            }
        }
        post.setDescription(req.getDescription());
        post.setThumbnail(req.getImage());
        post.setStatus(req.getStatus());

        try {
            postRepository.save(post);
        } catch (Exception ex) {
            throw new InternalServerException("Lỗi khi cập nhật bài viết");
        }
    }

    @Override
    public void deletePost(long id) {
        Optional<Post> rs = postRepository.findById(id);
        if (rs.isEmpty()) {
            throw new NotFoundException("Bài viết không tồn tại");
        }

        try {
            postRepository.delete(rs.get());
        } catch (Exception ex) {
            throw new InternalServerException("Lỗi khi xóa bài viết");
        }
    }

    @Override
    public Page<Post> getListPost(int page) {
        Page<Post> posts = postRepository.findAllByStatus(PUBLIC_POST, PageRequest.of(page, LIMIT_POST_PER_PAGE,
                Sort.by("publishedAt").descending().and(Sort.by("id").descending())));
        return posts;
    }

    @Override
    public Post getPostById(long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new NotFoundException("Không tìm thấy tin tức");
        }

        return post.get();
    }

    @Override
    public List<Post> getLatestPostsNotId(long id) {
        List<Post> posts = postRepository.getLatestPostsNotId(PUBLIC_POST, id, 8);
        return posts;
    }

    @Override
    public List<Post> getLatestPost() {
        List<Post> posts = postRepository.getLatestPosts(PUBLIC_POST, 8);
        return posts;
    }

    @Override
    public PageableDto adminGetListPost(String title, String status, int page, String order, String direction) {
        int limit = 15;
        PageUtil pageInfo = new PageUtil(limit, page);

        // Get list posts and totalItems
        List<PostInfoDto> posts = postRepository.adminGetListPost(title, status, limit, pageInfo.calculateOffset(),
                order, direction);
        int totalItems = postRepository.countPostFilter(title, status);

        int totalPages = pageInfo.calculateTotalPage(totalItems);

        return new PageableDto(posts, totalPages, pageInfo.getPage());
    }
}
