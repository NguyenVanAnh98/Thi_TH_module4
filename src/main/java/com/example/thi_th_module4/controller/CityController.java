package com.example.thi_th_module4.controller;

import com.example.thi_th_module4.model.dto.CityReqDto;
import com.example.thi_th_module4.model.dto.CityResDto;
import com.example.thi_th_module4.service.ICityService;
import com.example.thi_th_module4.service.NationalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private NationalService nationalService;

    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "") String nameCity) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<CityResDto> cityResDtos = cityService.findAll();
        modelAndView.addObject("cityList", cityResDtos);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        return new ModelAndView("add")
                .addObject("listNationl", nationalService.findAll())
                .addObject("cityReqDto", new CityReqDto());

    }

    @PostMapping("/add")
    public String addCity(CityReqDto cityReqDto) {
        cityService.save(cityReqDto);
        return "redirect:/cities";
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable Long id) throws Exception {
        cityService.delete(id);
        return "redirect:/cities";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        return new ModelAndView("update")
                .addObject("cityReqDto", cityService.findById(id))
                .addObject("listNationl", nationalService.findAll());
    }

    @PostMapping("/edit/{id}")
    public String editCity(@PathVariable Long id, CityReqDto cityReqDto) {
        cityService.update(id, cityReqDto);
        return "redirect:/cities";
    }
}

