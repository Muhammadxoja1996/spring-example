package uz.ilmuz.startspring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ilmuz.startspring.dto.user.ItemDto;
import uz.ilmuz.startspring.entity.Item;
import uz.ilmuz.startspring.repository.user.ItemRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Muhammadxo'ja
 * Date: 11.02.2022
 * Time: 21:07
 */
@Service
public class ItemService {

    private final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<ItemDto> getAll() {
        List<Item> items = itemRepo.findAll();
        return entityToDto(items);
    }

    private List<ItemDto> entityToDto(List<Item> items) {
        List<ItemDto> itemRepos = new ArrayList<>();
        for (Item item : items) {
            itemRepos.add(new ItemDto(item));
        }
        return itemRepos;
    }

    public ItemDto getOne(Long id) {
        return new ItemDto(itemRepo.findById(id).get());
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

    @Transactional
    public String update(ItemDto itemDto) {
        String result = "ERROR";
        try {
            Item item = itemRepo.item_name(itemDto.getItem_name());
            item.saveItemFields(itemDto);
            itemRepo.save(item);
            result = "SUCCESS";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    @Transactional
    public String delete(String item_name){
        String result = "ERROR";
        try {
            itemRepo.deleteByItemName(item_name);
            result = "SUCCESS";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
