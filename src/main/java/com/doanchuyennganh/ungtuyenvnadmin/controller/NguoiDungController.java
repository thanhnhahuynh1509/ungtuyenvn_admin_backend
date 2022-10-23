package com.doanchuyennganh.ungtuyenvnadmin.controller;

import com.doanchuyennganh.ungtuyenvnadmin.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvnadmin.service.BaseService;
import com.doanchuyennganh.ungtuyenvnadmin.service.NguoiDungService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nguoi_dung")
public class NguoiDungController extends BaseController<NguoiDung, Long> {

    private final NguoiDungService nguoiDungService;

    public NguoiDungController(NguoiDungService baseService) {
        super(baseService);
        this.nguoiDungService = baseService;
    }

    @PutMapping("/{id}/update_enabled")
    public NguoiDung updateEnabled(@PathVariable long id, @RequestBody NguoiDung nguoiDung) {
        return nguoiDungService.updateEnabled(id, nguoiDung.isEnabled());
    }
}
