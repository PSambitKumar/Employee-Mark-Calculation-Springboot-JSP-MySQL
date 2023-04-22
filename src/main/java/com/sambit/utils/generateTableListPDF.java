package com.sambit.utils;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sambit.model.TableListDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Project : Assessment22
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/04/2023 - 1:13 PM
 */
public class generateTableListPDF {
    public static void generateTableListPDF(List<TableListDTO> tableListDTOList, HttpServletResponse httpServletResponse) {
        System.out.println("Inside generateTableListPDF");
        JSONArray header = new JSONArray();
        header.put("Sl No");
        header.put("Batch Name");
        header.put("Batch Start Date");
        header.put("Technology Name");
        header.put("Employee Name");
        header.put("Employee Phone");
        header.put("Mark");
        header.put("Grade");
        header.put("Status");

        String[] columns = new String[header.length()];
        try {
            Document myDoc=new Document(PageSize.A4);
            String fileName="EmployeeList.pdf";
            PdfWriter writer=PdfWriter.getInstance(myDoc, httpServletResponse.getOutputStream());
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename="+"\""+fileName+"\"");
            myDoc.open();

            Paragraph p = new Paragraph("Employee List", FontFactory.getFont("Arial", 14, Font.BOLD));
            p.setAlignment(Element.ALIGN_CENTER);
            myDoc.add(p);
            myDoc.add(new Paragraph(" "));

            com.itextpdf.text.Font headingfont= FontFactory.getFont(String.valueOf(FontFactory.getFont("Arial")), 12);
            com.itextpdf.text.Font font= FontFactory.getFont(String.valueOf(FontFactory.getFont("Arial")), 10);

            PdfPTable table = new PdfPTable(9);
            table.setWidthPercentage(110);
            table.setSpacingBefore(0);
            table.setSpacingAfter(0);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);

            for (int i = 0; i < header.length(); i++) {
                columns[i] = header.getString(i);
            }

            for (String column : columns) {
                PdfPCell cell = new PdfPCell(new Paragraph(column, headingfont));
                cell.setPaddingLeft(4);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
            }

            int slNO=1;
            for (TableListDTO tableListDTO : tableListDTOList) {
                table.addCell(new Paragraph(String.valueOf(slNO),font));
                table.addCell(new Paragraph(tableListDTO.getBatchName(),font));
                table.addCell(new Paragraph(tableListDTO.getBatchStartDate(),font));
                table.addCell(new Paragraph(tableListDTO.getTechnologyName(),font));
                table.addCell(new Paragraph(tableListDTO.getEmployeeName(),font));
                table.addCell(new Paragraph(tableListDTO.getEmployeePhone(),font));
                table.addCell(new Paragraph(String.valueOf(tableListDTO.getMark()),font));
                table.addCell(new Paragraph(tableListDTO.getGrade(),font));
                table.addCell(new Paragraph(tableListDTO.getStatus(),font));
                slNO++;
            }

            myDoc.add(table);
            myDoc.close();
        } catch (Exception e) {
            System.out.println("Exception in generatePDF() method" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
