package com.lotto.dabak.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * REST API Response
 */
@Data
public class ResNormal implements Serializable {

    @ApiModelProperty("상태코드")
    private int code = 200;

    @ApiModelProperty("메세지")
    private String message;

    @ApiModelProperty("성공여부")
    private boolean successful = true;

}
