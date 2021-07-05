package Task3;

public class Sender implements Runnable {

    private final MailService mailService;
    private String name;

    public String getName() {
        return name;
    }

    Sender(String name, MailService mailService) {
        this.mailService = mailService;
        this.name = name;
    }

    public void run() {
        while (true) {
            mailService.sendEmail(this);
        }
    }

}
