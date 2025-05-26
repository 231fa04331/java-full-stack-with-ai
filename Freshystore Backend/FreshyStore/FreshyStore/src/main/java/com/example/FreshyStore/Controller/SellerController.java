package com.example.FreshyStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.FreshyStore.Services.SellerServices;
import com.example.FreshyStore.Vegetables.SellerDetails;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerServices serv;

    @PostMapping("/save")
    public void saveSeller(@RequestBody SellerDetails seller) {
        serv.saveSeller(seller);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SellerDetails> getSeller(@PathVariable Long id) {
        return ResponseEntity.ok(serv.getSeller(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeller(@PathVariable Long id) {
        serv.deleteSeller(id);
    }

    @PutMapping("/update")
    public ResponseEntity<SellerDetails> updateSeller(@RequestBody SellerDetails seller) {
        return ResponseEntity.ok(serv.updateSeller(seller));
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<SellerDetails>> getAllSellers() {
        return ResponseEntity.ok(serv.getAllSellers());
    }
}
