import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static final int SERVER_PORT = 50001;

    public static void main(String[] args) {

        try {
            // Создает серверный сокет, используя порт с помощью конструктора
            // сервер открывает сокет из порта 50001
            ServerSocket server = new ServerSocket(SERVER_PORT);

            // Прослушивает соединения, используя метод serverSocket.accept().Это блокирующий вызов и ожидание поступления запроса.
            // ожидает клиента
            Socket clientConn = server.accept();

            // После подключения клиента создается выходной поток. Это можно использовать для отправки данных с сервера подключенному клиенту.
            DataOutputStream serverOutput = new DataOutputStream(clientConn.getOutputStream());
            serverOutput.writeBytes("JAVA\n");

            // После отправки данных соединение с клиентом закрывается.
            clientConn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}