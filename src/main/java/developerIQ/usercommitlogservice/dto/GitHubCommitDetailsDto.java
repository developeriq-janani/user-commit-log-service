package developerIQ.usercommitlogservice.dto;

import developerIQ.usercommitlogservice.model.GitHubCommit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GitHubCommitDetailsDto {

    private int commitCount;

    private List<GitHubCommit> userCommits;
}
