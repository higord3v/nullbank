package com.nullbank.app.mappers;

import com.nullbank.app.dtos.CreateCustomerDTO;
import com.nullbank.app.dtos.CreatedCustomerDTO;
import com.nullbank.app.dtos.CustomerDTO;
import com.nullbank.app.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CreatedCustomerDTO customerToCreatedCustomerDTO(Customer customer);
    List<CreatedCustomerDTO> customerListToCreatedCustomerDTOList(List<Customer> customers);
}
