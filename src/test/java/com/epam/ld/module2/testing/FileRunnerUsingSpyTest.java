package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.runner.FileRunner;
import com.epam.ld.module2.testing.template.TemplateEngine;
import com.epam.ld.module2.testing.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.File;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FileRunnerUsingSpyTest {
    @InjectMocks
    private FileRunner runner;

    @Spy
    private FileUtil util = new FileUtil();

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
        runner = new FileRunner(util, engine, mailServer, messenger);
    }

    @Test
    public void emailShouldReplaceToEmailMessage() throws IOException, ClassNotFoundException {
        Client client = new Client();
        client.setEmail("kenny@epam.com");
        client.setAddresses("Hanoi");
        client.setMessage("#{email}:kenny@epam.com");

        when(util.readObjectFromFile(any(File.class))).thenReturn(client);

        runner.run(new File("client.txt"));
        verify(mailServer).send("Hanoi", "Please send me an email to kenny@epam.com");
    }

    @Test
    public void addressShouldReplaceToHelloMessage() throws IOException, ClassNotFoundException {
        Client client = new Client();
        client.setEmail("kenny@epam.com");
        client.setAddresses("Hanoi");
        client.setMessage("#{address}:Hanoi");

        when(util.readObjectFromFile(any(File.class))).thenReturn(client);

        runner.run(new File("client.txt"));
        verify(mailServer).send("Hanoi", "Hello from Hanoi");
    }
}
