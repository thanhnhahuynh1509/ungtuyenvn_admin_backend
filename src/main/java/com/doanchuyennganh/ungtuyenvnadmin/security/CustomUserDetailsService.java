package com.doanchuyennganh.ungtuyenvnadmin.security;

import com.doanchuyennganh.ungtuyenvnadmin.entity.QuanLy;
import com.doanchuyennganh.ungtuyenvnadmin.service.QuanLyService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final QuanLyService quanLyService;

    public CustomUserDetailsService(QuanLyService quanLyService) {
        this.quanLyService = quanLyService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QuanLy quanLy = quanLyService.getByEmail(username);
        return new CustomUserDetails(quanLy);
    }
}
