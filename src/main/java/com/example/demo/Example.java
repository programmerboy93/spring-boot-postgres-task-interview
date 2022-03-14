package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="tabela_testowa")
@Getter
public class Example {

    @Id
    private Long id;

    private String kolumna1;

    private String kolumna2;

    private String kolumna3;

    private Integer kolumna4;
}
