package com.doanchuyennganh.ungtuyenvnadmin.controller;

import com.doanchuyennganh.ungtuyenvnadmin.entity.QuanLy;
import com.doanchuyennganh.ungtuyenvnadmin.security.JWTProvider;
import com.doanchuyennganh.ungtuyenvnadmin.service.QuanLyService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaiKhoanController {
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    private final QuanLyService quanLyService;

    public TaiKhoanController(AuthenticationManager authenticationManager, JWTProvider jwtProvider, QuanLyService quanLyService) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.quanLyService = quanLyService;
    }

    @PostMapping("/dang_nhap")
    public ResponseEntity<String> dangNhap(@RequestBody QuanLy quanLy) {
        Authentication upAuth = new UsernamePasswordAuthenticationToken(quanLy.getEmail(), quanLy.getMatKhau());
        Authentication authentication = authenticationManager.authenticate(upAuth);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok(jwtProvider.generateToken(authentication));
    }

    @PostMapping("/dang_ky")
    public ResponseEntity<String> dangKy(@RequestBody QuanLy quanLy) {
        if(quanLyService.checkEmailExists(quanLy.getEmail())) {
            return ResponseEntity.ok("Email đã được sử dụng");
        }
        quanLyService.save(quanLy);
        return ResponseEntity.ok("OK");
    }

}
