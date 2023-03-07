package com.bharathkalyans.databasetoexcel.helper;

import com.bharathkalyans.databasetoexcel.model.UserDetails;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class Helper {

    //user_id |email|   first_name   |   gender    |   last_name
    private static final String[] HEADERS = {"USER_ID", "EMAIL", "FIRST_NAME", "GENDER", "LAST_NAME"};

    private static final String SHEET_NAME = "user_details";

    public static ByteArrayInputStream dataToExcel(List<UserDetails> userDetailsList) {

        //1.WorkBook

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (Workbook workBook = new XSSFWorkbook(); out) {

            //2.Sheet
            Sheet sheet = workBook.createSheet(SHEET_NAME);

            //3.Access first Row
            Row row = sheet.createRow(0);

            //4.Build the Headers through Loop.
            for (int i = 0; i < HEADERS.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(HEADERS[i]);
            }

            //5.Traverse through the list and add the data!.
            int rowIndex = 1;
            for (UserDetails userDetails : userDetailsList) {
                Row dataRow = sheet.createRow(rowIndex);
                dataRow.createCell(0).setCellValue(userDetails.getUserId());
                dataRow.createCell(1).setCellValue(userDetails.getEmail());
                dataRow.createCell(2).setCellValue(userDetails.getFirstName());
                dataRow.createCell(3).setCellValue(userDetails.getGender());
                dataRow.createCell(4).setCellValue(userDetails.getLastName());
                rowIndex++;
            }

            workBook.write(out);

            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to generate Excel File!");
            return null;
        }


    }
}








