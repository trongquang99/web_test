package study.com.webtest.repository;

import org.springframework.stereotype.Repository;
import study.com.webtest.dtos.request.HsRequest;
import study.com.webtest.model.HocSinh;

@Repository
public interface HsRepository {
    HocSinh getLayThong(HsRequest nguoi);
}
