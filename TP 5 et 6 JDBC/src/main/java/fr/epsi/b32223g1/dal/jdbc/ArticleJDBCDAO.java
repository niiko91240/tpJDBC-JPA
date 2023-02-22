package fr.epsi.b32223g1.dal.jdbc;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.ArticleDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArticleJDBCDAO implements ArticleDAO {

    private static final String FIND_ALL_QUERY = "SELECT * FROM article";
    private static final String INSERT_QUERY = "INSERT INTO article (NAME, FOURNISSEUR, prix) VALUES ( ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE article SET name = ?, prix = ? WHERE name = ?;";
    private static final String DELETE_QUERY = "DELETE FROM article WHERE id = ?;";

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
    public List<Article> extraire() throws SQLException {

        List<Article> list = new ArrayList<>();
        try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
              Statement st = connection.createStatement();
              ResultSet rs = st.executeQuery( FIND_ALL_QUERY ) ) {

            while ( rs.next() ) {
                int id = rs.getInt( "ID" );
                String nom = rs.getString( "NAME" );
                Fournisseur fournisseur = (Fournisseur) rs.getObject("fournisseur");
                Double prix = rs.getDouble("prix");
                Article article = new Article( id, nom, fournisseur, prix );
                list.add( article );
            }
        }
        return list;
    }

    @Override
    public int insert(Article article ) throws SQLException {
        try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
              PreparedStatement prest = connection.prepareStatement(INSERT_QUERY); ) {
            prest.setString(1, article.getName());
            prest.setObject(2, article.getFournisseur().getId());
            prest.setDouble(3, article.getPrix());
            int row = prest.executeUpdate();
            return row;
        }
    }

    @Override
    public int update( String ancienNom, String nouveauNom, Double nouveauPrix ) throws SQLException {
        try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
              PreparedStatement prest = connection.prepareStatement(UPDATE_QUERY); ) {
            prest.setString(1, nouveauNom);
            prest.setDouble(2, nouveauPrix);
            prest.setString(3, ancienNom);
            int row = prest.executeUpdate();
            return row;
        }
    }

    @Override
    public boolean delete( Article article ) throws SQLException {
        int row = 0;
        try ( Connection connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
              PreparedStatement prest = connection.prepareStatement(DELETE_QUERY); ) {
            prest.setInt(1, article.getId());
            row = prest.executeUpdate();
        }
        if(row != 0){
            return true;
        } else {
            return false;
        }

    }
}
