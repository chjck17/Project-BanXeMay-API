package com.cnpmHDT.api.mapper;

import com.cnpmHDT.api.dto.ordersdetail.OrdersDetailDto;
import com.cnpmHDT.api.form.ordersdetail.CreateOrdersDetailForm;
import com.cnpmHDT.api.storage.model.Orders;
import com.cnpmHDT.api.storage.model.OrdersDetail;
import com.cnpmHDT.api.storage.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-02T10:00:50+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class OrdersDetailMapperImpl implements OrdersDetailMapper {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public OrdersDetail fromCreateOrdersDetailFormToEntity(CreateOrdersDetailForm createOrdersDetailForm) {
        if ( createOrdersDetailForm == null ) {
            return null;
        }

        OrdersDetail ordersDetail = new OrdersDetail();

        ordersDetail.setProduct( createOrdersDetailFormToProduct( createOrdersDetailForm ) );
        ordersDetail.setAmount( createOrdersDetailForm.getOrdersDetailAmount() );

        return ordersDetail;
    }

    @Override
    public List<OrdersDetail> fromCreateOrdersDetailFormListToOrdersDetailList(List<CreateOrdersDetailForm> createOrdersDetailFormList) {
        if ( createOrdersDetailFormList == null ) {
            return null;
        }

        List<OrdersDetail> list = new ArrayList<OrdersDetail>( createOrdersDetailFormList.size() );
        for ( CreateOrdersDetailForm createOrdersDetailForm : createOrdersDetailFormList ) {
            list.add( fromCreateOrdersDetailFormToEntity( createOrdersDetailForm ) );
        }

        return list;
    }

    @Override
    public OrdersDetailDto fromEntityToAdminDto(OrdersDetail ordersDetail) {
        if ( ordersDetail == null ) {
            return null;
        }

        OrdersDetailDto ordersDetailDto = new OrdersDetailDto();

        ordersDetailDto.setOrdersDetailAmount( ordersDetail.getAmount() );
        ordersDetailDto.setOrdersDetailId( ordersDetail.getId() );
        ordersDetailDto.setProductName( ordersDetailProductName( ordersDetail ) );
        ordersDetailDto.setOrdersDetailPrice( ordersDetail.getPrice() );
        ordersDetailDto.setOrdersId( ordersDetailOrdersId( ordersDetail ) );

        return ordersDetailDto;
    }

    @Override
    public List<OrdersDetailDto> fromEntityListToOrdersDetailDtoList(List<OrdersDetail> ordersDetails) {
        if ( ordersDetails == null ) {
            return null;
        }

        List<OrdersDetailDto> list = new ArrayList<OrdersDetailDto>( ordersDetails.size() );
        for ( OrdersDetail ordersDetail : ordersDetails ) {
            list.add( fromEntityToAdminDto( ordersDetail ) );
        }

        return list;
    }

    @Override
    public OrdersDetailDto fromEntityToOrdersDetailClientDto(OrdersDetail ordersDetail) {
        if ( ordersDetail == null ) {
            return null;
        }

        OrdersDetailDto ordersDetailDto = new OrdersDetailDto();

        ordersDetailDto.setOrdersDetailAmount( ordersDetail.getAmount() );
        ordersDetailDto.setOrdersDetailId( ordersDetail.getId() );
        ordersDetailDto.setProductDto( productMapper.fromEntityToClientDtoDetailProduct( ordersDetail.getProduct() ) );
        ordersDetailDto.setOrdersDetailPrice( ordersDetail.getPrice() );

        return ordersDetailDto;
    }

    @Override
    public List<OrdersDetailDto> fromEntityListToOrdersDetailClientDtoList(List<OrdersDetail> ordersDetailList) {
        if ( ordersDetailList == null ) {
            return null;
        }

        List<OrdersDetailDto> list = new ArrayList<OrdersDetailDto>( ordersDetailList.size() );
        for ( OrdersDetail ordersDetail : ordersDetailList ) {
            list.add( fromEntityToOrdersDetailClientDto( ordersDetail ) );
        }

        return list;
    }

    protected Product createOrdersDetailFormToProduct(CreateOrdersDetailForm createOrdersDetailForm) {
        if ( createOrdersDetailForm == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( createOrdersDetailForm.getProductId() );

        return product;
    }

    private String ordersDetailProductName(OrdersDetail ordersDetail) {
        if ( ordersDetail == null ) {
            return null;
        }
        Product product = ordersDetail.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long ordersDetailOrdersId(OrdersDetail ordersDetail) {
        if ( ordersDetail == null ) {
            return null;
        }
        Orders orders = ordersDetail.getOrders();
        if ( orders == null ) {
            return null;
        }
        Long id = orders.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
