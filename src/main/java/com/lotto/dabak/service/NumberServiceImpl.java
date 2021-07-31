package com.lotto.dabak.service;

import com.lotto.dabak.dto.response.ResList;
import com.lotto.dabak.dto.response.ResNormal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 로또 번호 관련 serviceImpl
 */
@Service
@Transactional
public class NumberServiceImpl implements NumberService {



    /**
     * 해당 갯수 만큼 로또번호 생성
     * @param count
     * @return
     */
    @Override
    public ResList getLottoNumbers(int count) {
        ResList resList = new ResList();
        List<String> testList = new ArrayList<>();

        testList.add("하잇1");
        testList.add("하잇2");

        resList.setData(testList);


        return resList;
    }



}
