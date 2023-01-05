package com.crud.EmployeeMgtBackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponsePage {

    private List<?> myList = new ArrayList<>();
    private Integer pageNo;
    private Integer limit;
    private Integer lastPage;
    private Integer count;

}
