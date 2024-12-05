package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

	public List<UserEntity> findAllScoreGraterThen(int score) {

		return this.findAll()
				.stream()
				.filter(
						it -> it.getScore() >= score
				)
				.collect(Collectors.toList());

	}
}
