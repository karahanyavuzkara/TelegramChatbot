import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Random;
import java.io.Serializable;

public class simpleBot extends TelegramLongPollingBot {

    private static final String[] quotesArray = {

            "“Everything we see in the world is the creative work of women.”\n" +
                    "― Mustafa Kemal Atatürk, Atatürk: First President and Founder of the Turkish Republic",


            "“Teachers are the one and only people who save nations.”\n" +
                    "― Mustafa Kemal Atatürk",


            "“Peace at Home, Peace in the World”\n" +
                    "― Mustafa Kemal Atatürk",


           "“Our true mentor in life is science.”\n" +
                    "― Mustafa Kemal Atatürk",


           "“Dinlenmemek üzere yola çıkanlar asla yorulmazlar.”\n" +
                   "― Mustafa Kemal Atatürk",



         "“Büyük olmak için kimseye iltifat etmeyeceksin, hiç kimseyi aldatmayacaksın, ülke için gerçek amaç ne ise onu görecek ve o hedefe yürüyeceksin." +

         "Herkes senin aleyhinde bulunacaktır, herkes seni yolundan çevirmeye çalışacaktır. " +
         "Fakat sen buna karşı direneceksin, önüne sonsuz engeller de yığacaklardır; kendini büyük değil küçük, zayıf, araçsız, hiç sayarak, kimseden yardım gelmeyeceğine inanarak bu engelleri aşacaksın." +

         "Bundan sonra da sana büyük derlerse, bunu söyleyenlere güleceksin.”\n" +
            "― Mustafa Kemal Atatürk",


         "“You have power over your mind - not outside events. Realize this, and you will find strength.”\n" +
            "― Marcus Aurelius, Meditations ",


         "“The happiness of your life depends upon the quality of your thoughts.”\n" +
           "― Marcus Aurelius, Meditations",


         "“Waste no more time arguing about what a good man should be. Be one.”\n" +
            "― Marcus Aurelius, Meditations",


         "“It is not death that a man should fear, but he should fear never beginning to live.”\n" +
            "― Marcus Aurelius, Meditations",


         "“Never let the future disturb you. You will meet it, if you have to, with the same weapons of reason which today arm you against the present.”\n" +
           "― Marcus Aurelius, Meditations",


         "“Whenever you are about to find fault with someone, ask yourself the following question: What fault of mine most nearly resembles the one I am about to criticize?”\n" +
            "― Marcus Aurelius, Meditations",


         "“How much more grievous are the consequences of anger than the causes of it.”\n" +
            "― Marcus Aurelius, Meditations",


         "“Do not act as if you were going to live ten thousand years. Death hangs over you. While you live, while it is in your power, be good.”\n" +
            "― Marcus Aurelius"

    };

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText();
        String start = update.toString();

        String message0 = "Here is a command list for you !" +
                "/n" +
                "/info : To get further information about Zodiacbot." +
                "/n" +
                "/run : It is just for testing the bot with a joke." +
                "/n" +
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

        if (command.equals("/quoteOTD")) {
            String randomQuote = getRandomQuote();
            System.out.println(randomQuote);
            SendMessage response4 = new SendMessage();
            response4.setChatId(update.getMessage().getChatId().toString());
            response4.setText(randomQuote);

            try {
                execute(response4);

            } catch (TelegramApiException E) {
                E.printStackTrace();

            }



        }



    }
        private static String getRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotesArray.length);
        return quotesArray[randomIndex];
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