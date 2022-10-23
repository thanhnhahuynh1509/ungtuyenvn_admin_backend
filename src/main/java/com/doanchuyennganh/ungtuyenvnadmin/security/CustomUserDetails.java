package com.doanchuyennganh.ungtuyenvnadmin.security;

import com.doanchuyennganh.ungtuyenvnadmin.entity.QuanLy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private final QuanLy quanLy;

    public CustomUserDetails(QuanLy quanLy) {
        this.quanLy = quanLy;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return quanLy.getMatKhau();
    }

    @Override
    public String getUsername() {
        return quanLy.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
