import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;

public class simpleBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText();
        String start = update.toString();

        String message0 = "Here is a command list for you !" +
                           "/n"+
                          "/info : To get further information about Zodiacbot."+
                           "/n"+
                          "/run : It is just for testing the bot with a joke."+
                           "/n"+
                          "/convo : It is for starting a conversation.";
       
        SendMessage startmsg = new SendMessage();
        startmsg.setChatId(update.toString());
        startmsg.setText(message0);

        if (command.equals("/run")) {
            String message = "Run, Forest Run !";
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);


            try {
                execute(response);

            } catch (TelegramApiException E) {
                E.printStackTrace();
            }
        }

        if (command.equals("/convo")) {
            String message2 = "Hi, I am Zodiac. How can I help you ?";
            SendMessage response2 = new SendMessage();
            response2.setChatId(update.getMessage().getChatId().toString());
            response2.setText(message2);


            try {
                execute(response2);

            } catch (TelegramApiException E) {
                E.printStackTrace();
            }
        }

        if (command.equals("/info")) {
            String message3 = "Hi, My name is Zodiac. My dad is Botfather and I am a Java coded Chatbot. I am still an " +
                    "unfinished project. I would love to help you!";
            SendMessage response3 = new SendMessage();
            response3.setChatId(update.getMessage().getChatId().toString());
            response3.setText(message3);


            try {
                execute(response3);

            } catch (TelegramApiException E) {
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