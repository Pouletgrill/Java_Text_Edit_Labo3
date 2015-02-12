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
         else if (args[0].equals("-n") && args.length == 2)
         {
            EcrireTxt(args[1],true);
         }
         else
         {
            EcrireTxt(args[0],false);
         }
      }
      catch( NumberFormatException e )
      {
         System.err.println("Parametre invalide");
         System.exit(1);
      }
   }


   static void EcrireTxt(String NomFichier, boolean Numero)
   {
      PrintWriter writer;
      boolean pasFini = true;
      BufferedReader reader;
      reader = new BufferedReader(
                  new InputStreamReader( System.in));

      File fichier = new File( NomFichier );
     
      if(fichier.exists())
      {
         try
         {
            System.out.println("Le fichier \""+NomFichier+"\" existe deja.");
            System.out.println("Voulez-vous le remplacer? O(oui) N(non)");
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


         for(int i=1;pasFini;i++)
         {
           String text =reader.readLine();
           if (text.length()>0)
           {
                if(Numero)
                {
                 writer.println(i+": "+text);

                }
                else
                {
                 writer.println(text);
                }

           }
           else
           {
               pasFini=false;
           }
         }

         writer.close();

         System.exit(1);
      }
      catch(IOException ioe)
      {
       System.err.println("Le fichier spécifié est introuvable");
       System.exit(1);
      }

   }
}