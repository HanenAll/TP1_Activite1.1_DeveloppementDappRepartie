package ClientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
	//activite 1.1 et 1.2

	public static void main(String[] args)  {
		try{
			System.out.println("je suis un client");
		    Socket socket=new Socket("192.168.100.11",1234); // une socket va etre crée 
		    // localhost c'est la machine du client et 1234 c'est le port
		    //cette instruction est pour la demande de connexion de client au serveur 
		    System.out.println("je suis un client connecté");
		    InputStream is = socket.getInputStream(); // elle lu le flux qui est dans le port 1234
		    OutputStream os = socket.getOutputStream(); // elle fait sortie le contenue de is et le renvoi au serveur
		    int nb;
		    System.out.println("donner une valeur");
		    Scanner scanner= new Scanner(System.in); // je donne la main au utilisateur d'ecrire une valeur
		    nb=scanner.nextInt(); // nextInt elle lu un entier
		    os.write(nb); // elle envoi la valeur au serveur
		    System.out.println("la multiplication de "+nb+"*5= "+is.read()+" et la somme de "+nb+"+5= "+is.read()); // pour  chaque write()
		    // cote serveur on un read() cote client pour qu'ill affiche le contenu de la reponse 
		    System.out.println("deconnexion client");
	        socket.close();
		}
		catch(Exception e) {e.printStackTrace();};

	}

}
