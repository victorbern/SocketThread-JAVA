import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
	
	public static void main (String[] args) {
		
		try {
			Socket socket;
			socket = new Socket("127.0.0.1", 5000);
			String msg;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Envie uma mensagem ao server");			
			msg = br.readLine();
			
			DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
			
			while (msg!="sair") {
				saida.writeUTF(msg);
				System.out.println("Envie uma mensagem ao server");
				msg = br.readLine();
			}
			
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}
}
