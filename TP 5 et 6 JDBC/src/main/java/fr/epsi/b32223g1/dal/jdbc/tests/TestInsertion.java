package fr.epsi.b32223g1.dal.jdbc.tests;
import java.sql.*;
import java.util.ResourceBundle;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;
import fr.epsi.b32223g1.bo.Fournisseur;


public class TestInsertion {
    private static final String DB_URL;
    private static final String DB_LOGIN;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_LOGIN = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }
    public static void main( String[] args) throws SQLException {
        FournisseurJDBCDAO fournisseurJDBC = new FournisseurJDBCDAO();
        Fournisseur fournisseur = new Fournisseur(1, "Aujourd'hui");
        System.out.println(fournisseurJDBC.insert(fournisseur));
    }
}
