package edu.cn.neusoft.project.model.service;

import edu.cn.neusoft.project.model.dao.AddressMapper;
import edu.cn.neusoft.project.model.vo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService{

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddressByUserId(int loginUserId) {
        List<Address> addrs=addressMapper.findAddrByUserId(loginUserId);

        return addrs;
    }
}
