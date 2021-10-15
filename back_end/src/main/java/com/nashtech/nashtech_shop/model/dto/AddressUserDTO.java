package com.nashtech.nashtech_shop.model.dto;

import com.nashtech.nashtech_shop.entity.Account;
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

}
