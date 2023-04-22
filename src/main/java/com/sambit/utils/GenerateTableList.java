package com.sambit.utils;

import com.sambit.model.TableListDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 12:45 PM
 */
public class GenerateTableList {
    public static List<TableListDTO> generateTableList(List<Object[]> tableList){
        System.out.println("Inside generateTableList");
        List<TableListDTO> tableListDTOList = new ArrayList<>();
        tableList.forEach(table -> {
            TableListDTO tableListDTO = new TableListDTO();
            tableListDTO.setBatchName(table[0].toString());
            tableListDTO.setBatchStartDate(table[1].toString());
            tableListDTO.setTechnologyName(table[2].toString());
            tableListDTO.setEmployeeName(table[3].toString());
            tableListDTO.setEmployeePhone(table[4].toString());
            tableListDTO.setMark(Integer.parseInt(table[5].toString()));
            tableListDTO.setGrade(CalculateGrade.calculateGrade(Integer.parseInt(table[5].toString())));
            tableListDTO.setStatus(Integer.parseInt(table[5].toString()) >= 70 ? "Eligible" : "Not Eligible");
            tableListDTOList.add(tableListDTO);
        });
        return tableListDTOList;
    }
}
