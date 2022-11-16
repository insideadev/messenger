package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.runner.ConsoleRunner;
import com.epam.ld.module2.testing.template.TemplateEngine;
import com.epam.ld.module2.testing.util.ConsoleHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class ConsoleRunnerTest {

    @InjectMocks
    private ConsoleRunner runner;

    @Mock
    private ConsoleHelper helper;

    @Mock
    private ConsoleMailServer mailServer;
    @InjectMocks
    private TemplateEngine engine;
    @InjectMocks
    private Messenger messenger;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        engine = new TemplateEngine();
        messenger = new Messenger(mailServer, engine);
        runner = new ConsoleRunner(helper, engine, mailServer, messenger);
    }

    @Test
    public void emailShouldReplaceToEmailMessage() throws IOException {
        Client client = new Client();
        client.setEmail("kenny@epam.com");
        client.setAddresses("Hanoi");
        client.setMessage("#{email}:kenny@epam.com");

        when(helper.getClientByConsole()).thenReturn(client);

        runner.run();
        verify(mailServer).send("Hanoi", "Please send me an email to kenny@epam.com");
    }

    @Test
    public void addressShouldReplaceToHelloMessage() throws IOException {
        Client client = new Client();
        client.setEmail("kenny@epam.com");
        client.setAddresses("Hanoi");
        client.setMessage("#{address}:Hanoi");

        when(helper.getClientByConsole()).thenReturn(client);

        runner.run();
        verify(mailServer).send("Hanoi", "Hello from Hanoi");
    }
}
