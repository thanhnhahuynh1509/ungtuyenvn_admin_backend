package com.doanchuyennganh.ungtuyenvnadmin.repository;

import com.doanchuyennganh.ungtuyenvnadmin.entity.BaoCao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaoCaoRepository extends JpaRepository<BaoCao, Long> {

    @Override
    @Query("SELECT b FROM BaoCao b ORDER BY b.id DESC")
    List<BaoCao> findAll();

    @Query("SELECT b FROM BaoCao b WHERE b.nguoiDung.id = ?1 ORDER BY b.id DESC")
    List<BaoCao> findByMaNguoiDung(long maNguoiDung);
}
