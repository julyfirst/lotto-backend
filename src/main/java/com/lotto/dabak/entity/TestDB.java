package com.lotto.dabak.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class TestDB {

    @Id
    @GeneratedValue
    private Long id;

}
