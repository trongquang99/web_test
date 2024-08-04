package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.GioHangChiTietResponse;

import java.util.List;

@Service
public interface GioHangService {

    GioHangChiTietResponse getGioHangChiTiet(Long id);

    List<GioHangChiTietResponse> getGioHangChiTietList();
}
