package work.student_dashboard.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement(proxyTargetClass=true)
public class StudentDashboardApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(StudentDashboardApplication.class, args);
	}

	
}
