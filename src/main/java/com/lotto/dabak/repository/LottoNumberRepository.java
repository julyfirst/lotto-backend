package com.lotto.dabak.repository;

import com.lotto.dabak.entity.LottoNumber;
import com.lotto.dabak.querydsl.lottoNumber.LottoNumberRepositoryQueryDSL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LottoNumberRepository extends JpaRepository<LottoNumber, Long>, LottoNumberRepositoryQueryDSL {
}
