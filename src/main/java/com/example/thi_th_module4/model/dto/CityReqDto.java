package com.example.thi_th_module4.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityReqDto {
    private Long id;
    private String nameCity;
    private Long acreage;
    private long population;
    private Long gdp;
    private String description;
    private Long nationalId;
}
