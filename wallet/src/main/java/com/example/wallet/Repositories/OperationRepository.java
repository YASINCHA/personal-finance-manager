package com.example.wallet.Repositories;





import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.example.wallet.Entities.Operation;
@Repository
   
public interface OperationRepository extends JpaRepository<Operation, Long> {

   

}
