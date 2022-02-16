package uz.ilmuz.startspring.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.ilmuz.startspring.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);
    long deleteByLogin(String login);
}
