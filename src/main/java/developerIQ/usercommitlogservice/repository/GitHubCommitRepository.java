package developerIQ.usercommitlogservice.repository;

import developerIQ.usercommitlogservice.model.GitHubCommit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GitHubCommitRepository extends MongoRepository<GitHubCommit, String> {

}