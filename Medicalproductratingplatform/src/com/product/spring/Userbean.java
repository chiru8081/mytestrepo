package com.product.spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.QueryAnnotation;

public class Userbean {

	@NotEmpty
	private String patientname;
	@NotEmpty
	private String productname;
	
	@Min(value=1,message="should be greater than 1")
	@Max(value=5,message="should be less than 5")
	private int rating;
	
	

	public Userbean() {
		super();
		System.out.println("no-arg const in Userbean()");
	}
	public Userbean(String patientname, String productname) {
		super();
		this.patientname = patientname;
		this.productname = productname;
		//this.rating = rating;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patientname == null) ? 0 : patientname.hashCode());
		result = prime * result + ((productname == null) ? 0 : productname.hashCode());
		result = prime * result + rating;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Userbean other = (Userbean) obj;
		if (patientname == null) {
			if (other.patientname != null)
				return false;
		} else if (!patientname.equals(other.patientname))
			return false;
		if (productname == null) {
			if (other.productname != null)
				return false;
		} else if (!productname.equals(other.productname))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Userbean [patientname=" + patientname + ", productname=" + productname + ", rating=" + rating + "]";
	}
	
	
}
