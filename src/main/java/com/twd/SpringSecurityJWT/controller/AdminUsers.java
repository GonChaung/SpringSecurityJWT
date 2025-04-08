package com.twd.SpringSecurityJWT.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.twd.SpringSecurityJWT.dto.ReqRes;
import com.twd.SpringSecurityJWT.entity.Product;
import com.twd.SpringSecurityJWT.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminUsers {
    @Autowired
    public ProductRepo productRepo;

    @GetMapping("/public/product")
    public ResponseEntity<Object> getAllProducts() {
        return ResponseEntity.ok(productRepo.findAll());
    }

    @PostMapping("/admin/saveproduct")
    public ResponseEntity<Object> signUp(@RequestBody ReqRes productRequest) {
        Product productToSave = new Product();
        productToSave.setName(productRequest.getName());
        return ResponseEntity.ok(productRepo.save(productToSave));
    }

    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone() {
        return ResponseEntity.ok("User alone can access this API only!");
    }

    @GetMapping("/adminuser/both")
    public ResponseEntity<Object> bothAdminAndUserApi() {
        return ResponseEntity.ok("Both Admin and User can access this API");
    }
}
