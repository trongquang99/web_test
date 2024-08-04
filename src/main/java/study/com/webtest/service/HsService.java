package study.com.webtest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import study.com.webtest.dtos.request.HsRequest;
import study.com.webtest.model.HocSinh;

@Service
@AllArgsConstructor
public class HsService {
    HsServiceImpl hsService;

    public HocSinh layThongTin(HsRequest request){
        return hsService.getLayThong(request);
    }
}
