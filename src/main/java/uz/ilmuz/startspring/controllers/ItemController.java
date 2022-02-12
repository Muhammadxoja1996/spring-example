package uz.ilmuz.startspring.controllers;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> test
import org.springframework.web.bind.annotation.*;
import uz.ilmuz.startspring.dto.user.ItemDto;
import uz.ilmuz.startspring.service.ItemService;

import java.util.List;

<<<<<<< HEAD
@RestController
@RequestMapping("/api/v1/item")
=======
/**
 * Author: Muhammadxo'ja
 * Date: 11.02.2022
 * Time: 21:07
 */
@RestController
@RequestMapping("/api/v1/items")
>>>>>>> test
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/get-all")
<<<<<<< HEAD
    public List<ItemDto> allUsers() {
        return itemService.allItems();
    }

    @GetMapping("/get/{id}")
    public ItemDto getOne(@PathVariable Long id) {
        return itemService.getOne(id);
    }


    @PostMapping("/add")
    public String addItem(@RequestBody ItemDto itemDto) {
=======
    public List<ItemDto> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/get/{id}")
    public ItemDto getOne(@PathVariable(name = "id") Long id) {
        return itemService.getOne(id);
    }

    @PostMapping("/add")
    public String addItem(@RequestBody ItemDto itemDto){
>>>>>>> test
        return itemService.addItem(itemDto);
    }

    @PostMapping("/update")
<<<<<<< HEAD
    public String updateItem(@RequestBody ItemDto itemDto) {
        return itemService.update(itemDto);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String item_name) {
        return itemService.delete(item_name);
    }
=======
    public String update(@RequestBody ItemDto itemDto){
        return itemService.update(itemDto);
    }
>>>>>>> test
}
