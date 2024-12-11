package com.example.demo.user.db;

import com.example.demo.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	List<UserEntity> findAllByScoreGreaterThanEqual(int score);

	List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

	@Query(
			"SELECT u FROM user u WHERE u.score >= ?1 AND u.score <= ?2"
	)
	List<UserEntity> score(int min, int max);
}
