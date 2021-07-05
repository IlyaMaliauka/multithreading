package Task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private final MailService mailService;
    private final String topic;
    private final String name;

    Receiver(String topic, String name, MailService mailService) {
        this.mailService = mailService;
        this.topic = topic;
        this.name = name;
    }

    public void run() {
        LOGGER.info("Receiver {} has started received messages on topic {}", name, topic);
        while (true) {
            mailService.receiveEmail(topic);
        }
    }
}
