package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //ConcurrentHashMap 사용 권장
    private static long sequence = 0L; //atomicLong 사용 권장

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void updateItem(Long itemId, Item updateParam){
        //이렇게 업데이트 할 아이템 정보를 아이템 객체로 가져오는게 아니라 업데이트 전용 dto를 만들어서 사용하는 것 권장
        //id는 왜 안쓰지 라고 생각할 수 있기 때문.
        Item item = findById(itemId);
        item.setItemName(updateParam.getItemName());
        item.setPrice(updateParam.getPrice());
        item.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}
