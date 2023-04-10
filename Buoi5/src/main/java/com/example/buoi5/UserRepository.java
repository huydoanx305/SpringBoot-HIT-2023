package com.example.buoi5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("select u from User u where u.id = ?1")
  Optional<User> findById(Long id);

  @Query("SELECT u FROM User u WHERE " +
      "u.id = ?1 AND u.username = ?2") //JPQL Query
  User findUser(Long id, String username);

  @Query(value = "SELECT * FROM users " +
      "WHERE id = ?1 AND full_name = ?2",
      nativeQuery = true) //Native Query
  User findUserByFullNameNative(Long id, String username);

}