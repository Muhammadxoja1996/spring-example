package uz.ilmuz.startspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: Muhammadxo'ja
 * Date: 07.02.2022
 * Time: 22:19
 */
@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "items_auth_sec")
    @SequenceGenerator(name = "items_auth_sec", sequenceName = "items_auth_sec", allocationSize = 1)
    private Long id;
    private Integer item_amount;
    private String item_name;
    private Integer item_price;
    private Long date;

    @ManyToOne
    public User user_id;
}
