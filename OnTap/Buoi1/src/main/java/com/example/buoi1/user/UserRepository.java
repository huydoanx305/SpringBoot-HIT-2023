package com.example.buoi1.user;

import com.example.buoi1.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u.username, u.full_name AS fullName " +
            "from users u where u.username = ?1", nativeQuery = true)
    List<UserProjection> findUserByUsername(String username);

    @Query(value = "select NEW com.example.buoi1.user.UserDto(u.id, u.email, u.fullName) from User u where u.username = ?1")
    UserDto findUserByUsername1(String username);


}
