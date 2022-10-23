package com.doanchuyennganh.ungtuyenvnadmin.controller;

import com.doanchuyennganh.ungtuyenvnadmin.entity.ThongBao;
import com.doanchuyennganh.ungtuyenvnadmin.service.BaseService;
import com.doanchuyennganh.ungtuyenvnadmin.service.ThongBaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/thong_bao")
public class ThongBaoController extends BaseController<ThongBao, Long> {

    public ThongBaoController(ThongBaoService baseService) {
        super(baseService);
    }
}
