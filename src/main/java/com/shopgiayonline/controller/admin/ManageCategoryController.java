package com.shopgiayonline.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopgiayonline.entity.Category;
import com.shopgiayonline.model.dto.CategoryInfo;
import com.shopgiayonline.model.request.CreateCategoryReq;
import com.shopgiayonline.service.CategoryService;

@Controller
public class ManageCategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/categories")
    public String getCategoryManagePage(Model model) {
        List<CategoryInfo> categories = categoryService.getListCategoryAndProductCount();
        model.addAttribute("categories", categories);

        return "admin/category/list";
    }

    @PostMapping("/api/admin/categories")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategoryReq req) {
        Category category = categoryService.createCategory(req);

        return ResponseEntity.ok(category);
    }

    @PutMapping("/api/admin/categories/{id}")
    public ResponseEntity<?> updateCategory(@Valid @RequestBody CreateCategoryReq req, @PathVariable int id) {
        categoryService.updateCategory(id, req);

        return ResponseEntity.ok("Cập nhật thành công");
    }

    @DeleteMapping("/api/admin/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);

        return ResponseEntity.ok("Xóa thành công");
    }
}
