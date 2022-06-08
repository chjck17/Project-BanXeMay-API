package com.cnpmHDT.api.mapper;

import com.cnpmHDT.api.dto.orders.OrdersDto;
import com.cnpmHDT.api.form.orders.CreateOrdersForm;
import com.cnpmHDT.api.form.orders.UpdateOrdersForm;
import com.cnpmHDT.api.storage.model.Customer;
import com.cnpmHDT.api.storage.model.Orders;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-02T10:00:50+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class OrdersMapperImpl implements OrdersMapper {

    @Override
    public Orders fromCreateOrdersFormToEntity(CreateOrdersForm createOrdersForm) {
        if ( createOrdersForm == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setAddress( createOrdersForm.getOrdersAddress() );
        orders.setReceiverName( createOrdersForm.getOrdersReceiverName() );
        orders.setReceiverPhone( createOrdersForm.getOrdersReceiverPhone() );
        orders.setPaymentMethod( createOrdersForm.getPaymentMethod() );
        orders.setSaleOff( createOrdersForm.getOrdersSaleOff() );

        return orders;
    }

    @Override
    public void fromUpdateOrdersFormToEntity(UpdateOrdersForm updateOrdersForm, Orders orders) {
        if ( updateOrdersForm == null ) {
            return;
        }

        if ( updateOrdersForm.getOrdersAddress() != null ) {
            orders.setAddress( updateOrdersForm.getOrdersAddress() );
        }
        if ( updateOrdersForm.getOrdersReceiverName() != null ) {
            orders.setReceiverName( updateOrdersForm.getOrdersReceiverName() );
        }
        if ( updateOrdersForm.getOrdersReceiverPhone() != null ) {
            orders.setReceiverPhone( updateOrdersForm.getOrdersReceiverPhone() );
        }
        if ( updateOrdersForm.getOrdersId() != null ) {
            orders.setId( updateOrdersForm.getOrdersId() );
        }
    }

    @Override
    public OrdersDto fromEntityToAdminDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setOrdersAddress( orders.getAddress() );
        ordersDto.setOrdersSaleOff( orders.getSaleOff() );
        ordersDto.setOrdersTotalMoney( orders.getTotalMoney() );
        ordersDto.setOrdersReceiverName( orders.getReceiverName() );
        ordersDto.setOrdersCode( orders.getCode() );
        ordersDto.setOrdersPaymentMethod( orders.getPaymentMethod() );
        ordersDto.setOrdersId( orders.getId() );
        ordersDto.setOrdersVat( orders.getVat() );
        ordersDto.setCreatedDate( orders.getCreatedDate() );
        ordersDto.setOrdersState( orders.getState() );
        ordersDto.setCustomerId( ordersCustomerId( orders ) );
        ordersDto.setOrdersReceiverPhone( orders.getReceiverPhone() );

        return ordersDto;
    }

    @Override
    public List<OrdersDto> fromEntityListToOrdersDtoList(List<Orders> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrdersDto> list = new ArrayList<OrdersDto>( orders.size() );
        for ( Orders orders1 : orders ) {
            list.add( fromEntityToAdminDto( orders1 ) );
        }

        return list;
    }

    @Override
    public OrdersDto fromEntityToClientOrdersDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setOrdersSaleOff( orders.getSaleOff() );
        ordersDto.setOrdersAddress( orders.getAddress() );
        ordersDto.setOrdersTotalMoney( orders.getTotalMoney() );
        ordersDto.setOrdersReceiverName( orders.getReceiverName() );
        ordersDto.setOrdersCode( orders.getCode() );
        ordersDto.setOrdersPaymentMethod( orders.getPaymentMethod() );
        ordersDto.setOrdersId( orders.getId() );
        ordersDto.setOrdersState( orders.getState() );

        return ordersDto;
    }

    private Long ordersCustomerId(Orders orders) {
        if ( orders == null ) {
            return null;
        }
        Customer customer = orders.getCustomer();
        if ( customer == null ) {
            return null;
        }
        Long id = customer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
