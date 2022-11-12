package com.epam.ld.module2.testing;


import com.epam.ld.module2.testing.template.TemplateEngine;

/**
 * The type Messenger.
 */
public class Messenger {
    private MailServer mailServer;
    private TemplateEngine templateEngine;

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
    public void sendMessage(Client client) {
        String messageContent =
            templateEngine.generateMessage(client);
        mailServer.send(client.getAddresses(), messageContent);
    }
}