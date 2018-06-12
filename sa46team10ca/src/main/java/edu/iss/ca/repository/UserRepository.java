package edu.iss.ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.ca.models.User;

public interface UserRepository extends  JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.name=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);

}
