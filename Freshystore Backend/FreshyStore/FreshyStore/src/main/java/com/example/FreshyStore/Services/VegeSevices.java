package com.example.FreshyStore.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FreshyStore.Exceptions.ResourceNotFoundException;
import com.example.FreshyStore.Vegetables.VegetableDetails;
import com.example.FreshyStore.repositories.VegitablesRepo;

@Service
public class VegeSevices {
    @Autowired 
    VegitablesRepo repo;
 
    public void saveVegetable(VegetableDetails veg) {
    	veg.autoCalculateFields();
    	repo.save(veg);
	}
	public VegetableDetails getVegetable(Long id) {
		VegetableDetails veg =repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Vegetable is Spoiled")) ;
		return veg;
	}
	public void deleteVegetable(Long id) {
		repo.delete(getVegetable(id));
	}
	public VegetableDetails updateVegetable(VegetableDetails veg) {
		VegetableDetails pat1 = getVegetable(veg.getV_id());
		pat1.setV_name(veg.getV_name());
		pat1.setPurchase_Dt(veg.getPurchase_Dt());
		pat1.setFreshDates(veg.getFreshDates());
		pat1.setBuyingCost(veg.getBuyingCost());
		pat1.setImageUrl(veg.getImageUrl());  // Add this line
		return repo.save(pat1);
	}
	public List<VegetableDetails> getAllSortedByExpireDate() {
	    return repo.getAllSortedByExpireDate();
	   
	}
	

	

 
}
