package edu.cn.neusoft.project.model.service;

import edu.cn.neusoft.project.model.vo.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressByUserId(int loginUserId);
}
