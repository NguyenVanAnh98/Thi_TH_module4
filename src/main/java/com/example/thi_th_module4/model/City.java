package com.example.thi_th_module4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "cities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private Long acreage;
    private long population;
    private Long gdp;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Where(clause = "deleted <> 'DELETED'")
    private National nationals;





}
