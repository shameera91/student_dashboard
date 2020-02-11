package work.student_dashboard.backend.repository;


import java.util.Date;
import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import work.student_dashboard.backend.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

	@Query(value = "from Attendance a where a.attendanceDate BETWEEN :startDate AND :endDate")
	public List<Attendance> getAllBetweenDates(Date startDate,Date endDate);

}
