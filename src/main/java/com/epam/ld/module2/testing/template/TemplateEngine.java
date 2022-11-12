package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

import java.util.Objects;

import static com.epam.ld.module2.testing.template.Template.ADDRESS_PLACE_HOLDER;
import static com.epam.ld.module2.testing.template.Template.EMAIL_PLACE_HOLDER;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param client   the client
     * @return the string
     */
    public String generateMessage( Client client) {
        Objects.requireNonNull(client.getMessage());

        String[] msg = client.getMessage().split(":");

        if (msg.length <= 1 || msg[1].trim().length() == 0) {
            throw new IllegalArgumentException("Missing message");
        }

        String placeHolder = msg[0];
        String value = msg[1];
        switch (placeHolder) {
            case ADDRESS_PLACE_HOLDER:
                return Template.HELLO_FROM.replace(placeHolder, value);

            case EMAIL_PLACE_HOLDER:
                return Template.SEND_EMAIL.replace(placeHolder, value);

            default:
                return null;
        }
    }
}
