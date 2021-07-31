package com.lotto.dabak.controller;

import com.lotto.dabak.component.ServiceComponent;
import com.lotto.dabak.dto.response.ResList;
import com.lotto.dabak.dto.response.ResNormal;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Log4j2
@RequiredArgsConstructor
public class NumberController {

    private final ServiceComponent service;


    @ApiOperation("로또 번호 생성")
    @GetMapping("/lotto")
    @ApiResponses({
            @ApiResponse(code=200, message="성공"),
            @ApiResponse(code=403, message="비인증 요청", response = ResNormal.class),
    })
    public ResList getLottoNumbers(
            int count
    ) {

        ResList lottoNumbers = service.getNumberService().getLottoNumbers(count);

        return lottoNumbers;
    }













}
