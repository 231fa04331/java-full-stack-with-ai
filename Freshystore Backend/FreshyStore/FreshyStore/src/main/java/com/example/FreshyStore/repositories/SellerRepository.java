package com.example.FreshyStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FreshyStore.Vegetables.SellerDetails;
@Repository
public interface SellerRepository extends JpaRepository<SellerDetails, Long> {
}
