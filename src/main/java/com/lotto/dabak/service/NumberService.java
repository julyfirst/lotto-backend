package com.lotto.dabak.service;


import com.lotto.dabak.dto.response.ResList;
import org.springframework.stereotype.Service;

/**
 * 로또번호 관련 service
 */
public interface NumberService {


    ResList getLottoNumbers(int count);


}
