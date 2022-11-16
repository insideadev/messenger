package com.epam.ld.module2.testing.util;

import com.epam.ld.module2.testing.entity.Client;

import java.util.Scanner;

public class ConsoleHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public Client getClientByConsole() {
        System.out.println("Enter message:");
        String msg = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        Client client = new Client();
        client.setMessage(msg);
        client.setEmail(email);
        client.setAddresses(address);

        return client;

    }
}
