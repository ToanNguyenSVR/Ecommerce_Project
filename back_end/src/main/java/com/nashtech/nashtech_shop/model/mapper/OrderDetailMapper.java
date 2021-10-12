package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.OrderDetail;
import com.nashtech.nashtech_shop.model.dto.OrderDetailDTO;


public class OrderDetailMapper {


    public OrderDetailDTO ToOrderDetailDTO (OrderDetail orderDetail){
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setId(orderDetail.getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setPrice(orderDetail.getPrice());

        return orderDetailDTO ;
    }


}
