package com.example.wallet.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.wallet.Dto.OperationDTO;

public class OperationRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<OperationDTO> getAllOperations() {
        String sql = "CALL GetOperationDetails()";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new OperationDTO(
            rs.getLong("operationId"),
            rs.getString("operationType"),
            rs.getLong("category"),
            rs.getDouble("amount"),
            rs.getString("createdAt"),
            rs.getString("updatedAt"),
            rs.getDouble("amount_signed"),
            rs.getDouble("amount_credit"),
            rs.getDouble("amount_debit")
        ));
    }
}
