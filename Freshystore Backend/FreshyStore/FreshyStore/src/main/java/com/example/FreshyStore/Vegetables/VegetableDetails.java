package com.example.FreshyStore.Vegetables;
import jakarta.persistence.Lob;
import jakarta.persistence.Column;
import java.util.Calendar;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VegetableDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long v_id;

    private String v_name;
    private Date Purchase_Dt;
    private double freshDates;
    private Date Expire_D;
    @ManyToOne
    @JoinColumn(name = "s_id",nullable=false) 
    private SellerDetails seller;

    private int buyingCost;
    private int sellingCost;
    
    @Lob
    @Column(length = 100000)  // This allows for storing large text content like base64 images
    private String imageUrl;

    public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	// Constructor to auto-fill fields
    public VegetableDetails() {
        this.Purchase_Dt = new Date(); // Set system date by default
    }

    // Custom method to auto-calculate fields
    public void autoCalculateFields() {
        // Set system date
        this.Purchase_Dt = new Date();

        // Set Expiry Date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.Purchase_Dt);
        calendar.add(Calendar.DAY_OF_MONTH, (int) this.freshDates);
        this.Expire_D = calendar.getTime();

        // Calculate selling price with 20% profit
        this.sellingCost = (int) Math.round(this.buyingCost * 1.20);
    }

    // Getters and setters (unchanged)
    public Long getV_id() {
        return v_id;
    }

    public void setV_id(Long v_id) {
        this.v_id = v_id;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public Date getPurchase_Dt() {
        return Purchase_Dt;
    }

    public void setPurchase_Dt(Date purchase_Dt) {
        this.Purchase_Dt = purchase_Dt;
    }

    public double getFreshDates() {
        return freshDates;
    }

    public void setFreshDates(double freshDates) {
        this.freshDates = freshDates;
    }

    public Date getExpire_D() {
        return Expire_D;
    }

    public void setExpire_D(Date expire_D) {
        this.Expire_D = expire_D;
    }

    public SellerDetails getSeller() {
        return seller;
    }

    public void setSeller(SellerDetails seller) {
        this.seller = seller;
    }


    public int getBuyingCost() {
        return buyingCost;
    }

    public void setBuyingCost(int buyingCost) {
        this.buyingCost = buyingCost;
    }

    public int getSellingCost() {
        return sellingCost;
    }

    public void setSellingCost(int sellingCost) {
        this.sellingCost = sellingCost;
    }
}
