package com.example.FreshyStore.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FreshyStore.Exceptions.ResourceNotFoundException;
import com.example.FreshyStore.Vegetables.SellerDetails;
import com.example.FreshyStore.repositories.SellerRepository;
import java.util.List;

@Service
public class SellerServices {

    @Autowired
    private SellerRepository repo; // ✅ Correct repository interface

    // Save seller
    public void saveSeller(SellerDetails seller) {
        repo.save(seller);
    }

    // Get seller by ID
    public SellerDetails getSeller(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new ResourceNotFoundException("Seller not found with ID: " + id));
    }

    // Delete seller
    public void deleteSeller(Long id) {
        repo.delete(getSeller(id));
    }

    // Update seller
    public SellerDetails updateSeller(SellerDetails seller) {
        SellerDetails existing = getSeller(seller.getS_id());
        existing.setS_name(seller.getS_name());
        existing.setJoin_Dt(seller.getJoin_Dt());
        existing.setContact(seller.getContact());
        return repo.save(existing);
    }
    
 // Get all sellers
    public List<SellerDetails> getAllSellers() {
        return repo.findAll();
    }
    
}
