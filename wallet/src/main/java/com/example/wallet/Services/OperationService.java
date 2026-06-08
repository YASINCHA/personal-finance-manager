package com.example.wallet.Services;
import com.example.wallet.Entities.Operation;
import java.util.List;



public interface OperationService {
    List<Operation> getAllOperations();
    
  

     // SQL methods
     Operation getOperationById(Long id);
     void saveOperation(Operation operation);
     void updateOperation(Long id, Operation operation);
     void deleteOperation(Long id);

}
