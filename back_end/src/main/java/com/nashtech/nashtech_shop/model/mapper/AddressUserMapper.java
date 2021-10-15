package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.AddressUser;
import com.nashtech.nashtech_shop.model.dto.AddressUserDTO;

public class AddressUserMapper {
    public AddressUserDTO ToAddressUserDTO (AddressUser addressUser){
        AddressUserDTO addressUserDTO = new AddressUserDTO();
        addressUserDTO.setId(addressUser.getId());
        addressUserDTO.setCity(addressUser.getCity());
        addressUserDTO.setDistrict(addressUser.getDistrict());
        addressUserDTO.setStreet(addressUser.getStreet());
        addressUserDTO.setPhone(addressUser.getPhone());

        return addressUserDTO ;
    }




}
