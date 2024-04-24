import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
    public static void main(String[] args) {
        final int PORT = 1234; // Puerto en el que el servidor escucha las conexiones entrantes


        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor en linea...");

            while (true) {

                // Esperar conexiones entrantes
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress().getHostName());

                // Configurar flujo de entrada y salida para el cliente
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Leer mensaje del cliente
                String mensaje = in.readLine();
                System.out.println("Mensaje del cliente: " + mensaje);

                // Enviar respuesta al cliente
                out.println("Hola, cliente");

                // Cerrar conexiones
                out.close();
                in.close();
                clientSocket.close();
                //serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
