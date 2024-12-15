package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.entity.District;
import com.cy.store.service.IDistrictService;
import com.cy.store.utils.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController {
    @Autowired
    private IDistrictService districtService;


    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District>list = districtService.getByParent(parent);
        //返回数据
        return new JsonResult<>(OK,list);
    }

}
