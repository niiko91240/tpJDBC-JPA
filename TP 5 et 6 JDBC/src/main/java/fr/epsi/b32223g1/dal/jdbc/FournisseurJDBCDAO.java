package fr.epsi.b32223g1.dal.jdbc;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurJDBCDAO implements FournisseurDAO {
	
	private static final String FIND_ALL_QUERY = "SELECT * FROM fournisseur";
	private static final String INSERT_QUERY = "INSERT INTO fournisseur (NAME) VALUES ( ? )";
	private static final String UPDATE_QUERY = "UPDATE fournisseur SET name = ? WHERE name = ?;";
	private static final String DELETE_QUERY = "DELETE FROM fournisseur WHERE id = ?;";
	
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle( "db" );
		DB_URL = bundle.getString( "db.url" );
		DB_USER = bundle.getString( "db.user" );
		DB_PWD = bundle.getString( "db.password" );
	}
	
	@Override
	public List<Fournisseur> extraire() throws SQLException {
		
		List<Fournisseur> list = new ArrayList<>();
		try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
			  Statement st = connection.createStatement();
			  ResultSet rs = st.executeQuery( FIND_ALL_QUERY ) ) {
			
			while ( rs.next() ) {
				int id = rs.getInt( "ID" );
				String nom = rs.getString( "NAME" );
				Fournisseur fournisseur = new Fournisseur( id, nom );
				list.add( fournisseur );
			}
		}
		return list;
	}
	
	@Override
	public int insert(Fournisseur fournisseur ) throws SQLException {
		try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
			  PreparedStatement prest = connection.prepareStatement(INSERT_QUERY); ) {
			prest.setString(1, fournisseur.getName());
			int row = prest.executeUpdate();
			return row;
		}
	}

	@Override
	public int update( String ancienNom, String nouveauNom ) throws SQLException {
		try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
			  PreparedStatement prest = connection.prepareStatement(UPDATE_QUERY); ) {
			prest.setString(1, nouveauNom);
			prest.setString(2, ancienNom);
			int row = prest.executeUpdate();
			return row;
		}
	}
	
	@Override
	public boolean delete( Fournisseur fournisseur ) throws SQLException {
		int row = 0;
		try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
			  PreparedStatement prest = connection.prepareStatement(DELETE_QUERY); ) {
			prest.setInt(1, fournisseur.getId());
			row = prest.executeUpdate();
		}
		if(row != 0){
			return true;
		} else {
			return false;
		}

	}
}
