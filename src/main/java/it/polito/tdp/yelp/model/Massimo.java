package it.polito.tdp.yelp.model;

public class Massimo {
	
	private Review recensioni;
	private Integer nArchiUscenti;
	public Massimo(Review recensioni, Integer nArchiUscenti) {
		super();
		this.recensioni = recensioni;
		this.nArchiUscenti = nArchiUscenti;
	}
	public Review getRecensioni() {
		return recensioni;
	}
	public void setRecensioni(Review recensioni) {
		this.recensioni = recensioni;
	}
	public Integer getnArchiUscenti() {
		return nArchiUscenti;
	}
	public void setnArchiUscenti(Integer nArchiUscenti) {
		this.nArchiUscenti = nArchiUscenti;
	}
	@Override
	public String toString() {
		return "IDrecensione=" + recensioni.getReviewId() + ", ArchiUscenti=" + nArchiUscenti ;
	}
	
	

}
