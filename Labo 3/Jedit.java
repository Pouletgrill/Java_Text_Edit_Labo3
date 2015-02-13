//Jedit
//----------------
//Xavier Brosseau
//Charlie Laplante

import java.io.*;

public class Jedit
{
   public static void main ( String args[] )
   {
      //Regarde s'il y a des paramËtres.
      try
      {
         if(args.length <= 0)
         {
            System.err.println("Aucun parametre:");
            System.exit(1);
         }
         //regarde si le paramËtre -n est instancier
         else if (args[0].equals("-n") && args.length == 2)
         {
            EcrireTxt(args[1],true);
         }
         else if (!args[0].equals("-n") && args.length == 2) //si parametre pas "-n"
         {
            System.err.println("Parametre invalide");
            System.exit(1);
         }
         else if (args.length == 1)
         {
            EcrireTxt(args[0],false);
         }
         else
         {
            System.err.println("trop de parametre");
            System.exit(1);
         }
      }
      //Lance erreur
      catch( NumberFormatException e )
      {
         System.err.println("Parametre invalide");
         System.exit(1);
      }
   }

//Fonction qui Ècrit dans le texte
   static void EcrireTxt(String NomFichier, boolean Numero)
   {
      //DÈclaration de la variable PrintWriter
      PrintWriter writer;
      //Bool qui regarde si l'utilisateur a finit d'Ècrire
      boolean pasFini = true;
      //Pour savoir si il faut faire un espace ou non
      boolean PremiereLigne = true;  
      //DÈclaration du Reader des inputs de l'utilisateur
      BufferedReader reader;
      reader = new BufferedReader(
                  new InputStreamReader( System.in));

      File fichier = new File( NomFichier );

     //If qui regarde si le fichier existe.
      if(fichier.exists())
      {
         try
         {
            System.out.println("Le fichier \""+NomFichier+"\" existe deja.");
            System.out.print("Voulez-vous le remplacer? O(oui) N(non)");
            String Reponse = reader.readLine();
            if (Reponse .equals("N") || Reponse.equals("n"))
            {
               System.exit(1);
               System.out.println("Exit ? ou pas...");
            }
         }
         catch (IOException ex)
         {
            System.out.println(ex);
         }
      }

      try
      {

         writer = new PrintWriter(
                     new BufferedWriter(
                        new FileWriter(NomFichier) ) );

         //Boucle qui continue tant que l'utilisateur n'a pas fini d'Ècrire dans le fichier
         for(int i=1;pasFini;i++)
         {
           String text =reader.readLine();
           if (text.length()>0)
           {
                if(Numero)
                {
                   if (PremiereLigne)
                   {
                        writer.print(i+": "+text);
                        PremiereLigne=false;
                   }
                   else
                   {
                      writer.print("\n"+i+": "+text);
                   }
                }
                else
                {
                   if (PremiereLigne)
                   {
                        writer.print(text);
                        PremiereLigne=false;
                   }
                   else
                   {
                        writer.print("\n"+text);
                   }
                }

           }
           else
           {
               pasFini=false;
           }
         }
      //Fermeture du fichier
         writer.close();
      //Fermeture du program
         System.exit(1);
      }
      catch(IOException ioe)
      {
       System.err.println("Le fichier sp√©cifi√© est introuvable");
       System.exit(1);
      }

   }
}