package com.nashtech.nashtech_shop.model.mapper;



import com.nashtech.nashtech_shop.entity.Order;
import com.nashtech.nashtech_shop.model.dto.OrderDTO;


public class OrderMapper {


    public OrderDTO ToOrderDTO (Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setNote(order.getNote());
        orderDTO.setCreat_date(order.getCreat_date());
        orderDTO.setTotalPrice(order.getTotalPrice());

        return orderDTO ;
    }





}
