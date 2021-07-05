package Task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sender implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    private final MailService mailService;
    private final String name;

    public String getName() {
        return name;
    }

    Sender(String name, MailService mailService) {
        this.mailService = mailService;
        this.name = name;
    }

    public void run() {
        LOGGER.info("Sender {} has started sending mails", name);
        while (true) {
            mailService.sendEmail(this);
        }
    }

}
