package hajiboot;

import org.springframework.web.client.RestTemplate;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.util.StreamUtils;


public class GitHubApiMarkdownRenderer implements MarkdownRenderer{
    private final RestTemplate restTemplate;

    public GitHubApiMarkdownRenderer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public String render(String markdown) {
        return this.restTemplate.postForObject("https://api.github.com/markdown/raw",
                markdown, String.class);
    }

}
