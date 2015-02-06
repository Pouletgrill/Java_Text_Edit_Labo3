import java.io.*;

public class Jedit
{
   public static void main ( String args[] )
   {
      try 
      {
         if(args.length <= 0)
         {
            System.out.println("Aucun parametre:");
            System.exit(1);            
         }         
         else if (args[0] == "-n" && args.length == 2)
         {
            AfficherTxt(args[1],true);
         }
         else
         {
            AfficherTxt(args[0],false);
         }
      }
      catch( NumberFormatException e )
      {
         System.err.println("Erreur ?!?!?!??!");
         System.exit(1);
      }
   }
   
   public static void AfficherTxt(String NomFichier, boolean Numero)
   {
      BufferedReader reader;
      boolean pasFini = true;
      String ligne;
      
      try
      {
        reader = new BufferedReader(new FileReader(NomFichier));
        while( pasFini)
        {
            ligne = reader.readLine();            
            if( ligne != null )
            {
               if (Numero)
                  
               System.out.println( ligne );
            }
            else
            {
               pasFini = false;
            }
        }
        reader.close();
      }
      catch (IOException ex)
      {
         System.err.println("Le fichier spécifié est introuvable");
         System.exit(1);
      }
   }
   
   static void EcrireTxt(String NomFichier)
   {
      //PrintWriter Writer;
      
   }
}