package com.example.persistence;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String description;
	private int prix;
	private int quantite;
	
	public Plat() {
		
	}
	
	public Plat(String description, int prix, int quantite) {
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	@OneToMany(mappedBy="plat")
	private List<Commande> commandes; 
	
	@OneToMany(mappedBy = "plat")
	private List<Image> image;
	
	public List<Image> getImage() {
		return image;
	}
	public void setImage(List<Image> image) {
		this.image = image;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
