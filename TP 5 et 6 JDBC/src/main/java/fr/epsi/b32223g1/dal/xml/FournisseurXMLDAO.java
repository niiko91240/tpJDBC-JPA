package fr.epsi.b32223g1.dal.xml;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;

import java.util.ArrayList;
import java.util.List;

public class FournisseurXMLDAO implements FournisseurDAO {
	@Override
	public List<Fournisseur> extraire() throws Exception {
		//TODO à coder
		System.out.println("XML extraire");
		return new ArrayList<>();
	}
	
	@Override
	public int insert(Fournisseur fournisseur ) {
		//TODO à coder
		System.out.println("XML insert");
        return 0;
    }
	
	@Override
	public int update( String ancienNom, String nouveauNom ) {
		//TODO à coder
		return 0;
	}
	
	@Override
	public boolean delete( Fournisseur fournisseur ) {
		//TODO à coder
		return false;
	}
}
