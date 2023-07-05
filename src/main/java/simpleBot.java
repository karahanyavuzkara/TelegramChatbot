import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class simpleBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText();

        if (command.equals("/run")) {
            String message = "Run, Forest Run !";
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);


            try {
                execute(response);

            }catch (TelegramApiException E) {
                E.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        // TODO
        return "karahanzodiac_bot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "6311821361:AAHb_oh-4K6oTvJ92drx3goT-wAWOrIxXKo";
    }

}