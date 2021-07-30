package com.lotto.dabak.controller;

import com.lotto.dabak.dto.response.ResNormal;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Log4j2
public class NumberController {

    @ApiOperation("로또 번호 생성")
    @GetMapping("/lotto")
    @ApiResponses({
            @ApiResponse(code=200, message="성공"),
            @ApiResponse(code=401, message="비인증 요청(로그인, 토큰)", response = ResNormal.class),
    })
    public ResNormal getLottoNumbers(
            int count
    ) {
        ResNormal res = new ResNormal();




        return res;
    }













}
