package com.example.wallet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.wallet.Dto.OperationDTO;
import com.example.wallet.Entities.Operation;
import com.example.wallet.Repositories.OperationRepository;
import com.example.wallet.Repositories.OperationRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class OperationServiceImpl /*implements OperationService*/ {
@Autowired
    private OperationRepository operationRepository;
       @Autowired
    private JdbcTemplate jdbcTemplate;
    //@Override
    

    @Autowired
    private OperationRepositoryImpl NewoperationRepository;

    public List<OperationDTO> getAllOperations2() {
        return NewoperationRepository.getAllOperations();
    }

  
// SQL methods


//@Override
public Operation getOperationById(Long id) {
    String sql = "SELECT * FROM operation WHERE Operation_ID = ?";
    List<Operation> operations = jdbcTemplate.query(sql, new Object[]{id}, new OperationRowMapper());
    return operations.stream().findFirst().orElse(null);  // Returns null if no operation is found
}

//@Override
public void saveOperation(Operation operation) {
    String sql = "INSERT INTO operation (Operation_Type, Category, amount) VALUES (?, ?, ?)";
    jdbcTemplate.update(sql, operation.getOperationType(), operation.getCategory(), operation.getAmount());
}

//@Override
public void updateOperation(Long id, Operation operation) {
    String sql = "UPDATE operation SET Operation_Type = ?, Category = ?, amount = ? WHERE Operation_ID = ?";
    jdbcTemplate.update(sql, operation.getOperationType(), operation.getCategory(), operation.getAmount(), id);
}

//@Override
public void deleteOperation(Long id) {
    String sql = "DELETE FROM operation WHERE Operation_ID = ?";
    jdbcTemplate.update(sql, id);
}
     private static class OperationRowMapper implements RowMapper<Operation> {
        @Override
        public Operation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Operation operation = new Operation();
            operation.setOperationId(rs.getLong("Operation_ID"));
            operation.setOperationType(rs.getString("Operation_Type"));
            operation.setCategory(rs.getLong("Category"));
            operation.setAmount(rs.getDouble("amount"));
            return operation;
        }
    }} 
        

