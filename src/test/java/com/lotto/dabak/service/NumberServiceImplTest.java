package com.lotto.dabak.service;

import com.lotto.dabak.component.RepositoryComponent;
import com.lotto.dabak.dto.response.ResList;
import com.lotto.dabak.dto.response.lottoNumber.ResLottoNumber;
import com.lotto.dabak.entity.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class NumberServiceImplTest {

    @Autowired
    private RepositoryComponent repository;



    // 로또 생성 테스트 코드
    @Test
    @Rollback(false)
    void getLottoNumbers() {
        int count  = 5;
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
                System.out.println("lottoNumbers = " + lottoNumbers);
            }

            for(List<Integer> lottoNumbers : resLottoNumber.getLottoNumberList()){
                //System.out.println("lottoNumber는??= " + lottoNumbers);

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
            resList.setMessage("error");
            resList.setSuccessful(false);
            resList.setCode(500);
        }


    }
}