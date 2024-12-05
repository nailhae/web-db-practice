package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


	@Autowired
	private UserRepository userRepository;

	public UserEntity save(UserEntity user) {
		return userRepository.save(user);
	}

	public Optional<UserEntity> findById(@PathVariable Long id) {
		return userRepository.findById(id);
	}

	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	public void delete(@PathVariable Long id) {
		userRepository.delete(id);
	}

	public List<UserEntity> filterScore(int score) {
		return userRepository.findAllScoreGraterThen(score);
	}
}
