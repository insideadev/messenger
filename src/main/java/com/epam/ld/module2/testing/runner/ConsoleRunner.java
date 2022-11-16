package com.epam.ld.module2.testing.runner;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.MailServer;
import com.epam.ld.module2.testing.Messenger;
import com.epam.ld.module2.testing.template.TemplateEngine;
import com.epam.ld.module2.testing.util.ConsoleHelper;

import java.io.IOException;

public class ConsoleRunner {

    private final ConsoleHelper consoleHelper;
    private final TemplateEngine engine;
    private final MailServer mailServer ;
    private final Messenger messenger  ;

    public ConsoleRunner(ConsoleHelper consoleHelper, TemplateEngine engine, MailServer mailServer, Messenger messenger) {
        this.consoleHelper = consoleHelper;
        this.engine = engine;
        this.mailServer = mailServer;
        this.messenger = messenger;
    }

    public void run() throws IOException {
        Client client = consoleHelper.getClientByConsole();
        messenger.sendMessage(client);
    }


}
