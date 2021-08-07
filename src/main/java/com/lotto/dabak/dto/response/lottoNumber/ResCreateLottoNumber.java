package com.lotto.dabak.dto.response.lottoNumber;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ResCreateLottoNumber {


    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("해당 로또 번호 생성 날짜")
    private LocalDateTime createdAt;

    @ApiModelProperty("로또 횟차수")
    private Long round;

    @ApiModelProperty("로또 번호 순서")
    private int one;

    @ApiModelProperty("로또 번호 순서")
    private int two;

    @ApiModelProperty("로또 번호 순서")
    private int three;

    @ApiModelProperty("로또 번호 순서")
    private int four;

    @ApiModelProperty("로또 번호 순서")
    private int five;

    @ApiModelProperty("로또 번호 순서")
    private int six;


}
