package com.aint.commerce.datarepository;

import com.aint.commerce.entity.Person;
import com.aint.commerce.entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthenticationRepository extends CrudRepository<UserProfile,Integer> {

    //@Query("SELECT u FROM UserProfile u WHERE u.userName = :userName")
    //public UserProfile getUserByUsername(@Param("userName") String userName);

    UserProfile findByUserName(String email);

}
