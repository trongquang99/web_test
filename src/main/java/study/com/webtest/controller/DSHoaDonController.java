package study.com.webtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.com.webtest.model.HoaDon;
import study.com.webtest.service.HoaDonService;

import java.util.List;

@RestController
public class DSHoaDonController {
    private final HoaDonService hoaDonService;

    public DSHoaDonController(HoaDonService hoaDonService) {
        this.hoaDonService = hoaDonService;
    }

    @GetMapping("api/ds/hoadon")
    public List<HoaDon> layDanhSachHoaDonTheoTenVaGia(
            @RequestParam(name = "ten_sp", required = false) String tenSp,
            @RequestParam(name = "ten_kh", required = false) String tenKh,
            @RequestParam(name = "gia", required = false) Float gia
    ){
        List<HoaDon> response = hoaDonService.layDanhSachHoaDonTheoTenVaGia(tenSp, tenKh, gia);
        return response;
    }
}
