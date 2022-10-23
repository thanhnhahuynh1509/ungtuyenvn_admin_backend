package com.doanchuyennganh.ungtuyenvnadmin.service;

import com.doanchuyennganh.ungtuyenvnadmin.entity.QuanLy;
import com.doanchuyennganh.ungtuyenvnadmin.exception.NotFoundException;
import com.doanchuyennganh.ungtuyenvnadmin.repository.QuanLyRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class QuanLyService extends BaseService<QuanLy, Long> {

    private final QuanLyRepository quanLyRepository;
    private final PasswordEncoder passwordEncoder;

    public QuanLyService(QuanLyRepository quanLyRepository, PasswordEncoder passwordEncoder) {
        super(quanLyRepository);
        this.quanLyRepository = quanLyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean checkEmailExists(String email) {
        return quanLyRepository.findByEmail(email).isPresent();
    }
    public QuanLy getByEmail(String email) {
        return quanLyRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Không tìm thấy quản lý có email trên"));
    }

    @Override
    public QuanLy save(QuanLy model) {
        model.setMatKhau(passwordEncoder.encode(model.getMatKhau()));
        return super.save(model);
    }

    @Override
    public QuanLy update(Long id, QuanLy model) {
        QuanLy quanLy = getSingleResultById(id);
        quanLy.setDiaChi(model.getDiaChi());
        quanLy.setHo(model.getHo());
        quanLy.setTen(model.getTen());
        quanLy.setSoDienThoai(model.getSoDienThoai());
        quanLy.setNgaySinh(model.getNgaySinh());
        return quanLyRepository.save(quanLy);
    }
}
