package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.model.SanPham;

import java.util.List;

@Service
public interface SanPhamService {
    List<SanPham> layDanhSachSanPhamTheoTenKhVaTenSp(String tenKh, String tenSp);
}
