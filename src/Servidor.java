import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
	private Socket socket;
	
	public Servidor (Socket conexao) {
		this.socket = conexao;
	}
	
	@Override
	public void run() {
		try {
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			
			System.out.println(entrada.readUTF() + " passou com sucesso!");
			
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main (String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(5000);
			
			while (true) {
				Socket conexao = servidor.accept();
				Servidor sThread = new Servidor(conexao);
				System.out.println("Conexão concluida com sucesso");
				sThread.start();
			}
			
		} catch (Exception e) {
			
		}
	}
	
}
