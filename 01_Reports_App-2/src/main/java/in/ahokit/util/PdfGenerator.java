package in.ahokit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ahokit.entity.CitizenPlan;

@Component
public class PdfGenerator {
	
	
	public void generator(HttpServletResponse response,List<CitizenPlan> plans,File f)throws Exception{
		
		
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document,response.getOutputStream());
		PdfWriter.getInstance(document,new FileOutputStream(f));
		document.open();
		
		// Creating font
				// Setting font style and size
				Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				fontTiltle.setSize(20);
		
		//Paragraph paragraph = new Paragraph("List Of Students", fontTiltle);
		Paragraph p=new Paragraph("Citizen plans info",fontTiltle);
		
		// Aligning the paragraph in document
				p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		PdfPTable table=new PdfPTable(8);
		
		table.setSpacingBefore(5);
		
		table.addCell("id");
		table.addCell("Cirizen Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		table.addCell("Benefit Amount");
		
		//List<CitizenPlan> plans = planRepo.findAll();
		
		for(CitizenPlan plan:plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			
			if(null!=plan.getStartDate()) {
			table.addCell(plan.getStartDate()+"");
			}else {
				table.addCell("N/A");
			}
			if(null!=plan.getEndDate()) {
			table.addCell(plan.getEndDate()+"");
			}else {
				table.addCell("N/A");
			}
			if(null!=plan.getBenifitAmount()) {
			table.addCell(String.valueOf(plan.getBenifitAmount()));
			}else {
				table.addCell("N/A");
			}
		}
		
		document.add(table);
		document.close();
		
		
	}

}
