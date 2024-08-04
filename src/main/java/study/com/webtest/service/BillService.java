package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.BillDetailResponse;
import study.com.webtest.model.HoaDon;

import java.util.List;

@Service
public interface BillService {
    BillDetailResponse getBillDetailById(Long id);

    List<BillDetailResponse> getBillDetailList();

    Integer getHoaDonCount();
}
