package com.unibuc.ro.service;

import com.unibuc.ro.model.Order;
import com.unibuc.ro.model.OrderAddress;

import java.util.Set;

public interface AddressService {

    OrderAddress findAddressById(Long addressId);
}
