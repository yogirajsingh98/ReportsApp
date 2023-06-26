package in.ahokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ahokit.entity.CitizenPlan;
import in.ahokit.repo.CitizenPlanRepository;

@Component
public class DataLoder implements ApplicationRunner {
	
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		//Cash plan data
		CitizenPlan c1=new CitizenPlan();
		
		c1.setCitizenName("rajeev");
		c1.setGender("male");
		c1.setPlanName("cash");
		c1.setPlanStatus("approved");
		c1.setStartDate(LocalDate.now());
		c1.setEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmount(5000.0);
		
		CitizenPlan c2=new CitizenPlan();
		
		c2.setCitizenName("yogita nagpurkar");		
		c2.setGender("female");
		c2.setPlanName("cash");
		c2.setPlanStatus("denied");
		c2.setDenialReason("rent income");
		
		CitizenPlan c3=new CitizenPlan();
		
		c3.setCitizenName("manisha");		
		c3.setGender("female");
		c3.setPlanName("cash");
		c3.setPlanStatus("terminated");
		c3.setStartDate(LocalDate.now().minusMonths(4));
		c3.setEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitAmount(3000.0);
		c3.setEndDate(LocalDate.now());
		c3.setTerminationReason("employed");
		
		
		//food plan data
		CitizenPlan c4=new CitizenPlan();
				
		c4.setCitizenName("zonny");
		c4.setGender("male");
		c4.setPlanName("food");
		c4.setPlanStatus("approved");
		c4.setStartDate(LocalDate.now());
		c4.setEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitAmount(5000.0);
				
		CitizenPlan c5=new CitizenPlan();
				
		c5.setCitizenName("nikita");		
		c5.setGender("female");
		c5.setPlanName("food");
		c5.setPlanStatus("denied");
		c5.setDenialReason("property income");
				
		CitizenPlan c6=new CitizenPlan();
				
		c6.setCitizenName("raunak");		
		c6.setGender("male");
		c6.setPlanName("food");
		c6.setPlanStatus("terminated");
		c6.setStartDate(LocalDate.now().minusMonths(4));
		c6.setEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifitAmount(3000.0);
		c6.setEndDate(LocalDate.now());
		c6.setTerminationReason("employed");
				
				//medical plan data
		CitizenPlan c7=new CitizenPlan();
		
		c7.setCitizenName("vikash");
		c7.setGender("male");
		c7.setPlanName("medical");
		c7.setPlanStatus("approved");
		c7.setStartDate(LocalDate.now());
		c7.setEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmount(5000.0);
				
		CitizenPlan c8=new CitizenPlan();
				
		c8.setCitizenName("munna");		
		c8.setGender("male");
		c8.setPlanName("medical");
		c8.setPlanStatus("denied");
		c8.setDenialReason("property income");
				
		CitizenPlan c9=new CitizenPlan();
				
		c9.setCitizenName("sushant");		
		c9.setGender("female");
		c9.setPlanName("medical");
		c9.setPlanStatus("terminated");
		c9.setStartDate(LocalDate.now().minusMonths(4));
		c9.setEndDate(LocalDate.now().plusMonths(6));
		c9.setBenifitAmount(3000.0);
		c9.setEndDate(LocalDate.now());
		c9.setTerminationReason("goverment job");
	
		//Employment plan data
       CitizenPlan c10=new CitizenPlan();
		
       c10.setCitizenName("kundan");
       c10.setGender("male");
       c10.setPlanName("employment");
       c10.setPlanStatus("approved");
       c10.setStartDate(LocalDate.now());
       c10.setEndDate(LocalDate.now().plusMonths(6));
       c10.setBenifitAmount(5000.0);
				
		CitizenPlan c11=new CitizenPlan();
				
		c11.setCitizenName("munny");		
		c11.setGender("female");
		c11.setPlanName("employment");
		c11.setPlanStatus("denied");
		c11.setDenialReason("property income");
				
		CitizenPlan c12=new CitizenPlan();
				
		c12.setCitizenName("mahi");		
		c12.setGender("male");
		c12.setPlanName("employment");
		c12.setPlanStatus("terminated");
		c12.setStartDate(LocalDate.now().minusMonths(4));
		c12.setEndDate(LocalDate.now().plusMonths(6));
		c12.setBenifitAmount(3000.0);
		c12.setEndDate(LocalDate.now());
		c12.setTerminationReason("goverment job");
		
		List<CitizenPlan> list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		
		repo.saveAll(list);
	
	}

}
