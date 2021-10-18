package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Order;
import com.nashtech.nashtech_shop.entity.OrderDetail;
import com.nashtech.nashtech_shop.entity.Product;
import lombok.Data;

import javax.persistence.*;


@Data

public class OrderDetailDTO {


    private Long id ;

    private int quantity ;

    private double price ;
    public OrderDetailDTO ToOrderDetailDTO (OrderDetail orderDetail){
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setId(orderDetail.getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setPrice(orderDetail.getPrice());

        return orderDetailDTO ;
    }



}
