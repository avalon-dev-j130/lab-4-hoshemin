package ru.avalon.java.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * Упражнение на выработку базовых умений использования
 * протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpSender {

    public static void main(String[] args) throws IOException {
        // 1. Подготавливааем сообщение
        final String message = prepareMessage();
        // 2. Подготавливаем адрес
        final SocketAddress address = prepareAddress();
        // 3. Устанавливаем соединение
        Socket socket = connect(address);
        // 4. Отправляем сообщение
        send(socket, message);
        // 5. Закрываем соединеие
        socket.close();
    }

    /**
     * Возвращает объект сообщения.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() throws IOException {
        /*
         * Реализован метод prepareMessage класса TcpSender
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите сообщение: ");
        return reader.readLine();
    }

    /**
     * Возвращает адрес, на который будет выполнена отправка сообщения.
     *
     * @return экземпля типа {@link SocketAddress}
     */
    private static SocketAddress prepareAddress() throws UnknownHostException {
        /*
         * Реализован метод prepareAddress класса TcpSender
         */
        return new InetSocketAddress(InetAddress.getLocalHost(), 8080);
        
    }

    /**
     * Устанавливает соединение на указанный адрес и возвращает сокет
     * описывающий соединение.
     *
     * @param address адрес, на который будет выполено соединение.
     *
     * @return сокет, описывающий открытое соединеие.
     *
     * @throws IOException
     */
    private static Socket connect(SocketAddress address) throws IOException {
        /*
         * Реализован метод connect класса TcpSender
         */
        Socket socket = new Socket();
        socket.connect(address);
        return socket;
    }

    /**
     * Выполняет отправку сообщения {@code message} на {@code socket}.
     *
     * @param socket соединение, через которое будет отправлено сообщение.
     * @param message сообщение
     *
     * @throws IOException
     */
    private static void send(Socket socket, String message) throws IOException {
        /*
         * Реализован метод send класса TcpSender
         */
        if (true) {
            OutputStream stream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(stream);
            writer.println(message);
            writer.flush();
            InputStream newStream = socket.getInputStream();
            Reader reader = new InputStreamReader(newStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String received = bufferedReader.readLine();
            System.out.println(received);
        }
    }

}