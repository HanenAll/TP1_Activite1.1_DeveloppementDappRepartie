package ClientPackage;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
		    InetAddress inetAddress = InetAddress.getByName("192.168.100.11"); // chercher moi la machine qui a une @ip 10.25.14.51
		    InetSocketAddress inetSocketAdd = new InetSocketAddress(inetAddress,1234); //inetSocketAdd lien virtuelle entre les 2 machines 
		    Socket socket = new Socket();//socket va etre cree qui signifie un transporteur de données 
		    socket.connect(inetSocketAdd);//socket va connecter sur le chemin des 2 machines 
		    System.out.println("je suis un client connecté");
		    //Récupère un flux d'entrée à partir du socket client. Cela permettra au client d'envoyer des données au serveur
		    InputStream is = socket.getInputStream(); 
		    //Récupère un flux de sortie à partir du socket client. Cela permettra au client d'envoyer des données au serveur
		    OutputStream os = socket.getOutputStream(); 
		    Scanner scanner = new Scanner(System.in);//Utilise un objet Scanner pour lire un entier
		    PrintWriter pw= new PrintWriter(os,true);//PrintWriter nous permet d'envoyer la chaine de caractere caractere par caractere
		    int nb;
		    System.out.println("nb= "); 
		     nb=scanner.nextInt();
		    String op;
		    do {
		    	System.out.println("choisir l'operateur (+,-,*,/) ");
		    	op=scanner.next(); // nextLine elle lu un String
		    }
		    while(!op.equals("+")&& !op.equals("-")&& !op.equals("*")&& !op.equals("/"));
		    os.write(nb); //Envoie le nombre nb au serveur via le flux de sortie.
		    pw.println(op);//pw elle concatine le type par defaut en string 
		    int res =is.read(); //Lit la réponses du serveur à partir du flux d'entrée et la stocke dans res
		    //Affiche le nombre reçu du serveur.
		    System.out.println(nb+""+op+"5 ="+res); 
		    System.out.println("deconnexion client");
	        socket.close();
		}
		catch(Exception e) {e.printStackTrace();};

	}

}
