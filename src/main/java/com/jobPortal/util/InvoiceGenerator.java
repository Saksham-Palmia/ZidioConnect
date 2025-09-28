package com.jobPortal.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jobPortal.entity.Application;
import com.jobPortal.entity.Job;
import com.jobPortal.entity.PaidSubscription;
import com.jobPortal.entity.Student;

public class InvoiceGenerator {
    
    public static ByteArrayInputStream generateApplicationInvoice(Application application) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            
            // Add title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Job Application Receipt", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);
            
            // Add application details
            Student student = application.getStudent();
            Job job = application.getJob();
            
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            
            // Table headers
            PdfPCell cell1 = new PdfPCell(new Phrase("Field"));
            cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell cell2 = new PdfPCell(new Phrase("Value"));
            cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell1);
            table.addCell(cell2);
            
            // Application details
            addTableRow(table, "Application ID", application.getId().toString());
            addTableRow(table, "Application Date", 
                       application.getAppliedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            addTableRow(table, "Status", application.getStatus().name());
            
            // Student details
            addTableRow(table, "Student Name", student.getFirstName() + " " + student.getLastName());
            addTableRow(table, "Student Email", student.getEmail());
            
            // Job details
            addTableRow(table, "Job Title", job.getTitle());
            addTableRow(table, "Company", job.getRecruiter().getCompanyName());
            addTableRow(table, "Location", job.getLocation());
            addTableRow(table, "Salary", job.getSalary() != null ? "$" + job.getSalary() : "Not specified");
            
            document.add(table);
            
            // Add cover letter if exists
            if (application.getCoverLetter() != null && !application.getCoverLetter().isEmpty()) {
                Paragraph coverLetterTitle = new Paragraph("Cover Letter:", 
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                coverLetterTitle.setSpacingBefore(15);
                document.add(coverLetterTitle);
                
                Paragraph coverLetter = new Paragraph(application.getCoverLetter());
                coverLetter.setSpacingAfter(15);
                document.add(coverLetter);
            }
            
            document.close();
        } catch (DocumentException e) {
            throw new RuntimeException("Error generating subscription invoice", e);
        }
        
        return new ByteArrayInputStream(out.toByteArray());
    }

    public static ByteArrayInputStream generateInvoice(PaidSubscription sub) {
        Document doc = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
            PdfWriter.getInstance(doc, out);
            doc.open();
            
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Subscription Invoice", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);
            doc.add(new Paragraph(" "));
            
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(80);
            table.setSpacingBefore(20);
            
            table.addCell("Subscription ID");
            table.addCell(sub.getId().toString());
            
            table.addCell("Recruiter ID");
            table.addCell(sub.getRecruiterId().toString());
            
            table.addCell("Employee ID");
            table.addCell(sub.getEmployeeId().toString());
            
            table.addCell("Plan ID");
            table.addCell(sub.getPlanId().toString());
            
            table.addCell("Amount");
            table.addCell(sub.getAmount().toString());
            
            table.addCell("Currency");
            table.addCell(sub.getCurrency());
            
            table.addCell("Payment Status");
            table.addCell(sub.getPaymentStatus().toString());
            
            table.addCell("Start Date");
            table.addCell(sub.getStartDate().format(DateTimeFormatter.ISO_DATE));
            
            table.addCell("End Date");
            table.addCell(sub.getEndDate().format(DateTimeFormatter.ISO_DATE));
            
            doc.add(table);
            doc.close();
        } catch (DocumentException | NullPointerException e) {
            throw new RuntimeException("Error generating subscription invoice", e);
        }
        
        return new ByteArrayInputStream(out.toByteArray());
    }
    private static void addTableRow(PdfPTable table, String field, String value) {
        PdfPCell cell1 = new PdfPCell(new Phrase(field));
        PdfPCell cell2 = new PdfPCell(new Phrase(value));
        table.addCell(cell1);
        table.addCell(cell2);
    }
}