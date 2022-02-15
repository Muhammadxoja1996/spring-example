package uz.ilmuz.startspring.dto.user;

import lombok.Data;
import uz.ilmuz.startspring.entity.Item;
import uz.ilmuz.startspring.entity.User;

import javax.persistence.ManyToOne;

/**
 * Author: Muhammadxo'ja
 * Date: 11.02.2022
 * Time: 21:13
 */
@Data
public class ItemDto {
    private Long id;
    private Integer item_amount;
    private String item_name;
    private Integer item_price;
    private Long date;
    public Long user_id;

    public ItemDto() {
    }

    public ItemDto(Item item) {
        this.id = item.getId();
        this.item_amount = item.getItem_amount();
        this.item_name = item.getItemName();
        this.item_price = item.getItem_price();
        this.date = item.getDate();
        this.user_id = item.getUser_id();
    }
}
