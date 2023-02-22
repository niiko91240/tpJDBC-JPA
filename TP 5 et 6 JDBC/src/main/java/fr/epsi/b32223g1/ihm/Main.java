package fr.epsi.b32223g1.ihm;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.bo.Utilisateur;
import fr.epsi.b32223g1.dal.DAOFactory;
import fr.epsi.b32223g1.dal.FournisseurDAO;
import fr.epsi.b32223g1.dal.UtilisateurDAO;
import fr.epsi.b32223g1.dal.jdbc.ArticleJDBCDAO;
import fr.epsi.b32223g1.dal.jdbc.FournisseurJDBCDAO;
import fr.epsi.b32223g1.error.StoreModeNotFoundException;

import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main( String[] args ) {
		authentification();
		
		authentificationSecurisee();
		try {


			FournisseurDAO dao = DAOFactory.getFournisseurDAO();
			
			//Ajout d'un nouveau fournisseur
			dao.insert( new Fournisseur( "L''espace création" ) );
			
			//Extraction
			List<Fournisseur> fournisseurs = dao.extraire();
		
			for ( Fournisseur item : fournisseurs ) {
				System.out.println( item );
			}
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void authentificationSecurisee() {
		
		Scanner scanner = new Scanner( System.in );
		System.out.println("************************************************");
		System.out.println("********** Bienvenue dans mon App Sécurisée ****");
		System.out.println("************************************************");
		try {
			Utilisateur user = null;
			UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
			
			do {
				System.out.println("* Merci de vous identifier ...");
				System.out.print("* Identifiant : ");
				String login = scanner.nextLine();
				System.out.print("* Mot de passe : ");
				String mdp = scanner.nextLine();
				try {
					user = dao.authentificationSecurisee( login, mdp );
					System.out.printf("Bienvenue à toi %s%n", user.getNom());
				} catch ( Exception e ) {
					System.out.println(e.getMessage());
					System.out.println("* Merci de recommencer...");
				}
			} while(user == null);
			
		} catch ( StoreModeNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void authentification() {
		
		
		Scanner scanner = new Scanner( System.in );
		System.out.println("************************************************");
		System.out.println("************ Bienvenue dans mon App ************");
		System.out.println("************************************************");
		try {
			Utilisateur user = null;
			UtilisateurDAO dao = DAOFactory.getUtilisateurDAO();
			
			do {
				System.out.println("* Merci de vous identifier ...");
				System.out.print("* Identifiant : ");
				String login = scanner.nextLine();
				System.out.print("* Mot de passe : ");
				String mdp = scanner.nextLine();
				try {
					user = dao.authentification( login, mdp );
					System.out.printf("Bienvenue à toi %s%n", user.getNom());
					FournisseurJDBCDAO fournisseurJDBCDAO = new FournisseurJDBCDAO();
					Fournisseur fournisseur = new Fournisseur(5, "La Maison de la Peinture");
					fournisseurJDBCDAO.insert(fournisseur);

					ArticleJDBCDAO articleJDBCDAO = new ArticleJDBCDAO();
					Article article = new Article(1, "Peinture blanche 1L", fournisseur, 12.5);
					articleJDBCDAO.insert(article);

					Article article2 = new Article(1, "Peinture rouge mate 1L", fournisseur, 15.5);
					articleJDBCDAO.insert(article2);

					Article article3 = new Article(1, "Peinture noire laquée 1L", fournisseur, 17.8);
					articleJDBCDAO.insert(article3);

					Article article4 = new Article(1, "Peinture bleue mate 1L", fournisseur, 15.5);
					articleJDBCDAO.insert(article4);

					articleJDBCDAO.update("Peinture blanche 1L", "Peinture blanche 1L", article.getPrix()*0.75);
					articleJDBCDAO.update("Peinture rouge mate 1L", "Peinture rouge mate 1L", article2.getPrix()*0.75);
					articleJDBCDAO.update("Peinture noire laquée 1L", "Peinture noire laquée 1L", article3.getPrix()*0.75);
					articleJDBCDAO.update("Peinture bleue mate 1L", "Peinture bleue mate 1L", article4.getPrix()*0.75);

					fournisseurJDBCDAO.delete(fournisseur);
				} catch ( Exception e ) {
					System.out.println(e.getMessage());
					System.out.println("* Merci de recommencer...");
				}
			} while(user == null);
			
		} catch ( StoreModeNotFoundException e ) {
			System.out.println(e.getMessage());
		}
	}
}