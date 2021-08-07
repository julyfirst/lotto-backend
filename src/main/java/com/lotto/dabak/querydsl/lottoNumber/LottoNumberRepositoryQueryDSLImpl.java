package com.lotto.dabak.querydsl.lottoNumber;


import com.lotto.dabak.dto.request.paging.ReqPaging;
import com.lotto.dabak.dto.response.lottoNumber.ResCreateLottoNumber;
import com.lotto.dabak.entity.LottoNumber;
import com.lotto.dabak.entity.QLottoNumber;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

/**
 *
 */
public class LottoNumberRepositoryQueryDSLImpl extends QuerydslRepositorySupport implements LottoNumberRepositoryQueryDSL {


    public LottoNumberRepositoryQueryDSLImpl() {
        super(LottoNumber.class);
    }

    /**
     * 생성된 로또번호 리스트 (페이징처리)
     * @param reqPaging
     * @return
     */
    @Override
    public Page<ResCreateLottoNumber> findByLottoNumberPaging(ReqPaging reqPaging) {


        QLottoNumber qLottoNumber = QLottoNumber.lottoNumber;
        JPQLQuery query = from(qLottoNumber);


        query.select(
                Projections.fields(ResCreateLottoNumber.class,
                        qLottoNumber.id,
                        qLottoNumber.createdAt,
                        qLottoNumber.round,
                        qLottoNumber.one,
                        qLottoNumber.two,
                        qLottoNumber.three,
                        qLottoNumber.four,
                        qLottoNumber.five,
                        qLottoNumber.six

        ));

        // 페이징 및 정렬 셋팅
        Pageable pageable = PageRequest.of(reqPaging.index(), reqPaging.getListCount(), Sort.by("id").descending());


        List<ResCreateLottoNumber> lottoNumberList = getQuerydsl().applyPagination(pageable, query).fetch();
        long count = query.fetchCount();

        return new PageImpl<>(lottoNumberList, pageable, count);

    }



}
