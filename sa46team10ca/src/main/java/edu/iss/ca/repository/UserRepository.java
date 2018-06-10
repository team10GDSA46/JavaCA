package edu.iss.ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iss.ca.models.User;

public interface UserRepository extends  JpaRepository<User, Integer> {

}
