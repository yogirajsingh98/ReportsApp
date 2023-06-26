package in.ahokit.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.ahokit.entity.CitizenPlan;
import in.ahokit.request.SearchRequest;

public interface ReportService {
	public List<String> getplanNames();
	public List<String> getplanStatus();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean exportExcel(HttpServletResponse response)throws Exception;
	public boolean exportPdf(HttpServletResponse response)throws Exception;
	

}
