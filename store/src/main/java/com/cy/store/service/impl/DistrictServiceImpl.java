package com.cy.store.service.impl;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    //根据父代号查询省市区信息
    public List<District> getByParent(String parent){
        List<District> list =districtMapper.findByParent(parent);
        //过滤无效字段数据，提高传输效率
        for (District ad: list) {
            ad.setId(null);
            ad.setParent(null);
        }
        return list;
    }


}
