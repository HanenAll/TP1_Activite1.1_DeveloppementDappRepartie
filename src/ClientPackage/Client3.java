package ClientPackage;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class Client3 {
	//activite 1.3 partie 2

	public static void main(String[] args)  {
		try{
			System.out.println("je suis un client");
			//Crée une instance de la classe InetAddress pour représenter l'adresse IP "10.25.14.51"
		    InetAddress inetAddress = InetAddress.getByName("localhost"); // chercher moi la machine qui a une @ip 10.25.14.51
		    InetSocketAddress inetSocketAdd = new InetSocketAddress(inetAddress,1234); //inetSocketAdd lien virtuelle entre les 2 machines 
		    Socket socket = new Socket();//socket va etre cree qui signifie un transporteur de données 
		    socket.connect(inetSocketAdd);//socket va connecter sur le chemin des 2 machines 
		    System.out.println("je suis un client connecté");
		    //Récupère un flux d'entrée à partir du socket client. Cela permettra au client d'envoyer des données au serveur
		    InputStream is = socket.getInputStream(); 
		    //Récupère un flux de sortie à partir du socket client. Cela permettra au client d'envoyer des données au serveur
		    OutputStream os = socket.getOutputStream(); 
		    Scanner scanner = new Scanner(System.in);//Utilise un objet Scanner pour lire un entier
		    int nb;
		    System.out.println("nb= "); 
		     nb=scanner.nextInt();
		    int op;
		    //le client choisit la nature de l’opération à exécuter côté serveur à travers un Menu de choix.
		    do
		    {
		    System.out.println("Choisissez la nature de l opération: 1-Addition / 2-Soustraction / 3-Multiplication / 4-Division");
		    op=scanner.nextInt(); // nextLine pour lire un caractère ou une chaine de caractères
		    } while (op < 1 || op > 4 );
		    os.write(nb); //Envoie le nombre nb au serveur via le flux de sortie.
		    os.write(op);//Envoie l'operation au serveur via le flux de sortie.
		    int res =is.read(); //Lit la réponses du serveur à partir du flux d'entrée et la stocke dans res
		    //Affiche le nombre reçu du serveur.
		    System.out.println("le res est="+res); 
		    System.out.println("deconnexion client");
	        socket.close();
		}
		catch(Exception e) {e.printStackTrace();};

	}

}
