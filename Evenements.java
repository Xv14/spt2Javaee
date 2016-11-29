package edu.esprit.PIDev.WitnessBook.Entities;
// Generated Nov 26, 2016 12:13:14 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Evenements generated by hbm2java
 */
@Entity
@Table(name = "evenements", catalog = "witnessbook")
public class Evenements implements java.io.Serializable {

	private Integer idEvenement;
	private Registredusers registredusers;
	private Witnesscards witnesscards;
	private Date dateDebutEvent;
	private Date dateFinEvent;
	private String description;
	private String lieuxPays;
	private String lieuxRue;
	private String lieuxVille;
	private String nameEvent;
	private String typeEvent;
	private Set<Witnesscards> witnesscardses = new HashSet<Witnesscards>(0);

	public Evenements() {
	}

	public Evenements(Registredusers registredusers, Witnesscards witnesscards, Date dateDebutEvent, Date dateFinEvent,
			String description, String lieuxPays, String lieuxRue, String lieuxVille, String nameEvent,
			String typeEvent, Set<Witnesscards> witnesscardses) {
		this.registredusers = registredusers;
		this.witnesscards = witnesscards;
		this.dateDebutEvent = dateDebutEvent;
		this.dateFinEvent = dateFinEvent;
		this.description = description;
		this.lieuxPays = lieuxPays;
		this.lieuxRue = lieuxRue;
		this.lieuxVille = lieuxVille;
		this.nameEvent = nameEvent;
		this.typeEvent = typeEvent;
		this.witnesscardses = witnesscardses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idEvenement", unique = true, nullable = false)
	public Integer getIdEvenement() {
		return this.idEvenement;
	}

	public void setIdEvenement(Integer idEvenement) {
		this.idEvenement = idEvenement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agent_idUser")
	public Registredusers getRegistredusers() {
		return this.registredusers;
	}

	public void setRegistredusers(Registredusers registredusers) {
		this.registredusers = registredusers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "witnesscard")
	public Witnesscards getWitnesscards() {
		return this.witnesscards;
	}

	public void setWitnesscards(Witnesscards witnesscards) {
		this.witnesscards = witnesscards;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateDebutEvent", length = 19)
	public Date getDateDebutEvent() {
		return this.dateDebutEvent;
	}

	public void setDateDebutEvent(Date dateDebutEvent) {
		this.dateDebutEvent = dateDebutEvent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateFinEvent", length = 19)
	public Date getDateFinEvent() {
		return this.dateFinEvent;
	}

	public void setDateFinEvent(Date dateFinEvent) {
		this.dateFinEvent = dateFinEvent;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "lieux_pays")
	public String getLieuxPays() {
		return this.lieuxPays;
	}

	public void setLieuxPays(String lieuxPays) {
		this.lieuxPays = lieuxPays;
	}

	@Column(name = "lieux_rue")
	public String getLieuxRue() {
		return this.lieuxRue;
	}

	public void setLieuxRue(String lieuxRue) {
		this.lieuxRue = lieuxRue;
	}

	@Column(name = "lieux_ville")
	public String getLieuxVille() {
		return this.lieuxVille;
	}

	public void setLieuxVille(String lieuxVille) {
		this.lieuxVille = lieuxVille;
	}

	@Column(name = "nameEvent")
	public String getNameEvent() {
		return this.nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	@Column(name = "TypeEvent")
	public String getTypeEvent() {
		return this.typeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "witnesscardtraiteevenements", catalog = "witnessbook", joinColumns = {
			@JoinColumn(name = "Evenement_idEvenement", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "WitnessCardTraite_idWitnessCard", nullable = false, updatable = false) })
	public Set<Witnesscards> getWitnesscardses() {
		return this.witnesscardses;
	}

	public void setWitnesscardses(Set<Witnesscards> witnesscardses) {
		this.witnesscardses = witnesscardses;
	}

}