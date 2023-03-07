package com.bharathkalyans.databasetoexcel;

import com.bharathkalyans.databasetoexcel.repositiory.UserDetailsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataBaseToExcelApplicationTests {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void fetchData(){
//        userDetailsRepository.findAll().forEach(user -> System.out.println(user.toString()));
    }

}
