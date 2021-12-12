package Proxy.group;

public class Main {
	public static void main(String[] args) {
		Chatable chatbot = new HairShopChatBotProxy();
		((HairShopChatBotProxy)chatbot).answerRunningTime();
		chatbot.answerBook("양동주");
		chatbot.answerBook("이민규");
	}
}
