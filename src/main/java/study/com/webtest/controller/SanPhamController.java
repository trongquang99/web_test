package study.com.webtest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.com.webtest.dtos.response.base.BaseResponse;
import study.com.webtest.dtos.response.base.ResponseBuilder;
import study.com.webtest.model.SanPham;
import study.com.webtest.service.SanPhamService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SanPhamController {

    private final SanPhamService sanPhamService;

    public SanPhamController(SanPhamService sanPhamService) {
        this.sanPhamService = sanPhamService;
    }

    @GetMapping("/api/v2/ds/sanpham")
    public ResponseEntity<BaseResponse<List<SanPham>>> layDanhSachSanPhamTheoTenKhVaTenSp(
            @RequestParam(name = "ten_kh", required = false) String tenKh,
            @RequestParam(name = "ten_sp", required = false) String tenSp
            ){
        List<SanPham> listResponse = sanPhamService.layDanhSachSanPhamTheoTenKhVaTenSp(tenKh, tenSp);
        return ResponseEntity.ok(ResponseBuilder.successList(listResponse));
    }
}
