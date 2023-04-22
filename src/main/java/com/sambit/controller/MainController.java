package com.sambit.controller;

import com.sambit.model.*;
import com.sambit.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : EmpSalary
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:18 AM
 */
@Controller
public class MainController {

    @Autowired
    private AssementMarkRepository assementMarkRepository;

    @Autowired
    private BatchMasterRepository batchMasterRepository;

    @Autowired
    private EmployeeMasterRepository employeeMasterRepository;

    @Autowired
    private TechnologyMasterRepository technologyMasterRepository;

    public static String calculateGrade(int mark) {
        if (mark < 60) {
            return "F";
        } else if (mark >= 60 && mark <= 79) {
            return "A";
        } else if (mark >= 80 && mark <= 89) {
            return "E";
        } else if (mark >= 90 && mark <= 100) {
            return "O";
        } else {
            return "Invalid Mark";
        }
    }

    public List<TableListDTO>generateTableList(List<Object[]> tableList){
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
            tableListDTO.setGrade(calculateGrade(Integer.parseInt(table[5].toString())));
            tableListDTO.setStatus(Integer.parseInt(table[5].toString()) >= 70 ? "Eligible" : "Not Eligible");
            tableListDTOList.add(tableListDTO);
        });
        return tableListDTOList;
    }

    @GetMapping(value = "/getBatch")
    public String getBatch(Model model) {
        System.out.println("Inside getBatch");
        List<BatchMaster> batchMasterList = batchMasterRepository.findAll();
        List<TechnologyMaster> technologyMasterList = technologyMasterRepository.findAll();
        List<TableListDTO> tableListDTOList = generateTableList(batchMasterRepository.getTableList());
        model.addAttribute("batchMasterList", batchMasterList);
        model.addAttribute("technologyMasterList", technologyMasterList);
        model.addAttribute("tableListDTOList", tableListDTOList);
        return "assessment";
    }

    @ResponseBody
    @GetMapping("/getEmployeeDetails")
    public ResponseEntity getEmployeeDetails(@RequestParam(value = "batchId") Integer batchId,
                                             @RequestParam(value = "technologyId") Integer technologyId) {
        System.out.println("Inside getEmployeeDetails");
        return ResponseEntity.ok(employeeMasterRepository.getEmployeeMasterByBatchIdAndTechnologyId(batchId, technologyId));
    }

    @PostMapping("/saveEmployeeMark")
    public String saveEmployeeMark(@RequestParam(value = "batchId") Integer batchId,
                                       @RequestParam(value = "technologyId") String technologyId,
                                       @RequestParam(value = "employeeId") Integer employeeId,
                                       @RequestParam(value = "mark") Integer mark) {
        System.out.println("Inside saveEmployeeMark");
        System.out.println("Batch Id: " + batchId + ", Technology Id: " + technologyId + ", Employee Id: " + employeeId + ", Mark: " + mark);

        AssementMark assementMark = new AssementMark();
        assementMark.setEmpid(employeeId);
        assementMark.setMark(mark);
        assementMarkRepository.save(assementMark);


        return "redirect:/getBatch";
    }
}
