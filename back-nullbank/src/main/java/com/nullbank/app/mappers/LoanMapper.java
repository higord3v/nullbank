package com.nullbank.app.mappers;

import com.nullbank.app.dtos.LoanDTO;
import com.nullbank.app.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface LoanMapper {
        LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

        LoanDTO loanToLoanDTO(Loan loan);
        List<LoanDTO> loanListToLoanDTOList(List<Loan> loans);
}
