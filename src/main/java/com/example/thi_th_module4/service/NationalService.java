package com.example.thi_th_module4.service;

import com.example.thi_th_module4.model.National;
import com.example.thi_th_module4.repo.INationalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NationalService implements INationalService {
    private final INationalRepository nationalRepository;
    @Override
    public List<National> findAll() {
        List<National> nationals = nationalRepository.findAll();

        return nationals;
    }

    @Override
    public void save(National national) {
        nationalRepository.save(national);
    }

    @Override
    public National findById(Long id) {

        return nationalRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id)  throws Exception{
        try{
            nationalRepository.deleteById(id);
        } catch (Exception e){
            throw new Exception("không tìm thấy quốc gia");
        }


    }
}
