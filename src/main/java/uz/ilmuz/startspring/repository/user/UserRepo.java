package uz.ilmuz.startspring.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ilmuz.startspring.entity.User;

/**
 * Author: Muhammadxo'ja
 * Date: 03.02.2022
 * Time: 22:12
 */
public interface UserRepo extends JpaRepository<User, Long> {
}
