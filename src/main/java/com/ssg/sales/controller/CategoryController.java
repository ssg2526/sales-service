package com.ssg.sales.controller;

import com.ssg.sales.model.Category;
import com.ssg.sales.model.Item;
import com.ssg.sales.service.CategoryService;
import com.ssg.sales.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/category-service/api/v1")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST, value = "/addCategory")
    public ResponseEntity<String> createCategory(@RequestBody Category category, @RequestHeader Map<String, Object> headers) {
        categoryService.addCategory(category);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCategories")
    public ResponseEntity<List<Category>> getCategories(@RequestHeader Map<String, Object> headers){
        List<Category> categories = categoryService.getCategories();

        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/editCategory")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @RequestHeader Map<String, Object> headers) {
        categoryService.updateCategory(category);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
