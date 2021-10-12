package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.OrderDetail;
import com.nashtech.nashtech_shop.entity.StatusOrder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data

public class OrderDTO {


    private Long id ;


    private String note ;
    private String creat_date ;
    private double totalPrice ;






}
