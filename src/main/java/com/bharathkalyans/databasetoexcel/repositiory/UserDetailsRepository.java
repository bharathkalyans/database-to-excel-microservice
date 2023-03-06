package com.bharathkalyans.databasetoexcel.repositiory;

import com.bharathkalyans.databasetoexcel.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
