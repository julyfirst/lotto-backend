package com.lotto.dabak.controller;

import com.lotto.dabak.component.ServiceComponent;
import com.lotto.dabak.dto.request.paging.ReqPaging;
import com.lotto.dabak.dto.response.ResList;
import com.lotto.dabak.dto.response.ResListV2;
import com.lotto.dabak.dto.response.ResNormal;
import com.lotto.dabak.dto.response.lottoNumber.ResCreateLottoNumber;
import com.lotto.dabak.vo.PageVO;
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
            @ApiResponse(code=500, message="서버 에러"),
    })
    public ResList getLottoNumberList(
            int count
    ) {

        ResList lottoNumbers = service.getNumberService().getLottoNumberList(count);

        return lottoNumbers;
    }


    @ApiOperation("생성된 로또 번호 리스트")
    @GetMapping("/list/create-lotto")
    @ApiResponses({
            @ApiResponse(code=200, message="성공"),
            @ApiResponse(code=500, message="서버 에러"),
    })
    public ResListV2<ResCreateLottoNumber> getCreateLottoNumberList(
            ReqPaging reqPaging

    ) {
        ResListV2 res = new ResListV2();
        PageVO<ResCreateLottoNumber> lottoNumbers = service.getNumberService().getCreateLottoList(reqPaging);
        res.setResponse(lottoNumbers.getList());
        res.setPaging(lottoNumbers.getPaging());
        return res;
    }











}
