package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.model.HoaDon;
import study.com.webtest.model.HoaDonSanPham;
import study.com.webtest.model.KhachHang;
import study.com.webtest.model.SanPham;
import study.com.webtest.repository.HoaDonRepository;
import study.com.webtest.repository.HoaDonSanPhamRepository;
import study.com.webtest.repository.KhachHangRepository;
import study.com.webtest.repository.SanPhamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SanPhamServiceImpl implements SanPhamService{

    private final SanPhamRepository sanPhamRepository;
    private final KhachHangRepository khachHangRepository;
    private final HoaDonRepository hoaDonRepository;
    private final HoaDonSanPhamRepository hoaDonSanPhamRepository;

    public SanPhamServiceImpl(SanPhamRepository sanPhamRepository,
                              KhachHangRepository khachHangRepository,
                              HoaDonRepository hoaDonRepository,
                              HoaDonSanPhamRepository hoaDonSanPhamRepository) {
        this.sanPhamRepository = sanPhamRepository;
        this.khachHangRepository = khachHangRepository;
        this.hoaDonRepository = hoaDonRepository;
        this.hoaDonSanPhamRepository = hoaDonSanPhamRepository;
    }

    @Override
    public List<SanPham> layDanhSachSanPhamTheoTenKhVaTenSp(String tenKh, String tenSp) {
        List<SanPham> listSpByTenKh = new ArrayList<>(); // empty
        List<SanPham> listSpByTenSp = new ArrayList<>(); // empty

        if (Objects.nonNull(tenKh)) listSpByTenKh = getListSpByTenKh(tenKh);
        if (Objects.nonNull(tenSp)) listSpByTenSp = getListSpByTenSp(tenSp);

        if (!listSpByTenKh.isEmpty() && !listSpByTenSp.isEmpty()){
            return layGiaoHaiDs(listSpByTenKh, listSpByTenSp);
        }

        if (listSpByTenKh.isEmpty() && !listSpByTenSp.isEmpty()){
            return listSpByTenSp;
        }

        if (!listSpByTenKh.isEmpty()){
            return listSpByTenKh;
        }

        return sanPhamRepository.findAll();
//        //TODO: nếu tenKh null và têm sp null
//        // => tìm tất cả sản phẩm trong bảng Sản phẩm
//        if (Objects.isNull(tenKh) && Objects.isNull(tenSp)){
//            response = sanPhamRepository.findAll();
//        }
//
//        //TODO: nếu tenKh khác null và têm sp null
//        // => tìm list idKhs => list idHds => list idHdSps => list sp
//        if (Objects.nonNull(tenKh) && Objects.isNull(tenSp)){
//            response = getListSpByTenKh(tenKh);
//        }
//
//        //TODO: nếu tenKh null và têm sp khác null
//        // => tìm tất cả sản phẩm trong bảng Sản phẩm có ten like %tenSp%
//        if (Objects.nonNull(tenSp) && Objects.isNull(tenKh)){
//            response = getListSpByTenSp(tenSp);
//        }
//
//        //TODO: nếu tenKh khác null và têm sp khác null
//        // => tìm ds Sp gọi là ds1 theo tenKh => cách tìm => tìm list idKhs => list idHds => list idHdSps => list sp
//        // => tìm ds Sp gọi là ds2 theo TenSp => cách tìm =>  tìm tất cả sản phẩm trong bảng Sản phẩm có ten like %tenSp%
//        // sau đó lấy phần giao của ds1 và ds2 => được ds3 là kết quả
//        if (Objects.nonNull(tenSp) && Objects.nonNull(tenKh)){
//
//            //Tim ds2
//            List<SanPham> ds2 = getListSpByTenSp(tenSp);
//
//            // ds1
//            List<SanPham> ds1 = getListSpByTenKh(tenKh);
//
//            // giao ds1 vs ds2 => ds3
//            List<SanPham> ds3 = new ArrayList<>();
//            ds1.forEach(sanPhamCuaDs1 -> {
//                ds2.forEach(sanPhamCuaDs2 -> {
//                    if (Objects.equals(sanPhamCuaDs1.getId(), sanPhamCuaDs2.getId())){
//                        ds3.add(sanPhamCuaDs1);
//                    }
//                });
//            });
//            response = ds3;
//        }
//        return response;
    }

    private List<SanPham> getListSpByTenSp(String tenSp) {
        return sanPhamRepository.findByTenContaining(tenSp);
    }

    private List<SanPham> getListSpByTenKh(String tenKh) {
        // tìm list idKhs [tương ứng SELECT * FROM webcar_db.khachhang where ten like '%tenKh%']
        List<KhachHang> dsKhTheoTen = khachHangRepository.findByTenContaining(tenKh);
        List<Long> dsIdKh = new ArrayList<>();

        // Tương ứng SELECT id FROM webcar_db.khachhang where ten like '%tenKh%'
        dsKhTheoTen.forEach(khachHang -> {
            dsIdKh.add(khachHang.getId());
        });

        //Tìm list idHd
        List<HoaDon> dsHoaDonTheoIdKh = hoaDonRepository.findByIdKhIn(dsIdKh);

        List<Long> idHds = new ArrayList<>();
        dsHoaDonTheoIdKh.forEach(hoaDon -> {
            idHds.add(hoaDon.getId());
        });

        // Tìm list IdHdSp
        List<HoaDonSanPham> dsHdSpTheoIdHd = hoaDonSanPhamRepository.findByIdHdIn(idHds);

        List<Long> dsIdSps = new ArrayList<>();

        dsHdSpTheoIdHd.forEach(hoaDonSanPham -> {
            dsIdSps.add(hoaDonSanPham.getIdSp());
        });

       return sanPhamRepository.findByIdIn(dsIdSps);
    }

    private List<SanPham> layGiaoHaiDs(List<SanPham> ds1, List<SanPham> ds2){
        List<SanPham> ds3 = new ArrayList<>();
            ds1.forEach(sanPhamCuaDs1 -> {
            ds2.forEach(sanPhamCuaDs2 -> {
                    if (Objects.equals(sanPhamCuaDs1.getId(), sanPhamCuaDs2.getId())){
                        ds3.add(sanPhamCuaDs1);
                    }
                });
            });
        return ds3;
    }
}
