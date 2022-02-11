package uz.ilmuz.startspring.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.ilmuz.startspring.entity.Item;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Integer item_amount;
    private String item_name;
    private Integer item_price;

    public ItemDto(Item item) {
        this.item_amount = item.getItem_amount();
        this.item_name = item.getItem_name();
        this.item_price = item.getItem_price();
    }
}