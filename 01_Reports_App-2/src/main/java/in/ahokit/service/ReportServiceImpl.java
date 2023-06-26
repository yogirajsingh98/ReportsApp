package in.ahokit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ahokit.entity.CitizenPlan;
import in.ahokit.repo.CitizenPlanRepository;
import in.ahokit.request.SearchRequest;
import in.ahokit.util.EmailUtils;
import in.ahokit.util.ExcelGenerator;
import in.ahokit.util.PdfGenerator;
@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private CitizenPlanRepository planRepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator; 
	
	@Autowired
	private EmailUtils emailUtils;
	

	@Override
	public List<String> getplanNames() {
		 return	planRepo.getplanNames();
		 
	}

	@Override
	public List<String> getplanStatus() {
		 return  planRepo.getplanStatus();
		
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		
		CitizenPlan entity=new CitizenPlan();
		if(null !=request.getPlanName()&& !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		
		if(null !=request.getPlanStatus()&& !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		if(null !=request.getGender()&& !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if(null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate=request.getStartDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			LocalDate localDtate=LocalDate.parse(startDate,formatter);
			entity.setStartDate(localDtate);
			
		}
		
		if(null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate=request.getEndDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//convert string to LocalDate
			LocalDate localDtate=LocalDate.parse(endDate,formatter);
			entity.setEndDate(localDtate);
			
		}
		
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response)throws Exception {
		
		File f=new File("plans.xls");
		List<CitizenPlan> plans = planRepo.findAll();
	   excelGenerator.generate(response, plans,f);
	   
	   String subject="My lovely byko";
	   String body="<h2>Test mail body<h2/>";
	   String to="rajeevkumarsingh9892@gmail.com";

	   emailUtils.sendEmail(subject, body, to,f);
	   f.delete();
		return true ;
	}

	@Override 
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		    
		File f=new File("plans.pdf");
		List<CitizenPlan> plans = planRepo.findAll();
		pdfGenerator.generator(response, plans,f);
		
		 String subject="Test mail subject";
		 String body="<h2>Test mail body<h2/>";
		 String to="rajeevkum00004@gmail.com";
		 emailUtils.sendEmail(subject, body, to, f);
		 f.delete();
		
		return true;
	}

	
	

	

}
