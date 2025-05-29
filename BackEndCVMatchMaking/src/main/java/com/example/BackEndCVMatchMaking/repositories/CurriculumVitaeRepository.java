package com.example.BackEndCVMatchMaking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BackEndCVMatchMaking.models.CurriculumVitae;

public interface CurriculumVitaeRepository extends JpaRepository <CurriculumVitae, Integer> {

}
