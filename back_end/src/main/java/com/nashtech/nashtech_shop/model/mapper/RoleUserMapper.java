package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.RoleUser;

import com.nashtech.nashtech_shop.model.dto.RoleUserDTO;

import lombok.Data;


@Data

public class RoleUserMapper {


    public RoleUserDTO ToRoleUserDTO (RoleUser roleUser){
        RoleUserDTO roleUserDTO = new RoleUserDTO();
        roleUserDTO.setId(roleUser.getId());
        roleUserDTO.setRole(roleUser.getRole());

        return roleUserDTO ;
    }



}
