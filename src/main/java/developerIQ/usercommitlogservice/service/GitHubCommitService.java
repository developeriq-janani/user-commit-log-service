package developerIQ.usercommitlogservice.service;

import developerIQ.usercommitlogservice.dto.GitHubCommitDetailsDto;
import developerIQ.usercommitlogservice.model.GitHubCommit;

import java.util.List;


public interface GitHubCommitService {
    List<GitHubCommit> getGithubCommit();

    List<GitHubCommit> getAllCommits();

    GitHubCommitDetailsDto getAllCommitsByUserName(String userName);
}