package hajiboot;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
//@SpringBootTest
class Hajiboot2MarkdownPrinterApplicationTests {

	@Test
	void contextLoads(CapturedOutput capture) {
		System.setIn(new ByteArrayInputStream(
				"Hello **Spring Boot**".getBytes(StandardCharsets.UTF_8)));
		SpringApplication.run(Hajiboot2MarkdownPrinterApplication.class);
		assertThat(capture.toString())
        .contains("<p>Hello <strong>Spring Boot</strong></p>");
		assertThat(capture.toString()).doesNotContain("RestTemplate");
	}
	
    @Test
    void contextLoadsMarkdownTypeMarked4j(CapturedOutput capture) {
        System.setIn(new ByteArrayInputStream(
                "Hello **Spring Boot**".getBytes(StandardCharsets.UTF_8)));
        SpringApplication.run(Hajiboot2MarkdownPrinterApplication.class,
                "--hajiboot2.markdown.type=marked4j"); 
        assertThat(capture.toString())
                .contains("<p>Hello <strong>Spring Boot</strong></p>");
        assertThat(capture.toString()).doesNotContain("RestTemplate"); 
    }
    
    @Test
    void contextLoadsMarkdownTypeGithub(CapturedOutput capture) {
    	String token = "YOUR-TOKEN";
        System.setIn(new ByteArrayInputStream(
                "Hello **Spring Boot**".getBytes(StandardCharsets.UTF_8)));
        SpringApplication.run(Hajiboot2MarkdownPrinterApplication.class,
                "--hajiboot2.markdown.type=github", "--github.access-token=" + token); // (4)
        assertThat(capture.toString())
                .contains("<p>Hello <strong>Spring Boot</strong></p>");
        assertThat(capture.toString()).contains("RestTemplate"); // (5)
    }



}
