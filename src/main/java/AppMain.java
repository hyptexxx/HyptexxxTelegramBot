import config.DefaultConnectionConfig;
import entity.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import service.BotService;

public class AppMain {
    private static final BotService botService = new BotService();

    public static void main(String[] args) {
        ApiContextInitializer.init();
        botService.botConnect(new Bot());
    }
}
