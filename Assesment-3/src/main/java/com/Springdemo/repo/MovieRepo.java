package com.Springdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springdemo.model.MovieModel;

@Repository
public interface MovieRepo extends JpaRepository<MovieModel, Long>{

}
