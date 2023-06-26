package in.ahokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ahokit.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {

	@Query("select distinct(planName)from CitizenPlan")
	public List<String> getplanNames();

	@Query("select distinct (planStatus)from CitizenPlan")
	public List<String> getplanStatus();

}
