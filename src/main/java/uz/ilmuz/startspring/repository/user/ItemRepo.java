package uz.ilmuz.startspring.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ilmuz.startspring.entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {
    Item findByItemName(String item_name);
}
