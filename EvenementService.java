package edu.esprit.PIDev.WitnessBook.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.esprit.PIDev.WitnessBook.Entities.Categorie;
import edu.esprit.PIDev.WitnessBook.Entities.Evenements;
import edu.esprit.PIDev.WitnessBook.Entities.Registredusers;
import edu.esprit.PIDev.WitnessBook.utils.EmailSender;

@LocalBean
@Stateless
public class EvenementService implements IEvenementService {

	@PersistenceContext
	private EntityManager entityManager;

	public EvenementService() {

	}

	@Override
	public void addOrUpdateEvent(Evenements evenement) {

		entityManager.merge(evenement);
	}

	@Override
	public EvenementService findEventById(Integer idEvent) {
		return entityManager.find(EvenementService.class, idEvent);
	}

	@Override
	public void deleteEvent(Evenements evenement) {
		entityManager.remove(entityManager.merge(evenement));

	}

	@Override
	public List<Evenements> getAllEvents() {
		return entityManager.createQuery("select e from Evenements e", Evenements.class).getResultList();
	}

	@SuppressWarnings("static-access")
	@Override
	public void updateEvent(Evenements evenement) {
		entityManager.merge(evenement);

	}

	@SuppressWarnings("static-access")
	@Override
	public List<Evenements> findAllEvents() {
		EmailSender emailSender = new EmailSender();
		emailSender.SendEmail("mahmoud.ouri@esprit.tn", "mwaher frere", "cv frere ");

		return entityManager.createQuery("select e from Evenements e", Evenements.class).getResultList();
	}

	@Override
	public int getnbpays(String pays) {
		String jpql = "SELECT p FROM Evenements p WHERE p.lieuxPays=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", pays);
		return query.getFirstResult();
	}

	@Override
	public List<Categorie> getcategorie() {
		return entityManager.createQuery(
				"SELECT distinct c  FROM Categorie c,Witnesscards w,Evenements e WHERE (c.idCategorie = w.categorie.idCategorie) and (w.idWitnessCard = e.witnesscards.idWitnessCard) and  SUBSTRING(e.dateFinEvent, 1, 4)=SUBSTRING( CURRENT_DATE , 1, 4) and SUBSTRING(e.dateFinEvent, 6, 2)=SUBSTRING( CURRENT_DATE , 6, 2)",
				Categorie.class).getResultList();

	}

	@Override
	public List<Evenements> Search(String name) {
		TypedQuery<Evenements> query = entityManager.createQuery("SELECT e FROM Evenements e WHERE  e.nameEvent=:param",
				Evenements.class);
		query.setParameter("param", name);
		return query.getResultList();
		// return entityManager.createQuery (")"
		// ,Evenements.class).getResultList();
	}

	@Override
	public List<Registredusers> allemp() {
		return entityManager.createQuery("select e from Registredusers e", Registredusers.class).getResultList();
	}

	@Override
	public Registredusers findEmployeeByName(String name) {
		Registredusers found = null;
		TypedQuery<Registredusers> query = entityManager
				.createQuery("select c from Registredusers c where c.firstname=:x", Registredusers.class);
		query.setParameter("x", name);

		found = query.getSingleResult();

		return found;
	}

	@Override
	public void GeneratePDF(Evenements e) {
		// PdfGen pdfGen = new PdfGen();
		// try {
		// pdfGen.GenYourPdf(e);
		// } catch (Exception e1) {
		// // TODO Auto-generated catch block
		// }

	}

	@SuppressWarnings("static-access")
	public void QrcodeEv(Evenements e) {
		// QrCode qrCode = new QrCode();
		// qrCode.QRCodeEv(e);
	}

}
