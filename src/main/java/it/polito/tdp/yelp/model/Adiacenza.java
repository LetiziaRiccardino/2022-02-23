package it.polito.tdp.yelp.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Adiacenza {
	
	private String v1;
	private String v2;
	private LocalDate date1;
	private LocalDate date2;
	public Adiacenza(String v1, String v2, LocalDate date1, LocalDate date2) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.date1 = date1;
		this.date2 = date2;
	}
	public String getV1() {
		return v1;
	}
	public String getV2() {
		return v2;
	}
	public LocalDate getDate1() {
		return date1;
	}
	public LocalDate getDate2() {
		return date2;
	}
	
		
	//Metodo per calcolare il peso dell'arco
	public Double getPeso() {
		Double peso = (double) ChronoUnit.DAYS.between(date1,date2);
		return peso;
	}
	

}
