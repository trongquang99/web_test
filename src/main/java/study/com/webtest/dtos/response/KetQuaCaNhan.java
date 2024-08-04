package study.com.webtest.dtos.response;

import lombok.Data;

@Data
public class KetQuaCaNhan  {
   private String ketQua;

    public KetQuaCaNhan(String ketQua) {
        this.ketQua = ketQua;
    }
}
