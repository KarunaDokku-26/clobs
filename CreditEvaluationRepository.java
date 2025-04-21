package com.creditEvaluation.repository;

import com.creditEvaluation.entity.CreditEvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditEvaluationRepository extends JpaRepository<CreditEvaluationEntity, Integer> {
}