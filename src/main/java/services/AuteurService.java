package services;

import java.util.List;

import model.Auteur;

public interface AuteurService {

	void createAuteur(Auteur a);

	List<Auteur> getAllAuteurs();

	Auteur getAuteurByMatricule(int matricule);

	void updateAuteur(Auteur auteur);

	void deleteAuteur(int matricule);
}
