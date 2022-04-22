package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    @Modifying
    @Query(value = "update User u set u.name = ?1, u.password = ?2 where u.id =?3")
    void edit(String name, String password,int id);

}
