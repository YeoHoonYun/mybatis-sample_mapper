package net.chandol.study.mybatissample;

import lombok.extern.slf4j.Slf4j;
import net.chandol.study.mybatissample.model.City;
import net.chandol.study.mybatissample.service.CityService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2019-02-22
 * Github : https://github.com/YeoHoonYun
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
// DB에 직접 테이터가 들어가는지 테스트
@Transactional(transactionManager = "transactionManager")
@Commit
public class CityServiceTest extends DefaultTransactionDefinition{
    @Autowired
    CityService service;

    @Test
    public void getCityById() {
        City city = service.getCityById(1L);
        System.out.println("TEST : " + city);
        log.info("city : {}", city);
    }

    @Test
    public void getAllCity() {
        List<City> cities = service.getAllCity();
        for(City city : cities){
            System.out.println(city);
        };
    }


    @Test
    public void addCities() {
        service.addCity("뉴욕", "미국", 1_000_000L);
        service.addCity("런던", "영국", 2_000_000L);
        service.addCity("파리", "프랑스", 3_000_000L);
        this.getAllCity();
    }

}
