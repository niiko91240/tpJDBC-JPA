package fr.epsi.b32223g1.dal.jdbc.tests;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {
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
        System.out.println(fournisseurJDBC.extraire());
    }
}
