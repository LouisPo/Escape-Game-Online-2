package fr.louispo.gameescape;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * La classe Ressource.
 */
public class Resource {

   /**
    * Charge la liste des propriétés contenu dans le fichier spécifié
    *
    * @param filename le fichier contenant les propriétés
    * @return un objet Properties contenant les propriétés du fichier
    */
   public static Properties load(String filename) throws IOException {

      Properties properties = new Properties();
      FileInputStream fichierProperties = null;

      try {
         fichierProperties = new FileInputStream(filename);
         properties.load(fichierProperties);
      }
      catch(FileNotFoundException e) {
         System.out.println("Fichier non trouvé !!! Vérifiez le chemin d'accès.");
      }
      catch(IOException e) {
         System.out.println("Autre Exception non catchée explicitement. IOException représente tout type d'exception qui peut survenir.");
         e.printStackTrace();
      }
      finally {
         if (fichierProperties != null) {
            fichierProperties.close();
         }
      }

      return properties;
   }
}