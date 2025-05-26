package com.example.FreshyStore.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FreshyStore.Vegetables.VegetableDetails;

@Repository
public interface VegitablesRepo extends JpaRepository<VegetableDetails, Long> {

    
	@Query(value = "SELECT * FROM vegetable_details ORDER BY Expire_D", nativeQuery = true)
	List<VegetableDetails> getAllSortedByExpireDate();


    
}
