package Task3;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MailService {

    private final List<String> TOPICS = Arrays.asList("Sport", "IT", "News", "Spam");
    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);
    private int product = 0;
    public String mailTopic;

    public synchronized void receiveEmail(String topic) {
        if (topic.equals(mailTopic)) {
            product--;
            LOGGER.info("Receiver has received an email on topic {}", topic);
            LOGGER.info("Total emails: {}", product);
            mailTopic = StringUtils.EMPTY;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.error(e.getLocalizedMessage());
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
    }

    public synchronized void sendEmail(Sender sender) {
        product++;
        mailTopic = generateRandomMailTopic();
        LOGGER.info("Sender {} has sent an email on topic \"{}\". Total email sent: {}", sender.getName(), mailTopic, product);
        try {
            wait();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    private String generateRandomMailTopic() {
        Random random = new Random();
        return TOPICS.get(random.nextInt(TOPICS.size()));
    }
}
