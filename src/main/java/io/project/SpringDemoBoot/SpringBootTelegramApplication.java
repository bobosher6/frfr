package io.project.SpringDemoBoot;

import io.project.SpringDemoBoot.bot.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

//import java.beans.AppletInitializer;

@SpringBootApplication
public class SpringBootTelegramApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTelegramApplication.class, args);
		try{
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(new Bot());
		}catch(TelegramApiException e){
			System.out.println(e);
		}
	}

}
