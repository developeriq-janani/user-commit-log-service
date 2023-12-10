package developerIQ.usercommitlogservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "github_commits")

public class GitHubCommit {

    @Id
    private String id;

    private String login;

    private int gitHubId;

    private String nodeId;

    private String reposUrl;

    private String type;

    private boolean siteAdmin;

    private int contributions;
}