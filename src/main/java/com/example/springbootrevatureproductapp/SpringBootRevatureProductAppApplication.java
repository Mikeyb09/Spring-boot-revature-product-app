package com.example.springbootrevatureproductapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRevatureProductAppApplication {

//	@Autowired
//	Product product;
//	
//	public void doWork() {
//		product.displayProductName();
//	}
	
	public static void main(String[] args) {
		
//		**************************************************************************************************
//		This is used to configure Build profiles so you can work in Development mode or whatever profile you have built
//		**************************************************************************************************
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the environment (PROD-DEV) : ");
//		String choice = scan.next();
//		
//		
//		SpringApplication application = new SpringApplication(SpringBootRevatureProductAppApplication.class);
//		application.setAdditionalProfiles(choice);
//		application.run(args);
		
		
		
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootRevatureProductAppApplication.class, args);
		
		
		
		
		
//		**************************************************************************************************
//		This shows a list of all beans being used in your project
//		**************************************************************************************************
		
//		String allBeans[] = context.getBeanDefinitionNames();
//		
//		Arrays.sort(allBeans);
//		
//		for(String bean : allBeans) {
//			System.out.println(bean);
//		}
		
//		SpringBootRevatureProductAppApplication app = new SpringBootRevatureProductAppApplication();
//		app.doWork();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
