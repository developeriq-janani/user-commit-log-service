package developerIQ.usercommitlogservice.controller;

import developerIQ.usercommitlogservice.model.GitHubCommit;
import developerIQ.usercommitlogservice.service.GitHubCommitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")

public class CommitController {
    private GitHubCommitService gitHubCommitService;

    @GetMapping("/commits")
    public ResponseEntity<List<GitHubCommit>> getGithubCommit() {
        return ResponseEntity.ok(this.gitHubCommitService.getGithubCommit());
    }

    @GetMapping("/commits/get-all")
    public ResponseEntity<List<GitHubCommit>> getAllCommits() {
        return ResponseEntity.ok(this.gitHubCommitService.getAllCommits());
    }
}