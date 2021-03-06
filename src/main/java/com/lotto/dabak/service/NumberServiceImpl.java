package com.lotto.dabak.service;

import com.lotto.dabak.component.RepositoryComponent;
import com.lotto.dabak.dto.request.paging.ReqPaging;
import com.lotto.dabak.dto.response.ResList;
import com.lotto.dabak.dto.response.lottoNumber.ResCreateLottoNumber;
import com.lotto.dabak.dto.response.lottoNumber.ResLottoNumber;
import com.lotto.dabak.entity.LottoNumber;
import com.lotto.dabak.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 로또 번호 관련 serviceImpl
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class NumberServiceImpl implements NumberService {

    private final RepositoryComponent repository;


    /**
     * 해당 갯수 만큼 로또번호 생성
     * @param count
     * @return
     */
    @Override
    @Transactional
    public ResList getLottoNumberList(int count) {


        ResList resList = new ResList();

        try{
            ResLottoNumber resLottoNumber = new ResLottoNumber();
            List<List<Integer>> lottoNumberList = new ArrayList<>();

            for(int i =0; i<count; i++) {
                HashSet<Integer> numbers = new HashSet<>();

                for (int k = 0; numbers.size() < 6; k++) {
                    numbers.add((int) (Math.random() * 45) + 1);
                }

                List<String> numberList = new ArrayList(numbers);
                Collections.sort(numberList);
                List<Integer> lottoNumbers = new ArrayList(numberList);
                lottoNumberList.add(lottoNumbers);
                resLottoNumber.setLottoNumberList(lottoNumberList);
            }

            // 로또 번호 저장
            for(List<Integer> lottoNumbers : resLottoNumber.getLottoNumberList()){

                LottoNumber lottoNumber = LottoNumber.builder()
                        .one(lottoNumbers.get(0))
                        .two(lottoNumbers.get(1))
                        .three(lottoNumbers.get(2))
                        .four(lottoNumbers.get(3))
                        .five(lottoNumbers.get(4))
                        .six(lottoNumbers.get(5))
                        .build();
                repository.getLottoNumberRepository().save(lottoNumber);

            }

            resList.setResponse(resLottoNumber.getLottoNumberList());

        }catch (Exception e){
            e.printStackTrace();
            resList.setMessage("server-error");
            resList.setSuccessful(false);
            resList.setCode(500);
        }

        return resList;
    }

    /**
     * 생성된 로또번호 출력
     * @param reqPaging
     * @return
     */
    @Override
    public PageVO<ResCreateLottoNumber> getCreateLottoList(ReqPaging reqPaging) {

        ResList resList = new ResList();
        PageVO<ResCreateLottoNumber> resCreateLottoNumberPageVO = null;

        try{
            Page<ResCreateLottoNumber> createLottoNumberList = repository.getLottoNumberRepository().findByLottoNumberPaging(reqPaging);
            // 페이징 셋팅
           resCreateLottoNumberPageVO = new PageVO<>(createLottoNumberList.getContent(), createLottoNumberList.getTotalElements(), reqPaging);

        }catch (Exception e){
            e.printStackTrace();
            resList.setMessage("server-error");
            resList.setSuccessful(false);
            resList.setCode(500);
        }

        return resCreateLottoNumberPageVO;

    }


}
