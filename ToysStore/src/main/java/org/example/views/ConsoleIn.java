package org.example.views;

import java.io.Console;
import java.util.Scanner;

public class ConsoleIn implements InputInterface {
    Scanner scanner = new Scanner(System.in);
    @Override
    public int inputMenu()
    {
        return scanner.nextInt();
    }

    @Override
    public String inputString() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    @Override
    public int inputInt() {
        return scanner.nextInt();
    }
}
