package com.example.thi_th_module4.service;

import com.example.thi_th_module4.model.City;
import com.example.thi_th_module4.model.dto.CityReqDto;
import com.example.thi_th_module4.model.dto.CityResDto;

import java.util.List;

public interface ICityService {
    CityResDto findById(Long id);
    List<CityResDto> findAll();
    void save(CityReqDto cityReqDto);
    void delete (Long id)  throws Exception;
    void update(Long id, CityReqDto cityReqDto);
}
