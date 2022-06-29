package it.polito.tdp.yelp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.yelp.db.YelpDao;

public class Model {
	
	private YelpDao dao;
	private Graph <Review, DefaultWeightedEdge> grafo;
	private Map<String, Review> idMap;
	
	public Model() {
		dao= new YelpDao();
	}
	
	public List<String> getCity(){
		return dao.getCity();
	}
	public List<Business> getBusiness(String city){
		return dao.getBusiness(city);
	}
	
	public String creaGrafo(Business b) {
		this.grafo= new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		idMap= dao.getVertici(b);
		//VERTICI
		Graphs.addAllVertices(this.grafo, dao.getVertici(b).values());
		System.out.println("#vertici "+this.grafo.vertexSet().size());
		//ARCHI
		List<Adiacenza> adiac= dao.getArchi(b);
		for(Adiacenza a: adiac) {
			if(a.getPeso()>0.0) {
				Graphs.addEdge(this.grafo, idMap.get(a.getV1()), idMap.get(a.getV2()), a.getPeso());
			}
		}
		System.out.println("#archi "+this.grafo.edgeSet().size());
		
		return "Grafo creato. Numero vertici: "+this.grafo.vertexSet().size()+". Numero archi: "+this.grafo.edgeSet().size()+"\n";
		
	}

	public List<Massimo> getRecensioneMassima() {
		Integer max=0;
		List<Massimo> massimo= new ArrayList<>();
		for(Review r: this.grafo.vertexSet()) {
				int archiUscenti= this.grafo.outDegreeOf(r);
				if(archiUscenti>max) {
					massimo.clear();
					max=archiUscenti;
					massimo.add(new Massimo(r,max));
				}else if(archiUscenti==max) {
					massimo.add(new Massimo(r,max));
				}
		
		}
		return massimo;
		
	}
	
	
}
