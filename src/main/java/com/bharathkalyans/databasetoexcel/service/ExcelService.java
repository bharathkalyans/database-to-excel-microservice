package com.bharathkalyans.databasetoexcel.service;

import com.bharathkalyans.databasetoexcel.helper.Helper;
import com.bharathkalyans.databasetoexcel.model.UserDetails;
import com.bharathkalyans.databasetoexcel.repositiory.UserDetailsRepository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class ExcelService {

    private final UserDetailsRepository userDetailsRepository;

    public ExcelService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public ByteArrayInputStream getData() {
        List<UserDetails> userDetails = userDetailsRepository.findAll();
        ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(userDetails);
        return byteArrayInputStream;
    }


}
