package Proxy.group;

public class HairShopChatBotProxy implements Chatable{
	HairShopChatBot hairShopChatBot;

	public void answerRunningTime() {
		System.out.println("평일은 오전 9시부터 오후 5시.\n주말은 쉽니다.");
	}

	@Override
	public void answerBook(String username) {
		if (hairShopChatBot == null) {
			hairShopChatBot = initHairShopChatBot();
		}
		hairShopChatBot.answerBook(username);
	}

	private HairShopChatBot initHairShopChatBot() {
		return new HairShopChatBot();
	}
}
