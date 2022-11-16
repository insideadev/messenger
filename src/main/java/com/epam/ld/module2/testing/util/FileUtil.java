package com.epam.ld.module2.testing.util;

import com.epam.ld.module2.testing.entity.Client;

import java.io.*;

public class FileUtil {

    @SuppressWarnings("unchecked")
    public <T> T readObjectFromFile(File file) throws IOException, ClassNotFoundException {
        T result;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (T) ois.readObject();
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    public Client getClientByFile(File file) {
        Client client = null;

        try {
            client = readObjectFromFile(file);
        } catch (Exception e) {
            System.out.printf("An error occurred: %s", e.getMessage());
        }

        return client;

    }


}
