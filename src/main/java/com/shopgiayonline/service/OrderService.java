package com.shopgiayonline.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.shopgiayonline.entity.Order;
import com.shopgiayonline.model.dto.OrderDetailDto;
import com.shopgiayonline.model.dto.OrderInfoDto;
import com.shopgiayonline.model.request.CreateOrderReq;
import com.shopgiayonline.model.request.UpdateDetailOrderReq;
import com.shopgiayonline.model.request.UpdateStatusOrderReq;

@Service
public interface OrderService {
    public Order createOrder(CreateOrderReq req, long userId);

    public List<OrderInfoDto> getListOrderOfPersonByStatus(int status, long userId);

    public OrderDetailDto userGetDetailById(long id, long userId);

    public void userCancelOrder(long id, long userId);

    public Page<Order> adminGetListOrder(String id, String name, String phone, String status, String product, int page);

    public Order getOrderById(long id);

    public void updateDetailOrder(UpdateDetailOrderReq req, long id, long userId);

    public void updateStatusOrder(UpdateStatusOrderReq req, long id, long userId);

}
