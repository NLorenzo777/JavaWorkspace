package org.example.hibernateautocreatedemo.Repository;

import org.example.hibernateautocreatedemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
