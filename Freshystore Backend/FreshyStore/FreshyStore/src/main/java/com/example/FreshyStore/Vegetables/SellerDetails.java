package com.example.FreshyStore.Vegetables;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SellerDetails {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long s_id;

	    private String s_name;
	    private Date Join_Dt ;
	    private String contact;
		public Long getS_id() {
			return s_id;
		}
		public void setS_id(Long s_id) {
			this.s_id = s_id;
		}
		public String getS_name() {
			return s_name;
		}
		public void setS_name(String s_name) {
			this.s_name = s_name;
		}
		public Date getJoin_Dt() {
			return Join_Dt;
		}
		public void setJoin_Dt(Date join_Dt) {
			Join_Dt = join_Dt;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
	

	
	
	
}
