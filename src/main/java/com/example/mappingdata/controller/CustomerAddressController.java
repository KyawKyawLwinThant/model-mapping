package com.example.mappingdata.controller;


import com.example.mappingdata.dto.AddressCustomer;
import com.example.mappingdata.service.AddressCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerAddressController {

    @Autowired
    private AddressCustomerService addressCustomerService;

    @GetMapping("/index")
    public String showForm(Model model){
        model.addAttribute("addressCustomer",new AddressCustomer());
        return "index";
    }

    @PostMapping("/save-address-customer")
    public String saveAddressCustomer(AddressCustomer addressCustomer){

        addressCustomerService.saveAddressCustomer(addressCustomer);

        return "redirect:/show-all";
    }
    @GetMapping("/show-all")
    public String showAllAddressCustomer(Model model){

        model.addAttribute("addresscustomers",addressCustomerService.findAllAddressCustomer());

        return "showall";
    }

}
