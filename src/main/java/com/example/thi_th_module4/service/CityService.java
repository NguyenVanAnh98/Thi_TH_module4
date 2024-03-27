package com.example.thi_th_module4.service;

import com.example.thi_th_module4.model.City;
import com.example.thi_th_module4.model.dto.CityReqDto;
import com.example.thi_th_module4.model.dto.CityResDto;
import com.example.thi_th_module4.repo.ICityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class CityService implements ICityService {
    private final ICityRepository cityRepository;
    private final INationalService nationalService;

    @Override
    public CityResDto findById(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        CityResDto cityResDto = new CityResDto();
        cityResDto.setId(city.getId());
        cityResDto.setNameCity(city.getName());
        cityResDto.setAcreage(city.getAcreage());
        cityResDto.setPopulation(city.getPopulation());
        cityResDto.setGdp(city.getGdp());
        cityResDto.setDescription(city.getDescription());
        return cityResDto;
    }

    @Override
    public List<CityResDto> findAll() {
        List<City> cities = cityRepository.findAll();
        List<CityResDto> cityResDtos = new ArrayList<>();
        for (City city : cities) {
            CityResDto cityResDto = new CityResDto();
            cityResDto.setId(city.getId());
            cityResDto.setNameCity(city.getName());
            cityResDto.setAcreage(city.getAcreage());
            cityResDto.setPopulation(city.getPopulation());
            cityResDto.setGdp(city.getGdp());
            cityResDto.setDescription(city.getDescription());
            cityResDtos.add(cityResDto);
        }

        return cityResDtos;
    }

    @Override
    public void save(CityReqDto cityReqDto) {
        City city = new City();
        city.setName(cityReqDto.getNameCity());
        city.setAcreage(cityReqDto.getAcreage());
        city.setPopulation(cityReqDto.getPopulation());
        city.setGdp(cityReqDto.getGdp());
        city.setDescription(cityReqDto.getDescription());
        city.setNationals(nationalService.findById(cityReqDto.getNationalId()));
        cityRepository.save(city);

    }

    @Override
    public void delete(Long id) throws Exception {
        cityRepository.deleteById(id);

    }

    @Override
    public void update(Long id, CityReqDto cityReqDto) {
        City city = cityRepository.findById(id).orElse(null);
        city.setName(cityReqDto.getNameCity());
        city.setAcreage(cityReqDto.getAcreage());
        city.setPopulation(cityReqDto.getPopulation());
        city.setGdp(cityReqDto.getGdp());
        city.setDescription(cityReqDto.getDescription());
        cityRepository.save(city);

    }
}
