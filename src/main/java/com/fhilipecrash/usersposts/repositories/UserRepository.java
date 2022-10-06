package com.fhilipecrash.usersposts.repositories;

import com.fhilipecrash.usersposts.interfaces.UserWithoutPosts;
import com.fhilipecrash.usersposts.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

    @Query("select u from User u where u.id = ?1")
    UserWithoutPosts findUserWithoutPosts(int id);
}
