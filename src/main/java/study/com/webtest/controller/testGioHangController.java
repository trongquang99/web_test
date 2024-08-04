package study.com.webtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.com.webtest.dtos.response.GioHangBuilderResponse;
import study.com.webtest.service.GioHangServiceBuilder;

import java.util.List;

@RestController
public class testGioHangController {
    private final GioHangServiceBuilder gioHangServiceBuilder;

    public testGioHangController(GioHangServiceBuilder gioHangServiceBuilder) {
        this.gioHangServiceBuilder = gioHangServiceBuilder;
    }

    @GetMapping("/api/test/gio_hang")
    public List<GioHangBuilderResponse> layDanhSachGioHang(
            @RequestParam(name = "ten_kh", required = false) String tenKh,
            @RequestParam(name = "sdt_kh", required = false) String sdtKh,
            @RequestParam(name = "ten_ch", required = false) String tenCh,
            @RequestParam(name = "sdt_ch", required = false) String sdtCh,
            @RequestParam(name = "ten_sp", required = false) String tenSp,
            @RequestParam(name = "tong_gia", required = false) Float tongGia
    ){
        var response = gioHangServiceBuilder.layDanhSachGioHang(tenKh, sdtKh, tenCh, sdtCh, tenSp, tongGia);
        return response;
    }
}
