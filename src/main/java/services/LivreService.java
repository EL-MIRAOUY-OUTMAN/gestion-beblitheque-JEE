package services;

import java.util.List;

import model.Livre;

public interface LivreService {

	void createLivre(Livre l);

	List<Livre> getAllLivre();

	Livre getLivre(int isbn);

	void updateLivre(Livre livre);

	void deleteLivre(int isbn);
}