package com.doanchuyennganh.ungtuyenvnadmin.service;

import com.doanchuyennganh.ungtuyenvnadmin.entity.BaoCao;
import com.doanchuyennganh.ungtuyenvnadmin.repository.BaoCaoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoCaoService extends BaseService<BaoCao, Long> {
    private final BaoCaoRepository baoCaoRepository;
    protected BaoCaoService(BaoCaoRepository baseRepository) {
        super(baseRepository);
        this.baoCaoRepository = baseRepository;
    }

    @Override
    public BaoCao update(Long aLong, BaoCao model) {
        return null;
    }

    public List<BaoCao> layBaoCaoTheoMaNguoiDung(long maNguoiDung) {
        return baoCaoRepository.findByMaNguoiDung(maNguoiDung);
    }
}
