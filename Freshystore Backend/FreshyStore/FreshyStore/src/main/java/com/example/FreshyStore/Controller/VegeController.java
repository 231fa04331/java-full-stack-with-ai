package com.example.FreshyStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FreshyStore.Services.VegeSevices;
import com.example.FreshyStore.Vegetables.VegetableDetails;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/veg")
public class VegeController {

	 @Autowired
	    private VegeSevices serv;

	    @PostMapping("/save")
	    public void saveVegetable(@RequestBody VegetableDetails pat) {
	        serv.saveVegetable(pat);
	    }

	    @GetMapping("/get/{id}")
	    public ResponseEntity<VegetableDetails> getVegetable(@PathVariable Long id) {
	        return ResponseEntity.ok(serv.getVegetable(id));
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteVegetable(@PathVariable Long id) {
	        serv.deleteVegetable(id);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<VegetableDetails> update(@RequestBody VegetableDetails pat) {
	        return ResponseEntity.ok(serv.updateVegetable(pat));
	    }
	    
	    
	    @GetMapping("/sortedbyexpiry")
	    public ResponseEntity<List<VegetableDetails>> getSortedByExpiry() {
	        return ResponseEntity.ok(serv.getAllSortedByExpireDate());
	       
	    }


}
