package developerIQ.usercommitlogservice.service.external;

import developerIQ.usercommitlogservice.dto.GitHubCommitDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@Component
@Slf4j
public class GitHubExternalClient {

    private final RestTemplate restTemplate;

    @Value("${github.commit-detail-url}")
    private String gitHubCommitDetailsUrl;

    public GitHubExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubCommitDto> getCommitDetails() {
        ResponseEntity<List<GitHubCommitDto>> response = restTemplate.exchange(gitHubCommitDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }


}