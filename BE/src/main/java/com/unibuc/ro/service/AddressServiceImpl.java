package com.unibuc.ro.service;
import com.unibuc.ro.model.OrderAddress;
import com.unibuc.ro.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public OrderAddress findAddressById(Long addressId) {
        return addressRepository.findByAddressId(addressId).orElse(null);
    }
}
