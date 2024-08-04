package study.com.webtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.com.webtest.model.HoaDon;
import study.com.webtest.service.HoaDonServiceBuilder;

import java.util.List;

@RestController
public class HoaDonTestController {
    private final HoaDonServiceBuilder hoaDonServiceBuilder;

    public HoaDonTestController(HoaDonServiceBuilder hoaDonServiceBuilder) {
        this.hoaDonServiceBuilder = hoaDonServiceBuilder;
    }

    @GetMapping("/api/hoa_don/query_builder")
    public List<HoaDon> getListBills(
            @RequestParam(name = "ten_sp", required = false) String tenSp,
            @RequestParam(name = "ten_kh", required = false) String tenKh,
            @RequestParam(name = "gia", required = false) Float gia
    ){
        var response = hoaDonServiceBuilder.getListBills(tenSp, tenKh, gia);
        return response;
    }
}
