package study.com.webtest.dtos.response.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseListResponse<T> extends BaseResponse<List<T>> {
    protected String before;
    protected String after;
}

