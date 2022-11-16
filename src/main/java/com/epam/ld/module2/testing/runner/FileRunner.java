package com.epam.ld.module2.testing.runner;

import com.epam.ld.module2.testing.entity.Client;
import com.epam.ld.module2.testing.MailServer;
import com.epam.ld.module2.testing.Messenger;
import com.epam.ld.module2.testing.template.TemplateEngine;
import com.epam.ld.module2.testing.util.FileUtil;

import java.io.File;
import java.io.IOException;

public class FileRunner {

    private final FileUtil fileUtil;
    private final TemplateEngine engine;
    private final MailServer mailServer ;
    private final Messenger messenger  ;

    public FileRunner(FileUtil fileUtil, TemplateEngine engine, MailServer mailServer, Messenger messenger) {
        this.fileUtil = fileUtil;
        this.engine = engine;
        this.mailServer = mailServer;
        this.messenger = messenger;
    }

    public void run(File file) throws IOException {
        Client client = fileUtil.getClientByFile(file);
        messenger.sendMessage(client);
    }


}
