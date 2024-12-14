package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.utils.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController {
    @Autowired
    private IAddressService addressService;

    @PostMapping
    public JsonResult<Void> addAddress(Address address, HttpSession session){

        //从session中取出uid和用户名
        //Integer uid = getUserIdFromSession(session);
        //String username = getUsernameFromSession(session);

        //调用业务层方法，新增地址
        String username ="Amy";
        Integer uid=18;
        addressService.addAddress(address,username,uid);
        return new JsonResult<>(OK);
    }

}
