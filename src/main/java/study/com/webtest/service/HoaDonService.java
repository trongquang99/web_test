package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.model.HoaDon;

import java.util.List;

@Service
public interface HoaDonService {
    List<HoaDon> layDanhSachHoaDonTheoTenVaGia (String tenSp, String tenKh, Float gia);
}
