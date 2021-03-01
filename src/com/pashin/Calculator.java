package com.pashin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Calculator {
    public double multiply(double a, double b) {
        double result = 0;
        try {
            Socket socket = new Socket("localhost", 5000);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeDouble(a);
            dataOutputStream.writeDouble(b);
            dataOutputStream.flush();

            result = dataInputStream.readDouble();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
