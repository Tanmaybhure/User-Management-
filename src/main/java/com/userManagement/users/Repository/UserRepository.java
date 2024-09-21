package com.userManagement.users.Repository;

import com.userManagement.users.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
