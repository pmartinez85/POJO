/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;

/**
 *
 * @author pedro
 */
public class Vista {

    public static void main(String[] args)
            throws Exception {
        new File("soda.yap").delete();
        ObjectContainer db = null;
        try {

            db = (ObjectContainer) Db4oEmbedded.openFile("soda.yap");

            Empresa emp1 = (new Empresa("Padesa", "http://padesa.cat", "test@padesa.cat", 43500));
            Empresa emp2 = (new Empresa("Disi", "http://disi.cat", "test@disi.cat", 43500));

            Seu seu0 = new Seu("PadesaRoquetes", "http://Padesaroquetes.cat", "test@padesaroquetes.cat", 43520, "Padesa");
            Seu seu1 = new Seu("PadesaAmposta", "http://Padesaamposta.cat", "test@padesaamposta.cat", 43535, "Padesa");
            Seu seu2 = new Seu("Padesareguers", "http://Padesareguers.cat", "test@padesareguers.cat", 43527, "Padesa");
            Seu seu3 = new Seu("PadesaValencia", "http://PadesaValencia.cat", "test@padesavalencia.cat", 46727, "Padesa");
            Seu seu4 = new Seu("DisiRoquetes", "http://DisiRoquetes.cat", "test@disiroquetes.cat", 43520, "Disi");
            Seu seu5 = new Seu("DisiAmposta", "http://DisiAmposta.cat", "test@disiamposta.cat", 43535, "Disi");
            Seu seu6 = new Seu("DisiReguers", "http://DisiReguers.cat", "test@disireguers.cat", 43527, "Disi");
            Seu seu7 = new Seu("DisiValencia", "http://DisiValencia.cat", "test@disivalencia.cat", 46727, "Disi");

            emp1.getSeus().add(seu0);
            emp1.getSeus().add(seu1);
            emp1.getSeus().add(seu2);
            emp1.getSeus().add(seu3);
            emp2.getSeus().add(seu4);
            emp2.getSeus().add(seu5);
            emp2.getSeus().add(seu6);
            emp2.getSeus().add(seu7);
            db.store(emp1);
            db.store(emp2);
                
                //Modificacions
            System.out.println("Abans de Modificar:");

            ObjectSet<Seu> seus = db.queryByExample(new Seu("PadesaRoquetes", "http://Padesaroquetes.cat", "test@padesaroquetes.cat", 43520, "Padesa"));

            for (Seu s : seus) {
                System.out.println(s.toString());
            }

            seu0.setNom("NovaPadesaRoquetes");
            db.store(seu0);

            System.out.println("Després de Modificar:");

            for (Seu s : seus) {
                System.out.println(s.toString());
            }
            
                //Esborrat
                
            System.out.println("Abans de borrar:");
            Seu seuDelete = new Seu("PadesaDelete", "http://Padesaroquetes.cat", "test@padesaroquetes.cat", 43520, "Padesa");
            db.store(seuDelete);
            ObjectSet<Seu> seusDelete = db.queryByExample(new Seu("PadesaDelete", "http://Padesaroquetes.cat", "test@padesaroquetes.cat", 43520, "Padesa"));

            for (Seu s : seusDelete) {
                System.out.println(s.toString());
            }
            
            db.delete(seuDelete);
            System.out.println("Després de borrar:");
             for (Seu s : seusDelete) {
                System.out.println(s.toString());
            }
             
            //Consultes
            
            System.out.println("Consulta amb dos filtres(and):");

            Query q1 = db.query();
            q1.constrain(Seu.class);
            q1.descend("nom").constrain("PadesaAmposta").and(q1.descend("zip").constrain(43535));

            ObjectSet<Seu> result1 = q1.execute();
            for (Seu e : result1) {
                System.out.println(e.toString());
            }
            
            
            System.out.println("Consulta amb dos filtres(greater and Smaller):");

            
            Query q2 = db.query();
            q2.constrain(Seu.class);
            q2.descend("zip").constrain(43520).greater().and(q2.descend("zip").constrain(43530).smaller());

            ObjectSet<Seu> result2 = q2.execute();
            for (Seu e : result2) {
                System.out.println(e.toString());
            }
            
            System.out.println("Consulta amb dos filtres(greater or Smaller):");

            Query q3 = db.query();
            q3.constrain(Seu.class);
            q3.descend("zip").constrain(43520).smaller().or(q3.descend("zip").constrain(43530).greater());

            ObjectSet<Seu> result3 = q3.execute();
            for (Seu e : result3) {
                System.out.println(e.toString());
            }
            
            System.out.println("Consulta ordenant resultats per nom i excluint els resultats que comencen per Pa(Padesa):");

            Query q4 = db.query();
            q4.constrain(Seu.class);
            q4.descend("nom").orderAscending().constrain("Pa").like().not();

            ObjectSet<Seu> result4 = q4.execute();
            for (Seu e : result4) {
                System.out.println(e.toString());
            }
           
        } finally {
            if (db != null) {
                System.out.println("-----------------------------------");
            }
            System.out.println("|Tanquem la Base de Dades. Gràcies|");
            System.out.println("-----------------------------------");
            db.close();
        }
    }

}
