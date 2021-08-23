package com.lotto.dabak.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * REST API Response paging
 * @param <T>
 */
@Data
public class ResList<T> implements Serializable {

    @ApiModelProperty("상태코드")
    private int code = 200;

    @ApiModelProperty("메세지")
    private String message;

    @ApiModelProperty("성공여부")
    private boolean successful = true;

    @ApiModelProperty("응답 response")
    private List<T> response;

}
