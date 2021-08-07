package com.lotto.dabak.entity;

import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class LottoNumber {

    // pk
    @Id
    @GeneratedValue
    private Long id;

    // 생성일
    @CreationTimestamp
    private LocalDateTime createdAt;

    // 로또 횟차 수
    @Column(name = "round")
    private Long round;

    // 로또 번호 순서
    @Column(name = "one")
    private int one;

    @Column(name = "two")
    private int two;

    @Column(name = "three")
    private int three;

    @Column(name = "four")
    private int four;

    @Column(name = "five")
    private int five;

    @Column(name = "six")
    private int six;

    @Builder
    public LottoNumber(Long round, int one, int two, int three, int four, int five, int six) {
        this.round = 964L;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }
}
