package com.interview.DbRepositories;

import com.interview.Models.Db.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
