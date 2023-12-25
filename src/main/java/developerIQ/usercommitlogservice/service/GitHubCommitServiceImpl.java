package developerIQ.usercommitlogservice.service;

import developerIQ.usercommitlogservice.dto.GitHubCommitDetailsDto;
import developerIQ.usercommitlogservice.dto.GitHubCommitDto;
import developerIQ.usercommitlogservice.model.GitHubCommit;
import developerIQ.usercommitlogservice.repository.GitHubCommitRepository;
import developerIQ.usercommitlogservice.service.external.GitHubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;




@Service
@AllArgsConstructor
public class GitHubCommitServiceImpl implements GitHubCommitService {

    private final GitHubExternalClient githubExternalClient;
    private final GitHubCommitRepository gitHubUserRepository;

    @Override
    public List<GitHubCommit> getGithubCommit() {
        List<GitHubCommit> gitHubCommits = new ArrayList<>();

        List<GitHubCommitDto> githubUserDtoList = this.githubExternalClient.getCommitDetails();
        githubUserDtoList.forEach(githubCommitDto -> {
            GitHubCommit gitHubCommit = this.generateGitHubCommitObject(githubCommitDto);
            gitHubCommits.add(gitHubCommit);
        });

        this.gitHubUserRepository.saveAll(gitHubCommits);

        return gitHubCommits;


    }

    @Override
    public List<GitHubCommit> getAllCommits() {
        return this.gitHubUserRepository.findAll();
    }

    @Override
    public GitHubCommitDetailsDto getAllCommitsByAuthorName(String authorName){
        List<GitHubCommit> gitHubCommits = this.gitHubUserRepository.findAllByAuthorName(authorName.trim());
        return GitHubCommitDetailsDto.builder().commitCount(gitHubCommits.size()).userCommits(gitHubCommits).build();

    }

    private GitHubCommit generateGitHubCommitObject(GitHubCommitDto gitHubCommitDto) {
        return GitHubCommit.builder()
                .authorName(gitHubCommitDto.getCommitDto().getAuthorDto().getName())
                .commitMessage(gitHubCommitDto.getCommitDto().getMessage())
                .email(gitHubCommitDto.getCommitDto().getAuthorDto().getEmail())
                .date(gitHubCommitDto.getCommitDto().getAuthorDto().getDate())
                .build();
    }

}
