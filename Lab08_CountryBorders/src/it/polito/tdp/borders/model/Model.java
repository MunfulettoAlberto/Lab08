package it.polito.tdp.borders.model;

import java.util.*;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {

	private BordersDAO bDAO = new BordersDAO();
	public Model() {

	}

	List<Country> countries = new ArrayList<Country>() ;
	List<Border> borders = new ArrayList<Border>() ;
	UndirectedGraph<Country, DefaultEdge> grafo = new SimpleGraph<Country, DefaultEdge>(DefaultEdge.class) ;
	
	public String createGraph(int anno) {
		
		String s = "" ;
		
		countries.addAll(bDAO.loadAllCountries(anno)) ;
		borders.addAll(bDAO.getCountryPairs(anno)) ;
		
		//aggiungo i vertici
		for(Country country : countries){
			grafo.addVertex(country);
		}
		
		//aggiungo i collegamenti
		for(Border border : borders){
			grafo.addEdge(border.getC1(), border.getC2());
		}
		
		for(Country country : countries){
			if(grafo.degreeOf(country)!=0){
				s+= country.getNome()+""+grafo.degreeOf(country)+"\n";
			}
		}
		
		return s ;
	}
	
}
