package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach //각 테스트가 끝난후에
    void afterEach(){
        itemRepository.clearStore(); //저장소 초기화
    }


    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }


    @Test
    void findAll() {
        //given
        Item item = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 20);
        itemRepository.save(item);
        itemRepository.save(item2);

        //when
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void update() {
        //given
        Item item1 = new Item("itemB", 20000, 20);
        Item savedItem = itemRepository.save(item1);
        Long itemId = savedItem.getId();

        //when
        Item updatedParam = new Item("item2", 20000, 30);
        itemRepository.updateItem(itemId, updatedParam);

        //then
        Item findItem = itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(updatedParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updatedParam.getPrice());
    }


}