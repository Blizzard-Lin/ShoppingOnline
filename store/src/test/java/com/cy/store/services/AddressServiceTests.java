package com.cy.store.services;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
    @Qualifier("addressServiceImpl")
    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress() {
        Integer uid = 20;
        String username = "管理员";
        Address address = new Address();
        address.setName("Tim");
        address.setPhone("17858805555");
        address.setAddress("华南师范大学");
        addressService.addAddress(address, username, uid);
        System.out.println("OK.");
    }

}
