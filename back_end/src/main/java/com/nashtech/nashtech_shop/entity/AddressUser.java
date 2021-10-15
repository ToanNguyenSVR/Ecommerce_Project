package com.nashtech.nashtech_shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class AddressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long Phone  ;
    private Long city  ;
    private Long District ;
    private Long Street ;

    @OneToMany(mappedBy = "address_user" , cascade = CascadeType.ALL)
    private List<Account> accounts ;




}
