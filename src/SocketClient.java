import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
            // соединение с серверным сокетом.
            Socket clientSocket = new Socket("localhost", 50001);

            // осле подключения он получает данные, отправленные сервером
            InputStream is = clientSocket.getInputStream();

            // Входной поток подключается к буферу с помощью BufferedReader, для хранения полученных данных, поскольку мы не можем гарантировать, что данные используются сразу после получения.
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // данные читаются из буфера
            String receivedData = br.readLine();

            // и выводятся в консоль.
            System.out.println("Полученные данные: " + receivedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
