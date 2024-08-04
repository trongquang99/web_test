package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.response.BillDetailNewResponse;
import study.com.webtest.dtos.response.CustomerDetailResponse;


import java.util.List;

@Service
public interface CustomerDetailService {
    List<CustomerDetailResponse>getListCustomerDetail();

    BillDetailNewResponse getBillDetailNew(Long id);
}
