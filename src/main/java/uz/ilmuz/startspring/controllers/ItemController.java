package uz.ilmuz.startspring.controllers;

import org.springframework.web.bind.annotation.*;
import uz.ilmuz.startspring.dto.user.ItemDto;
import uz.ilmuz.startspring.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/get-all")
    public List<ItemDto> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/get/{id}")
    public ItemDto getOne(@PathVariable(name = "id") Long id) {
        return itemService.getOne(id);
    }


    @PostMapping("/add")
    public String addItem(@RequestBody ItemDto itemDto) {
        return itemService.addItem(itemDto);
    }

    @PostMapping("/update")
    public String update(@RequestBody ItemDto itemDto) {
        return itemService.update(itemDto);
    }

//    @DeleteMapping("/delete")
//    public String delete(@RequestParam String item_name) {
//        return itemService.delete(item_name);
//    }
}
