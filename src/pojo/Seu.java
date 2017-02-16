/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author pedro
 */
public class Seu {


        public String nom;
	protected String direccio;
	public String email;
	protected int zip;
        private Empresa empresa;
        
        public Seu(String nom, String direccio, String email, int zip, Object Empresa) {
        this.nom = nom;
        this.direccio = direccio;
        this.email = email;
        this.zip = zip;
        this.empresa = empresa;
        }

	public Seu() {
	}
 
	// ==========================================================
	// Creem Getters i Setters per totes les variables
	// ==========================================================
 
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
        
        public Empresa getEmpresa() {
            return empresa;
        }

        public void setEmpresa(Empresa empresa) {
            this.empresa = empresa;
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
                result += "empresa:" + getEmpresa() + "\n";
		return result;
	}
}
 

//	public static void main(String[] args) {
// 
//		// Creem i mostrem dos Objecte Padesa
//		Seu roquetes = new Seu();
//                Empresa nom1 = new Empresa();
//                
//		roquetes.setNom("PadesaRoquetes");
//		roquetes.setDireccio("http://Padesaroquetes.cat");
//		roquetes.setEmail("test@padesaroquetes.cat");
//		roquetes.setZip(43520);
//		System.out.println(roquetes);
//               
//                
//                Seu amposta = new Seu();
//                
//		amposta.setNom("PadesaAmposta");
//		amposta.setDireccio("http://Padesaamposta.cat");
//		amposta.setEmail("test@padesaamposta.cat");
//		amposta.setZip(43535);
//                System.out.println(amposta);
//                
//                 Seu reguers = new Seu();
//                
//		reguers.setNom("PadesaReguers");
//		reguers.setDireccio("http://Padesareguers.cat");
//		reguers.setEmail("test@padesareguers.cat");
//		reguers.setZip(43527);
//                System.out.println(reguers);
//                
//                //Afegim els objectes associats a la collecio 
//                
//                nom1.getSeus().add(reguers);
//                nom1.getSeus().add(amposta);
//                nom1.getSeus().add(roquetes);
//
//                
//
//	}
    

