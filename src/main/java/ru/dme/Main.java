package ru.dme;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Announcer.welcome();
        String result = new Inspector().check(new ConsoleReader().read());
        Announcer.print(result);


    }
}
