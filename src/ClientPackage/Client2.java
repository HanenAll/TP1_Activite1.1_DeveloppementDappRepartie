package ClientPackage;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.net.*;
import java.util.Scanner;
public class Client2 {
	//activite 1.3

	public static void main(String[] args)  {
		try{
			System.out.println("je suis un client");
		    InetAddress inetAddress = InetAddress.getByName("10.25.14.51"); // chercher moi la machine qui a une @ip 10.25.14.51
		    InetSocketAddress inetSocketAdd = new InetSocketAddress(inetAddress,1234); //inetSocket lien virtuelle entre les 2 machines 
		    Socket socket = new Socket();//socket va etre cree qui signifie un transporteur de données 
		    socket.connect(inetSocketAdd);//socket va connecter sur le chemin des 2 machines 
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
