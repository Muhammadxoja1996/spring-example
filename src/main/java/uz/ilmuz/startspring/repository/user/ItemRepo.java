package uz.ilmuz.startspring.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.ilmuz.startspring.entity.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

    @Query("FROM Item e WHERE e.itemName = :name")
    Item item_name(@Param("name") String name);

    long deleteByItemName(String itemName);
}
