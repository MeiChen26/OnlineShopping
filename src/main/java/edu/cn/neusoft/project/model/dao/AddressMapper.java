package edu.cn.neusoft.project.model.dao;

import edu.cn.neusoft.project.model.vo.Address;

import java.util.List;

public interface AddressMapper {

    List<Address> findAddrByUserId(int loginUserId);
}
