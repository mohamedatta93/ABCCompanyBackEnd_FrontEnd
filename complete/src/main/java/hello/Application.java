package hello;

import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
    @Bean
	public CommandLineRunner demo(EmployeeRepository erepo,DepartmentRepository drepo) {
		return (args) -> {
			
			String []names = {"محمد","عمرو","أحمد","أبراهيم","سعيد","بسام","عادل","تامر","حيدر","طاهر"};	
			for(int i = 0;i<30;i++)
			drepo.save(new Department("Department"+i));
			Random r = new Random();
			
			for(int i = 0;i<10;i++)
			erepo.save(new Employee(names[r.nextInt(names.length-1)].concat(" ").concat(names[r.nextInt(names.length-1)]).concat(" ").concat(names[r.nextInt(names.length-1)])
					,r.nextDouble()*1000+5000.0 ,r.nextInt(30)));
			
			
	};
	}
}
