package com.elm.controller;

import com.elm.entity.DeliveryAddress;
import com.elm.result.CommonResult;
import com.elm.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {
    @Autowired
    private DeliveryAddressService deliveryAddressService;
    @GetMapping("/listDeliveryAddressByUserId/{userId}")
    public CommonResult<List>
    listDeliveryAddressByUserId(@PathVariable String userId){
        List<DeliveryAddress> list = deliveryAddressService.listDeliveryAddressByUserId(userId);
        return new CommonResult(200,"success",list);
    }
    @GetMapping("/getDeliveryAddressById/{daId}")
    public CommonResult<DeliveryAddress>
    getDeliveryAddressById(@PathVariable Long daId){
        DeliveryAddress deliveryAddress = deliveryAddressService.getDeliveryAddressById(daId);
        return new CommonResult<>(200,"success",deliveryAddress);
    }
    @PostMapping("/saveDeliveryAddress")
    public CommonResult<Integer>
    saveDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress){
        int result = deliveryAddressService.saveDeliveryAddress(deliveryAddress);
        return new CommonResult<>(200,"success",result);
    }
    @PostMapping("/updateDeliveryAddress")
    public CommonResult<Integer>
    updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress){
        int result = deliveryAddressService.updateDeliveryAddress(deliveryAddress);
        return new CommonResult<>(200,"success",result);
    }
    @DeleteMapping("/removeDeliveryAddress/{daId}")
    public CommonResult<Integer>
    removeDeliveryAddress(@PathVariable("daId") Long daId){
        int result = deliveryAddressService.removeDeliveryAddress(daId);
        return new CommonResult(200,"success",result);
    }
}
