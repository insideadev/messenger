package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.runner.FileRunner;
import com.epam.ld.module2.testing.template.TemplateEngine;
import com.epam.ld.module2.testing.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FileRunnerTest {
    @InjectMocks
    private FileRunner runner;

    @Mock
    private FileUtil util;

    @Mock
    private FileMailServer mailServer;

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

    @ParameterizedTest
    @ValueSource(strings = {"kenny@epam.com", "kenny2@epam.com"})
    public void emailShouldReplaceToEmailMessage(String email) throws IOException {
        Client client = new Client();
        client.setEmail(email);
        client.setAddresses("Hanoi");
        client.setMessage("#{email}:" + email);

        when(util.getClientByFile(any())).thenReturn(client);

        runner.run(new File("client.txt"));
        verify(mailServer).send("Hanoi", "Please send me an email to " + email);
    }

    @Test
    public void addressShouldReplaceToHelloMessage() throws IOException {
        Client client = new Client();
        client.setEmail("kenny@epam.com");
        client.setAddresses("Hanoi");
        client.setMessage("#{address}:Hanoi");

        when(util.getClientByFile(any())).thenReturn(client);

        runner.run(new File("client.txt"));
        verify(mailServer).send("Hanoi", "Hello from Hanoi");
    }

    @Test
    public void expectThrowsException() throws IOException {
        Client client = new Client();
        client.setEmail("kenny@epam.com");
        client.setAddresses("Hanoi");
        client.setMessage("#{address}:Hanoi");

        when(util.getClientByFile(any())).thenReturn(client);
        doThrow(IOException.class).when(mailServer).send(any(), any());

        assertThrows(IOException.class, () -> runner.run(new File("client.txt")));
    }
}
