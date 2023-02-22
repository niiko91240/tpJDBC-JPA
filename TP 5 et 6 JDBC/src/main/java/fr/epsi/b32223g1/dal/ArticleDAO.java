package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.bo.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDAO {

    List<Article> extraire() throws Exception;

    int insert(Article fournisseur )throws Exception;

    int update( String ancienNom, String nouveauNom, Double nouveauPrix ) throws SQLException;

    boolean delete( Article fournisseur ) throws SQLException;
}
