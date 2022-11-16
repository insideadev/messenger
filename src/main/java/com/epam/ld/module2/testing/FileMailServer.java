package com.epam.ld.module2.testing;

import java.io.FileWriter;
import java.io.IOException;

public class FileMailServer implements MailServer {
    @Override
    public void send(String addresses, String messageContent) throws IOException {
        try (FileWriter writer = new FileWriter("output.txt")) {
            String content = String.format("Sending message: [%s] to %s%n", messageContent, addresses);
            writer.write(content);
        } catch (Exception e) {
            System.err.printf("An error occurred %s", e);
            throw e;
        }

    }
}
