package com.doanchuyennganh.ungtuyenvnadmin.controller;

import com.doanchuyennganh.ungtuyenvnadmin.entity.BaoCao;
import com.doanchuyennganh.ungtuyenvnadmin.service.BaoCaoService;
import com.doanchuyennganh.ungtuyenvnadmin.service.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bao_cao")
public class BaoCaoController extends BaseController<BaoCao, Long> {

    private final BaoCaoService baoCaoService;
    public BaoCaoController(BaoCaoService baseService) {
        super(baseService);
        this.baoCaoService = baseService;
    }

    @GetMapping("/nguoi_dung/{maNguoiDung}")
    public List<BaoCao> layBaoCaoTheoMaNguoiDung(@PathVariable long maNguoiDung) {
        return baoCaoService.layBaoCaoTheoMaNguoiDung(maNguoiDung);
    }
}
