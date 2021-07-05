package Task3;

public class Runner {

    public static void main(String[] args) {
        MailService mailService = new MailService();

        Sender sender1 = new Sender("Ivan", mailService);
        Sender sender2 = new Sender("Jack", mailService);
        Receiver sportReceiver = new Receiver("Sport", "SportReceiver", mailService);
        Receiver itReceiver = new Receiver("IT", "ItReceiver", mailService);
        Receiver newsReceiver = new Receiver("News", "NewsReceiver", mailService);
        Receiver spamReceiver = new Receiver("Spam", "SpamReceiver", mailService);

        new Thread(sportReceiver).start();
        new Thread(itReceiver).start();
        new Thread(newsReceiver).start();
        new Thread(spamReceiver).start();
        new Thread(sender1).start();
        new Thread(sender2).start();
    }

}
