package com.lotto.dabak.component;

import com.lotto.dabak.repository.LottoNumberRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RepositoryComponent {

    @Autowired
    LottoNumberRepository lottoNumberRepository;


}
