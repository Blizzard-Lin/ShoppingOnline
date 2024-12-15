package com.cy.store.mapper;

import com.cy.store.entity.District;

import java.util.List;

public interface DistrictMapper {
    //根据父代号查询区域信息
    List<District> findByParent(String  parent);

    //根据code查询当前省市区的名称
    String findNameByCode(String code);
}
