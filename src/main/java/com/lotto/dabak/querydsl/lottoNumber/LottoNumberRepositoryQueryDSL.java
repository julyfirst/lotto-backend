package com.lotto.dabak.querydsl.lottoNumber;


import com.lotto.dabak.dto.request.paging.ReqPaging;
import com.lotto.dabak.dto.response.lottoNumber.ResCreateLottoNumber;
import org.springframework.data.domain.Page;

/**
 * 로또번호 Query DSL
 */
public interface LottoNumberRepositoryQueryDSL {

    /**
     * 생성된 로또 번호 리스트 페이징
     * @param reqPaging
     * @return
     */
    Page<ResCreateLottoNumber> findByLottoNumberPaging(ReqPaging reqPaging);


}
