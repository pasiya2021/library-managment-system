package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBook {

    private Long id;
    private Long borrowId;
    private List<Long> books;
    private Date date;
    private double fine;

}
