package com.nashtech.nashtech_shop.model.dto;

import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.AddressUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data

@AllArgsConstructor
@NoArgsConstructor
public class AddressUserDTO {

    private Long id ;
    private Long Phone  ;
    private Long city  ;
    private Long District ;
    private Long Street ;


    public static AddressUserDTO ToAddressUserDTO (AddressUser addressUser){
        AddressUserDTO addressUserDTO = new AddressUserDTO();
        addressUserDTO.setId(addressUser.getId());
        addressUserDTO.setCity(addressUser.getCity());
        addressUserDTO.setDistrict(addressUser.getDistrict());
        addressUserDTO.setStreet(addressUser.getStreet());
        addressUserDTO.setPhone(addressUser.getPhone());

        return addressUserDTO ;
    }

}
