package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.BillDetailResponseV2;

import java.util.List;

@Service
public interface BillServiceV2 {
    List<BillDetailResponseV2> getBillDetail();
}
