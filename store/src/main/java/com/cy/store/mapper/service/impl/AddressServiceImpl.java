package com.cy.store.mapper.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.mapper.service.IAddressService;
import com.cy.store.mapper.service.ex.AddressCountLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
//新增收货地址的实现
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Value("${user.address.max-count}")
    private Integer maxCount;
    @Override
    public void addAddress(Address address, String username, Integer uid) {
        //调用收货地址统计的方法
        Integer count =addressMapper.countByUid(uid);

        //查询记录的收货地址数量
        if(count>=maxCount){
            throw new AddressCountLimitException("用户收货地址太多，超出上限");
        }

        //收货地址数量为0，则将此地址设置为用户默认的地址
        if (count == 0){
            address.setIsDefault(1);
        }else{ //否则设置为0，表示不是默认地址
            address.setIsDefault(0);
        }

        //设置uid
        address.setAid(uid);
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        //插入收货地址的方法
        Integer rows =addressMapper.insert(address);
        //判断是否正确插入
        if(rows == 0) {
            //throw new InsertException("插入的用户收货地址有问题");
        }
    }

//    @Override
//    public List<Address> queryUserAddress(Integer uid) {
//        return null;
//    }
//
//    @Override
//    public Address queryAddressByAid(Integer aid) {
//        return null;
//    }
//
//    @Override
//    public int setNotDefaultAddress(Integer uid) {
//        return 0;
//    }
//
//    @Override
//    public int setOneAddressDefault(Integer aid, String modifiedUser, Date modifiedTime) {
//        return 0;
//    }
//
//    @Override
//    public int deleteOneAddress(Integer aid, String modifiedUser, Date modifiedTime) {
//        return 0;
//    }
//
//    @Override
//    public int updateOneAddress(Address address, String modifiedUser) {
//        return 0;
//    }
}
