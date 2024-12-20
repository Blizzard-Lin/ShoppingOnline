package com.cy.store.services;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTests {
    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent(){
        String parent = "86";
        List<District> list = districtService.getByParent(parent);
        System.out.println("count=" + list.size());
        for (District item : list) {
            System.out.println(item);
        }

    }


}
