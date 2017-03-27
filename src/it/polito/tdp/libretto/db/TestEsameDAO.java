package it.polito.tdp.libretto.db;

import it.polito.tdp.libretto.model.Esame;

public class TestEsameDAO {
//TODO : mettere nel progetto, in un folder separato, il driver jdbc
	
	public static void main(String[] args) {
			EsameDAO dao = new EsameDAO();
			
			Esame e1 = dao.find("03FYZ");
			
			
	}

}
