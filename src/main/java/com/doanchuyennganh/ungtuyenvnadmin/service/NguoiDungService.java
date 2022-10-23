package com.doanchuyennganh.ungtuyenvnadmin.service;

import com.doanchuyennganh.ungtuyenvnadmin.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvnadmin.repository.NguoiDungRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class NguoiDungService extends BaseService<NguoiDung, Long> {

    protected NguoiDungService(NguoiDungRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public NguoiDung update(Long id, NguoiDung model) {
        return null;
    }

    public NguoiDung updateEnabled(Long id, boolean status) {
        NguoiDung nguoiDung = getSingleResultById(id);
        nguoiDung.setEnabled(status);
        return baseRepository.save(nguoiDung);
    }
}
