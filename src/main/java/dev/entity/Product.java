package dev.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product extends SuperEntity{

	@ManyToOne
    @JoinColumn( name="packaging_id" )
    private Packaging packaging;
	
}
