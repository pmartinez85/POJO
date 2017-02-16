/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Empresa {
    
    public Empresa(String nom, String direccio, String email, int zip) {
        this.nom = nom;
        this.direccio = direccio;
        this.email = email;
        this.zip = zip;
    }
    
	public String nom;
	protected String direccio;
	public String email;
	protected int zip;
        private List<Seu> seus = new ArrayList<>();
        
	public Empresa() {
	}
        
	// =====================================================
	// Creem Getters i Setters per totes les variables
	// =====================================================
	
        public String getNom() {
		return nom;
	}
 
	public void setNom(String nom) {
		this.nom = nom;
	}
 
	protected String getDireccio() {
		return direccio;
	}
 
	protected void setDireccio(String direccio) {
		this.direccio = direccio;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	protected int getZip() {
		return zip;
	}
 
	protected void setZip(int zip) {
		this.zip = zip;
	}
        
        public List<Seu> getSeus(){
            return seus;
        }
        
        public void setSeus(ArrayList<Seu> seus){
            this.seus = seus;
            
        }
	// ==========================================================
	// Creem un String de descripcio de l'objecte Padesa
	// ==========================================================
        @Override
	public String toString() {
		String result = "Nom: " + getNom() + "\n";
		result += "Direccio: " + getDireccio() + "\n";
		result += "email: " + getEmail() + "\n";
		result += "zip: " + getZip() + "\n";
		return result;
	}
 
}
    

