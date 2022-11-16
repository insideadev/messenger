package com.epam.ld.module2.testing;


import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.template.TemplateEngine;

import java.io.IOException;

/**
 * The type Messenger.
 */
public class Messenger {
    private final MailServer mailServer;
    private final TemplateEngine templateEngine;

    /**
     * Instantiates a new Messenger.
     *
     * @param mailServer     the mail server
     * @param templateEngine the template engine
     */
    public Messenger(MailServer mailServer,
                     TemplateEngine templateEngine) {
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    /**
     * Send message.
     *
     * @param client   the client
     */
    public void sendMessage(Client client) throws IOException {
        String messageContent =
            templateEngine.generateMessage(client);
        mailServer.send(client.getAddresses(), messageContent);
    }
}