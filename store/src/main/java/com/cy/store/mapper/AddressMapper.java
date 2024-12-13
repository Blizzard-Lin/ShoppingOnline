package com.cy.store.mapper;

import com.cy.store.entity.Address;

//收货地址持久层的接口
public interface AddressMapper {
    /**
     * Description : 添加用户地址
     * @param address 用户地址信息
     * @return int 受影响的行数
     **/
    Integer insert(Address address);

    /**
     * Description : 添加用户的收货地址数量
     * @param uid 用户的id
     * @return 当前用户的收货地址总数
     **/
    Integer countByUid(Integer uid);
}
