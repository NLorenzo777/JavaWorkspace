package org.example.transactionaldemo.Services;

import org.example.transactionaldemo.Entity.Address;
import org.example.transactionaldemo.Repository.Addresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private Addresses addressRepo;

    public Address addAddress(Address address) {
        addressRepo.save(address);
        return address;
    }
}