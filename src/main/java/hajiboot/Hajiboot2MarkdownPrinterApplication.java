package hajiboot;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@SpringBootApplication
public class Hajiboot2MarkdownPrinterApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Hajiboot2MarkdownPrinterApplication.class, args);
//		TrackId trackId1 = context.getBean(TrackId.class);
//		System.out.println(trackId1.asLong());
//		TrackId trackId2 = context.getBean(TrackId.class);
//		System.out.println(trackId2.asLong());
//		TrackId trackId3 = context.getBean(TrackId.class);
//		System.out.println(trackId3.asLong());
		
//		TrackId trackId = context.getBean(TrackId.class);
//		System.out.println(trackId.asLong());
//		System.out.println(trackId.asLong());
//		System.out.println(trackId.asLong());

	}

}
