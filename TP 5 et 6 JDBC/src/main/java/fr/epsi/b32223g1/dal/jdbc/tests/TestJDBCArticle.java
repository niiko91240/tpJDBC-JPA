package fr.epsi.b32223g1.dal.jdbc.tests;
import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.jdbc.ArticleJDBCDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestJDBCArticle {
    private static final String DB_URL;
    private static final String DB_LOGIN;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_LOGIN = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }

    public static void testSelect() throws SQLException {
        ArticleJDBCDAO articleJDBCDAO = new ArticleJDBCDAO();
        System.out.println(articleJDBCDAO.extraire());
    }

    public static void testUpdate() throws SQLException {
        ArticleJDBCDAO articleJDBCDAO = new ArticleJDBCDAO();
        System.out.println(articleJDBCDAO.update("FDM SA", "nouveauNom", 4.95));
    }

    public static void testDelete() throws SQLException {
        ArticleJDBCDAO articleJDBCDAO = new ArticleJDBCDAO();
        Article article = new Article(1, "testInsert", new Fournisseur(1, "nouveauFournissuer"), 4.99);
        System.out.println(articleJDBCDAO.delete(article));
    }

    public static void testInsertion() throws SQLException {
        ArticleJDBCDAO articleJDBCDAO = new ArticleJDBCDAO();
        Article article = new Article(1, "testInsert", new Fournisseur(1, "nouveauFournissuer"), 5.99);
        System.out.println(articleJDBCDAO.insert(article));
    }


    public static void main( String[] args) throws SQLException {
        testInsertion();
        testDelete();
        testUpdate();
        testSelect();
    }
}
