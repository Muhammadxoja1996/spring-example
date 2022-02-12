package uz.ilmuz.startspring.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.ilmuz.startspring.entity.Item;

/**
 * Author: Muhammadxo'ja
 * Date: 11.02.2022
 * Time: 21:03
 */
public interface ItemRepo extends JpaRepository<Item, Long> {

    @Query("FROM Item e WHERE e.item_name = :name")
    Item item_name(@Param("name") String name);
}
