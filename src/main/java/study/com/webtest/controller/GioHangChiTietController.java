package study.com.webtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.com.webtest.dtos.response.GioHangChiTietResponse;
import study.com.webtest.service.GioHangService;

import java.util.List;

@RestController
public class GioHangChiTietController {
    private final GioHangService gioHangService;

    public GioHangChiTietController(GioHangService gioHangService) {
        this.gioHangService = gioHangService;
    }

    @GetMapping("api/giohang_chitiet/{id}")
    public GioHangChiTietResponse getGioHangChiTiet(@PathVariable(name = "id") Long id){
        GioHangChiTietResponse response = gioHangService.getGioHangChiTiet(id);
        return response;
    }

    @GetMapping("api/giohang_chitiet2")
    public List<GioHangChiTietResponse> getGioHangChiTietList(){
        List<GioHangChiTietResponse> response = gioHangService.getGioHangChiTietList();
        return response;
    }
}
