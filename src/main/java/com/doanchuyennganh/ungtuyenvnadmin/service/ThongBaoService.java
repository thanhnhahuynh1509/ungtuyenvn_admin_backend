package com.doanchuyennganh.ungtuyenvnadmin.service;

import com.doanchuyennganh.ungtuyenvnadmin.entity.ThongBao;
import com.doanchuyennganh.ungtuyenvnadmin.repository.ThongBaoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ThongBaoService extends BaseService<ThongBao, Long> {
    protected ThongBaoService(ThongBaoRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public ThongBao update(Long aLong, ThongBao model) {
        return null;
    }

}
