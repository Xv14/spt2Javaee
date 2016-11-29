package edu.esprit.PIDev.WitnessBook.services;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.PIDev.WitnessBook.Entities.Categorie;
import edu.esprit.PIDev.WitnessBook.Entities.Evenements;
import edu.esprit.PIDev.WitnessBook.Entities.Registredusers;

@Local
public interface IEvenementService {
	void addOrUpdateEvent(Evenements evenement);

	public List<Evenements> findAllEvents();

	EvenementService findEventById(Integer idEvent);

	void deleteEvent(Evenements evenement);

	List<Evenements> getAllEvents();

	void updateEvent(Evenements evenement);

	public int getnbpays(String pays);

	public List<Categorie> getcategorie();

	public List<Evenements> Search(String name);

	public List<Registredusers> allemp();

	public Registredusers findEmployeeByName(String name);

	public void GeneratePDF(Evenements e);

	public void QrcodeEv(Evenements e);

}
