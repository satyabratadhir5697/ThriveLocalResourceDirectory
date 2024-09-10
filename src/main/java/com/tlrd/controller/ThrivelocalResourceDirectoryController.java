package com.tlrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlrd.model.Category;
import com.tlrd.service.UniteUsService;


@RestController
@RequestMapping("/api/tlrd")
public class ThrivelocalResourceDirectoryController {

	@Autowired
    private UniteUsService uniteUsService;

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return uniteUsService.getCategories();
    }
    

}
