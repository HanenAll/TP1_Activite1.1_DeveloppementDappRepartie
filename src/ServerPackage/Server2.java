package ServerPackage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server2 {
//activite  1.3 partie 2
	public static void main(String[] args)  {
      try {
    	  System.out.println("je suis un serveur");
          ServerSocket serverSocket = new ServerSocket(1234); //on a fait une réservation du port
          System.out.println("je suis un serveur , j'atend un client");
          Socket socket=serverSocket.accept();// elle accepte la demande de connexion du client et 
          //L'attribut socket va retourner une image de type socket.
          //la methode accepte() bloque l'execution jusqu'a un client est connecté 
          System.out.println("un client est connecté");
          //traitement
          // les 2 methode inputstream() et outputstream() sont 2 methodes d'echange de données avec le client
          InputStream is = socket.getInputStream(); // elle reçoit le contenue de 'os' du client
          OutputStream os = socket.getOutputStream(); 
          InputStreamReader isr=new InputStreamReader(is); // InputStreamReader lu 4 octect , elle fait appel 4 fois au InputStream
          BufferedReader br = new BufferedReader(isr);//Bufferedreader collecte toute la chaine
          int nb=is.read(); //is.read() recupere le contenu de 'os' du client et le met dans l'attribut nb
          String op=br.readLine(); //br.readline() elle lu l'operateur
          int res;
          switch(op) {
          case "+":res=nb+5;break;
          case"-":res=nb-5;break;
          case"*": res=nb*5;break;
          case"/":res=nb/5;break;
          default: res=0;
          }
          os.write(res); //elle renvoi la réponse au client
          System.out.println("deconnexion serveur");
          socket.close();
          serverSocket.close(); //libération de tout ce qui est reservé
      }
      catch(Exception e) {e.printStackTrace();}
	}

}