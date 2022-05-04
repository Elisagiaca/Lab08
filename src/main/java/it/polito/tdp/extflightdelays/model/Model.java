package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;


import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	private Graph<Airport, DefaultWeightedEdge> grafo;
	
	
	/*public void creaGrafo(int distanzaMinima) {
		
		this.grafo = new SimpleWeightedGraph<Airport, DefaultEdge>(DefaultEdge.class);
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		List<Airport> listaAeroporti = dao.loadAllAirports();
		
		Graphs.addAllVertices(this.grafo, listaAeroporti);
		
		for(Airport a : listaAeroporti) {
			for (Airport b : listaAeroporti) {
				int somma = 0;
				double media = 0;
				List<Flight> listaVoli = new ArrayList<>();  
				
				if ((this.grafo.containsEdge(a, b)==false) && (a.getId() != b.getId())) {
					listaVoli.addAll(dao.getAeroportoCollegato(a, b)); //restituisce la lista di voli tra l'aeroporto 'a' e l'aeroporto 'b'
					
					for(Flight f : listaVoli) {
						somma = somma + f.getDistance();
					}
					
					if(listaVoli.size() != 0) {
						media = somma/listaVoli.size();
					}
					if(media > distanzaMinima) {
						Graphs.addEdge(this.grafo, a, b, media);
					}
				}
			}
		}
		
		/*System.out.println("Vertici= "+this.grafo.vertexSet().size());
		System.out.println("Archi= "+this.grafo.edgeSet().size());
		for (DefaultEdge d : this.grafo.edgeSet()) {
			System.out.println("Aeroporto partenza: " + this.grafo.getEdgeSource(d).getId() + ", aeroporto destinazione: " + this.grafo.getEdgeTarget(d).getId() + ", peso: " + this.grafo.getEdgeWeight(d));
		}
	}*/
	
	public void creaGrafo(int distanzaMinima) {
		
		this.grafo = new SimpleWeightedGraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		List<Airport> listaAeroporti = dao.loadAllAirports();
		Graphs.addAllVertices(this.grafo, listaAeroporti);
		
		List<CoppiaAeroporti> listaAeroportiConnessi = new ArrayList<>();
		listaAeroportiConnessi.addAll(dao.getAllAeroportiConnessi(distanzaMinima));
		
		Airport partenza = null;
		Airport arrivo = null;
		
		for(CoppiaAeroporti coppia :  listaAeroportiConnessi) {
				for(Airport aeroporto : listaAeroporti) {
					if (coppia.getPartenza_id()==aeroporto.getId()) {
						partenza = aeroporto;
					}
					else if (coppia.getArrivo_id()==aeroporto.getId()) {
						arrivo = aeroporto;
					}
				}
				Graphs.addEdge(this.grafo, partenza, arrivo , coppia.getDistanceMedia());
		}
	}
	
	
	public Graph<Airport, DefaultWeightedEdge> getGrafo() {
		return this.grafo;
	}
}
