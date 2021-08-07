package com.lotto.dabak.service;


import com.lotto.dabak.dto.request.paging.ReqPaging;
import com.lotto.dabak.dto.response.ResList;
import com.lotto.dabak.dto.response.lottoNumber.ResCreateLottoNumber;
import com.lotto.dabak.vo.PageVO;

/**
 * 로또번호 관련 service
 */
public interface NumberService {


    /**
     * 로또 번호 생성
     * @param count
     * @return
     */
    ResList getLottoNumberList(int count);


    /**
     * 생성된 로또 번호 리스트
     * @param reqPaging
     * @return
     */
    PageVO<ResCreateLottoNumber> getCreateLottoList(ReqPaging reqPaging);





}
