package ServerPackage;
import java.io.*;
import java.net.*;
public class Server {
//activite 1.1 et 1.2 et 1.3
	public static void main(String[] args)  {
      try {
    	  System.out.println("je suis un serveur");
          ServerSocket serverSocket = new ServerSocket(1234); //on a fait une réservation du port
          System.out.println("je suis un serveur , j'atend un client");
          Socket socket=serverSocket.accept();// elle accepte la demande de connexion du client et L'attribut socket va retourner une image de type socket.
          //la methode accepte() bloque l'execution jusqu'a un client est connecté 
          System.out.println("un client est connecté");
          //traitement
          // les 2 methode inputstream() et outputstream() sont 2 methodes d'echange de données avec le client
          InputStream is = socket.getInputStream(); // elle prend le contenue de 'os' du client
          OutputStream os = socket.getOutputStream(); 
          int nb=is.read(); //elle recupere le contenu de 'os' du client et le met dans l'attribut nb
          int rep =nb*5; 
          int rep1=nb+5;
          os.write(rep); //elle renvoi la réponse au client 
          os.write(rep1); //elle renvoi la réponse au client
          System.out.println("deconnexion serveur");
          socket.close();
          serverSocket.close(); //libération de tout ce qui est reservé
      }
      catch(Exception e) {e.printStackTrace();}
	}

}