package com.cnpmHDT.api.mapper;

import com.cnpmHDT.api.dto.customer.CustomerDto;
import com.cnpmHDT.api.form.customer.CreateCustomerForm;
import com.cnpmHDT.api.form.customer.CustomerRegisterForm;
import com.cnpmHDT.api.form.customer.UpdateCustomerForm;
import com.cnpmHDT.api.form.customer.UpdateCustomerProfileForm;
import com.cnpmHDT.api.storage.model.Account;
import com.cnpmHDT.api.storage.model.Customer;
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
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer fromCreateCustomerFormToEntity(CreateCustomerForm createCustomerForm) {
        if ( createCustomerForm == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setAccount( createCustomerFormToAccount( createCustomerForm ) );
        customer.setBirthday( createCustomerForm.getBirthday() );
        customer.setAddress( createCustomerForm.getCustomerAddress() );
        customer.setGender( createCustomerForm.getGender() );
        customer.setIsLoyalty( createCustomerForm.getIsLoyalty() );
        customer.setLoyaltyLevel( createCustomerForm.getLoyaltyLevel() );
        customer.setSaleOff( createCustomerForm.getSaleOff() );
        customer.setStatus( createCustomerForm.getStatus() );

        return customer;
    }

    @Override
    public void fromUpdateCustomerFormToEntity(UpdateCustomerForm updateCustomerForm, Customer customer) {
        if ( updateCustomerForm == null ) {
            return;
        }

        if ( customer.getAccount() == null ) {
            customer.setAccount( new Account() );
        }
        updateCustomerFormToAccount( updateCustomerForm, customer.getAccount() );
        if ( updateCustomerForm.getBirthday() != null ) {
            customer.setBirthday( updateCustomerForm.getBirthday() );
        }
        if ( updateCustomerForm.getCustomerAddress() != null ) {
            customer.setAddress( updateCustomerForm.getCustomerAddress() );
        }
        if ( updateCustomerForm.getIsLoyalty() != null ) {
            customer.setIsLoyalty( updateCustomerForm.getIsLoyalty() );
        }
        if ( updateCustomerForm.getLoyaltyLevel() != null ) {
            customer.setLoyaltyLevel( updateCustomerForm.getLoyaltyLevel() );
        }
        if ( updateCustomerForm.getSaleOff() != null ) {
            customer.setSaleOff( updateCustomerForm.getSaleOff() );
        }
        if ( updateCustomerForm.getStatus() != null ) {
            customer.setStatus( updateCustomerForm.getStatus() );
        }
    }

    @Override
    public CustomerDto fromEntityToCustomerProfileDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setLoyaltyLevelCustomer( customer.getLoyaltyLevel() );
        customerDto.setFullName( customerAccountFullName( customer ) );
        customerDto.setAddressCustomer( customer.getAddress() );
        customerDto.setPhone( customerAccountPhone( customer ) );
        customerDto.setGenderCustomer( customer.getGender() );
        customerDto.setBirthdayCustomer( customer.getBirthday() );
        customerDto.setId( customer.getId() );
        customerDto.setEmail( customerAccountEmail( customer ) );
        customerDto.setUsername( customerAccountUsername( customer ) );

        return customerDto;
    }

    @Override
    public CustomerDto fromEntityToAdminDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setLoyaltyLevelCustomer( customer.getLoyaltyLevel() );
        customerDto.setFullName( customerAccountFullName( customer ) );
        customerDto.setSaleOffCustomer( customer.getSaleOff() );
        customerDto.setIsLoyaltyCustomer( customer.getIsLoyalty() );
        customerDto.setAddressCustomer( customer.getAddress() );
        customerDto.setCreatedDate( customer.getCreatedDate() );
        customerDto.setPhone( customerAccountPhone( customer ) );
        customerDto.setCreatedBy( customer.getCreatedBy() );
        customerDto.setGenderCustomer( customer.getGender() );
        customerDto.setModifiedDate( customer.getModifiedDate() );
        customerDto.setBirthdayCustomer( customer.getBirthday() );
        customerDto.setModifiedBy( customer.getModifiedBy() );
        customerDto.setId( customer.getId() );
        customerDto.setEmail( customerAccountEmail( customer ) );
        customerDto.setStatus( customer.getStatus() );

        return customerDto;
    }

    @Override
    public List<CustomerDto> fromEntityListToCustomerDtoList(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( fromEntityToAdminDto( customer ) );
        }

        return list;
    }

    @Override
    public void fromUpdateCustomerProfileFormToEntity(UpdateCustomerProfileForm updateCustomerProfileForm, Customer customer) {
        if ( updateCustomerProfileForm == null ) {
            return;
        }

        if ( customer.getAccount() == null ) {
            customer.setAccount( new Account() );
        }
        updateCustomerProfileFormToAccount( updateCustomerProfileForm, customer.getAccount() );
        if ( updateCustomerProfileForm.getBirthday() != null ) {
            customer.setBirthday( updateCustomerProfileForm.getBirthday() );
        }
        if ( updateCustomerProfileForm.getAddress() != null ) {
            customer.setAddress( updateCustomerProfileForm.getAddress() );
        }
        if ( updateCustomerProfileForm.getGender() != null ) {
            customer.setGender( updateCustomerProfileForm.getGender() );
        }
    }

    @Override
    public Customer fromCustomerRegisterFormToEntity(CustomerRegisterForm customerRegisterForm) {
        if ( customerRegisterForm == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setAccount( customerRegisterFormToAccount( customerRegisterForm ) );
        customer.setAddress( customerRegisterForm.getAddress() );

        return customer;
    }

    protected Account createCustomerFormToAccount(CreateCustomerForm createCustomerForm) {
        if ( createCustomerForm == null ) {
            return null;
        }

        Account account = new Account();

        account.setEmail( createCustomerForm.getCustomerEmail() );
        account.setUsername( createCustomerForm.getCustomerUsername() );
        account.setFullName( createCustomerForm.getCustomerFullName() );
        account.setPhone( createCustomerForm.getCustomerPhone() );

        return account;
    }

    protected void updateCustomerFormToAccount(UpdateCustomerForm updateCustomerForm, Account mappingTarget) {
        if ( updateCustomerForm == null ) {
            return;
        }

        if ( updateCustomerForm.getCustomerEmail() != null ) {
            mappingTarget.setEmail( updateCustomerForm.getCustomerEmail() );
        }
        if ( updateCustomerForm.getCustomerFullName() != null ) {
            mappingTarget.setFullName( updateCustomerForm.getCustomerFullName() );
        }
    }

    private String customerAccountFullName(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Account account = customer.getAccount();
        if ( account == null ) {
            return null;
        }
        String fullName = account.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }

    private String customerAccountPhone(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Account account = customer.getAccount();
        if ( account == null ) {
            return null;
        }
        String phone = account.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    private String customerAccountEmail(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Account account = customer.getAccount();
        if ( account == null ) {
            return null;
        }
        String email = account.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    private String customerAccountUsername(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        Account account = customer.getAccount();
        if ( account == null ) {
            return null;
        }
        String username = account.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    protected void updateCustomerProfileFormToAccount(UpdateCustomerProfileForm updateCustomerProfileForm, Account mappingTarget) {
        if ( updateCustomerProfileForm == null ) {
            return;
        }

        if ( updateCustomerProfileForm.getCustomerEmail() != null ) {
            mappingTarget.setEmail( updateCustomerProfileForm.getCustomerEmail() );
        }
        if ( updateCustomerProfileForm.getCustomerFullName() != null ) {
            mappingTarget.setFullName( updateCustomerProfileForm.getCustomerFullName() );
        }
    }

    protected Account customerRegisterFormToAccount(CustomerRegisterForm customerRegisterForm) {
        if ( customerRegisterForm == null ) {
            return null;
        }

        Account account = new Account();

        account.setUsername( customerRegisterForm.getCustomerUsername() );
        account.setFullName( customerRegisterForm.getCustomerFullName() );
        account.setPhone( customerRegisterForm.getCustomerPhone() );

        return account;
    }
}
