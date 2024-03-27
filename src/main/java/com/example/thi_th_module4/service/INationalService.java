package com.example.thi_th_module4.service;

import com.example.thi_th_module4.model.National;

import java.util.List;

public interface INationalService {
    List<National> findAll();
    void save(National national);
    National findById(Long id);
    void delete (Long id)  throws Exception;
}
