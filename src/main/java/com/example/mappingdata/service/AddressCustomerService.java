package com.example.mappingdata.service;


import com.example.mappingdata.dto.AddressCustomer;
import com.example.mappingdata.entities.Address;
import com.example.mappingdata.entities.Customer;
import com.example.mappingdata.repo.AddressRepo;
import com.example.mappingdata.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressCustomerService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private CustomerRepo customerRepo;

    @Transactional
    public AddressCustomer saveAddressCustomer(AddressCustomer addressCustomer){
        Address address=new Address(addressCustomer.getStreetName(),addressCustomer.getCity(),addressCustomer.getZipCode());
        Customer customer=new Customer();
        customer.setAge(addressCustomer.getAge());
        customer.setName(addressCustomer.getName());

        address.setCustomer(customer);
        customer.setAddress(address);
        addressRepo.save(address);
        customerRepo.save(customer);

        return addressCustomer;
    }
    @Transactional
    public List<AddressCustomer> findAllAddressCustomer(){
        List<AddressCustomer> addressCustomerList=new ArrayList<>();

        List<Address> addressList=addressRepo.findAll();
        List<Customer> customerList=customerRepo.findAll();


        AddressCustomer addressCustomer=null;

        for(int i=0;i<addressList.size();i++){
            addressCustomer=new AddressCustomer();
            addressCustomer.setAge(customerList.get(i).getAge());
            addressCustomer.setName(customerList.get(i).getName());
            addressCustomer.setCity(addressList.get(i).getCity());
            addressCustomer.setStreetName(addressList.get(i).getStreetName());
            addressCustomer.setZipCode(addressList.get(i).getZipCode());
            addressCustomerList.add(addressCustomer);
        }
        return addressCustomerList;
    }
}


