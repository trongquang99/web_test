package study.com.webtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.com.webtest.model.SanPham;
import study.com.webtest.service.SanPhamServiceBuilder;

import java.util.List;

@RestController
public class TestController {
    private final SanPhamServiceBuilder sanPhamServiceBuilder;

    public TestController(SanPhamServiceBuilder sanPhamServiceBuilder) {
        this.sanPhamServiceBuilder = sanPhamServiceBuilder;
    }

    @GetMapping("/api/test/query_builder")
    public List<SanPham> getListProducts(
            @RequestParam(name = "ten_sp", required = false) String tenSp,
            @RequestParam(name = "ten_kh", required = false) String tenKh
    ){
        var response = sanPhamServiceBuilder.getListProducts(tenSp, tenKh);
        return response;
    }
}
