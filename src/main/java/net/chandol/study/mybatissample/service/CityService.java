package net.chandol.study.mybatissample.service;

import net.chandol.study.mybatissample.model.City;
import net.chandol.study.mybatissample.repository.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2019-02-22
 * Github : https://github.com/YeoHoonYun
 */
@Service
@Transactional(transactionManager = "transactionManager")
//@Commit
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public City getCityById(Long id) {
        return cityMapper.selectCityById(id);
    }

    public List<City> getAllCity() {
        return cityMapper.selectAllCity();
    }

    public void addCity(String name, String country, Long population) {
        cityMapper.insertCity(name, country, population);
    }
}