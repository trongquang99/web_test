package study.com.webtest.service;

import org.springframework.stereotype.Service;
import study.com.webtest.dtos.request.HsRequest;
import study.com.webtest.model.HocSinh;
import study.com.webtest.repository.HsRepository;

import java.util.Objects;

@Service
public class HsServiceImpl implements HsRepository {
    @Override
    public HocSinh getLayThong(HsRequest req) {
        HocSinh res = getHocSinh(req);

        return res;
    }

    private static HocSinh getHocSinh(HsRequest req) {
        HocSinh res = new HocSinh();
//        if (Objects.nonNull(req.getTen())){
//            res.setTen(req.getTen());
//        }
//        if (Objects.nonNull(req.getTuoi())){
//            res.setTuoi(req.getTuoi());
//        }
//        if (Objects.nonNull(req.getQueQuan())){
//            res.setQueQuan(req.getQueQuan());
//        }
//        if (Objects.nonNull(req.getSdt())){
//            res.setStd(req.getSdt());
//        }
        return res;
    }
}
