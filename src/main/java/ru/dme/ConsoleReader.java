package ru.dme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//This class is reading information which user write to console
class ConsoleReader {

    String read() throws IOException {
        StringBuilder request = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            //when user write "stop" input ends
            if (s.equals("stop")) {
                break;
            } else {
                //all that user was written collect to one big request to the nalog.ru
                request.append(s).append("\n");
            }
        }
        bufferedReader.close();
        return request.toString();
    }
}
