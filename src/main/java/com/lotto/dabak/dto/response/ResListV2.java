package com.lotto.dabak.dto.response;


import com.lotto.dabak.dto.response.paging.ResPaging;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * REST API Response paging
 * @param <T>
 */
@Data
public class ResListV2<T> implements Serializable {

    @ApiModelProperty("응답 data")
    private List<T> data;

    @ApiModelProperty("페이징 정보")
    private ResPaging paging = new ResPaging();

}
