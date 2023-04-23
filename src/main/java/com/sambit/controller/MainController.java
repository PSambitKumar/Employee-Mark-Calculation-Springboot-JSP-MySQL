package com.sambit.controller;

import com.sambit.model.*;
import com.sambit.repository.*;
import com.sambit.utils.GenerateTableList;
import com.sambit.utils.generateTableListPDF;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 10:18 AM
 */
@Controller
public class MainController {

    private final AssementMarkRepository assementMarkRepository;
    private final BatchMasterRepository batchMasterRepository;
    private final EmployeeMasterRepository employeeMasterRepository;
    private final TechnologyMasterRepository technologyMasterRepository;

    public MainController(AssementMarkRepository assementMarkRepository, BatchMasterRepository batchMasterRepository, EmployeeMasterRepository employeeMasterRepository, TechnologyMasterRepository technologyMasterRepository) {
        this.assementMarkRepository = assementMarkRepository;
        this.batchMasterRepository = batchMasterRepository;
        this.employeeMasterRepository = employeeMasterRepository;
        this.technologyMasterRepository = technologyMasterRepository;
    }

    @GetMapping(value = "/getBatch")
    public String getBatch(Model model) {
        System.out.println("Inside getBatch");
        List<BatchMaster> batchMasterList = batchMasterRepository.findAll();
        List<TechnologyMaster> technologyMasterList = technologyMasterRepository.findAll();
        List<TableListDTO> tableListDTOList = GenerateTableList.generateTableList(batchMasterRepository.getTableList());
        model.addAttribute("batchMasterList", batchMasterList);
        model.addAttribute("technologyMasterList", technologyMasterList);
        model.addAttribute("tableListDTOList", tableListDTOList);
        return "assessment";
    }

    @ResponseBody
    @GetMapping("/getEmployeeDetails")
    public ResponseEntity<?> getEmployeeDetails(@RequestParam(value = "batchId") Integer batchId,
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

    @PostMapping("/searchFilter")
    public String searchFilter(@RequestParam(value = "searchBatchId") Integer batchId,
                               Model model) {
        System.out.println("Inside searchFilter");
        System.out.println("Batch Id: " + batchId);
        List<BatchMaster> batchMasterList = batchMasterRepository.findAll();
        List<TechnologyMaster> technologyMasterList = technologyMasterRepository.findAll();
        model.addAttribute("batchMasterList", batchMasterList);
        model.addAttribute("technologyMasterList", technologyMasterList);
        List<TableListDTO> tableListDTOList = GenerateTableList.generateTableList(batchMasterRepository.getTableListByBatchId(batchId));
        model.addAttribute("tableListDTOList", tableListDTOList);
        return "assessment";
    }

    @GetMapping("/generatePDF")
    public void generatePDF(@RequestParam(value = "searchBatchId1") Integer batchId,
                            HttpServletResponse httpServletResponse) {
        System.out.println("Inside generatePDF");
        System.out.println("Batch Id: " + batchId);
        if (batchId == 0){
            List<TableListDTO> tableListDTOList = GenerateTableList.generateTableList(batchMasterRepository.getTableList());
            generateTableListPDF.generateTableListPDF(tableListDTOList, httpServletResponse);
        } else {
            List<TableListDTO> tableListDTOList = GenerateTableList.generateTableList(batchMasterRepository.getTableListByBatchId(batchId));
            generateTableListPDF.generateTableListPDF(tableListDTOList, httpServletResponse);
        }
    }
}
