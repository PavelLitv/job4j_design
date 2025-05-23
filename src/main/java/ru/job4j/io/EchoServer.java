package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String requestLine = input.readLine();
                    String param = getParam(requestLine);
                    if ("Hello".equals(param)) {
                        output.write(("HTTP/1.1 200 OK\r\n\r\n" + "Hello, dear friend.").getBytes());
                    } else if ("Exit".equals(param)) {
                        output.write(("HTTP/1.1 200 OK\r\n\r\n" + "Goodbye, dear friend.").getBytes());
                        server.close();
                    } else {
                        output.write(("HTTP/1.1 200 OK\r\n\r\n" + param).getBytes());
                    }
                    output.flush();
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private static String getParam(String requestLine) {
        String param = "";
        if (requestLine != null) {
            String[] parts = requestLine.split(" ");
            if (parts.length > 1) {
                int index = parts[1].indexOf("=");
                param = parts[1].substring(index + 1);
            }
        }
        return param;
    }
}
