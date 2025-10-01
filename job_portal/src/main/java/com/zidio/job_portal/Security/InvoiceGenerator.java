package com.zidio.job_portal.Security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.zidio.job_portal.Entity.PaidSubscription;

public class InvoiceGenerator {
  
	public static ByteArrayInputStream generateInvoice(PaidSubscription sub) {
		
		Document doc= new Document();
		
		ByteArrayOutputStream out= new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(doc,out);
			doc.open();
			
			Font titleFont= new Font(Font.FontFamily.TIMES_ROMAN,14,Font.BOLDITALIC);
			Paragraph title= new Paragraph("Subscription Invoice", titleFont);
			title.setAlignment(Element.ALIGN_CENTER);
			doc.add(title);
			doc.add(new Paragraph(" "));
			
			PdfPTable table= new PdfPTable(2);
			
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
			table.addCell(sub.getCurrency().toString());
			
			table.addCell("Payment Status");
			table.addCell(sub.getPaymentStatus().toString());
			
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			table.addCell("Start Date");
			table.addCell(sub.getStartDate().format(fmt));
			
			table.addCell("End Date");
			table.addCell(sub.getEndDate().format(fmt));
			
			doc.add(table);
			doc.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(out.toByteArray());
	}
}
