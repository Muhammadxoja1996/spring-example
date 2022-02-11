package uz.ilmuz.startspring.service;

import org.springframework.stereotype.Service;
import uz.ilmuz.startspring.dto.user.ItemDto;
import uz.ilmuz.startspring.entity.Item;
import uz.ilmuz.startspring.repository.user.ItemRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    public final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<ItemDto> allItems() {
        return entityToItemDto(itemRepo.findAll());
    }

    private List<ItemDto> entityToItemDto(List<Item> items){
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item: items) {
            itemDtos.add(new ItemDto(item));
        }
        return itemDtos;
    }

    public ItemDto getOne(Long id) {
        ItemDto itemDto = new ItemDto(itemRepo.findById(id).get());
        return itemDto;
    }


    public String addItem(ItemDto itemDto) {
        String result = "ERROR";
        try {
            itemRepo.save(new Item(itemDto));
            result = "SUCCESS";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public String update(ItemDto itemDto){
        String result = "ERROR";
        try {
            Item item = itemRepo.findByItemName(itemDto.getItem_name());
            item.setItem(itemDto);
            itemRepo.save(item);
            result = "SUCCESS";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public String delete(String item_name){
        String result = "ERROR";
        try {
            Item item = itemRepo.findByItemName(item_name);
            itemRepo.delete(item);
            result = "SUCCESS";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
