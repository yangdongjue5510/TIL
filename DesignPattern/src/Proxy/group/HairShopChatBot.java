package Proxy.group;

import java.util.ArrayList;
import java.util.List;

public class HairShopChatBot implements Chatable{
	private List<String> bookList = new ArrayList<>();

	public HairShopChatBot() {
		bookList.add("양동주");
	}

	@Override
	public void answerBook(String username) {
		if (bookList.contains(username)) {
			System.out.println(username +"님은 예약이 등록되어 있습니다!");
		}
		else {
			System.out.println(username +"님은 예약하지 않으셨습니다.");
		}
	}
}
