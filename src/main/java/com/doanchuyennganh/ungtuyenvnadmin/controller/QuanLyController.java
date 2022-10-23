package com.doanchuyennganh.ungtuyenvnadmin.controller;

import com.doanchuyennganh.ungtuyenvnadmin.entity.QuanLy;
import com.doanchuyennganh.ungtuyenvnadmin.security.JWTProvider;
import com.doanchuyennganh.ungtuyenvnadmin.service.QuanLyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quan_ly")
public class QuanLyController extends BaseController<QuanLy, Long>{

    private final JWTProvider jwtProvider;
    private final QuanLyService quanLyService;

    public QuanLyController(QuanLyService baseService, JWTProvider jwtProvider) {
        super(baseService);
        this.jwtProvider = jwtProvider;
        this.quanLyService = baseService;
    }

    @PostMapping("/get_by_token")
    public QuanLy getByToken(@RequestBody String token) {
        String username = jwtProvider.getUsernameFromToken(token);
        return quanLyService.getByEmail(username);
    }

    @Override
    public ResponseEntity<QuanLy> save(@RequestBody QuanLy model) {
        if(quanLyService.checkEmailExists(model.getEmail())) {
            return ResponseEntity.ok(new QuanLy());
        }
        return super.save(model);
    }
}
