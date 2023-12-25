package developerIQ.usercommitlogservice.repository;

import developerIQ.usercommitlogservice.model.GitHubCommit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GitHubCommitRepository extends MongoRepository<GitHubCommit, String> {

    List<GitHubCommit> findAllByAuthorName(String authorName);

}