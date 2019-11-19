package ru.dme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    public String read() throws IOException {
        StringBuilder request = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            if (s.equals("exit")) {
                break;
            } else {
                request.append(s).append("\n");
            }
        }
        bufferedReader.close();
        return request.toString();
    }
}
