package hajiboot;

import org.springframework.web.client.RestTemplate;



//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
//@Online
@ConditionalOnProperty(name = "hajiboot2.markdown.type", havingValue = "github")
public class GitHubApiMarkdownRenderer implements MarkdownRenderer{
    private final RestTemplate restTemplate;

    //@Autowired
    //public GitHubApiMarkdownRenderer(RestTemplate restTemplate) {
    //public GitHubApiMarkdownRenderer(@Value("${github.access-token}") String accessToken ,
    //		RestTemplateBuilder restTemplateBuilder) {
    public GitHubApiMarkdownRenderer(GitHubProperties props ,
            RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .interceptors((request, body, execution) -> { 
                    request.getHeaders().add("Authorization", "token " + props.getAccessToken());
                    return execution.execute(request, body);
                }).build();

    }


    @Override
    public String render(String markdown) {
        return this.restTemplate.postForObject("https://api.github.com/markdown/raw",
                markdown, String.class);
    }

}
