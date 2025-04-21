package com.creditEvaluation.service;

import com.creditEvaluation.entity.CreditEvaluationEntity;
import com.creditEvaluation.exception.CreditEvaluationException;
import com.creditEvaluation.repository.CreditEvaluationRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditEvaluationService {

    @Autowired
    private CreditEvaluationRepository repository;
    @Transactional
    public CreditEvaluationEntity evaluateCredit(CreditEvaluationEntity entity, Double loanAmount) {

//        System.out.println("Application ID: " + entity.getApplicationId());
//        System.out.println("credit score: " + entity.getCreditScore());
//        System.out.println("evaluation date: " + entity.getEvaluationDate());


        // Calculate risk score based on credit score and loan amount
        Double riskScore = calculateRiskScore(entity.getCreditScore(), loanAmount);
        entity.setRiskScore(riskScore);
        entity = repository.save(entity);
        System.out.println(entity);
        return entity;
    }

    public Double getRiskScore(Integer evaluationId) {
        return repository.findById(evaluationId)
                .map(CreditEvaluationEntity::getRiskScore)
                .orElseThrow(() -> new CreditEvaluationException("Evaluation not found"));
    }

    private Double calculateRiskScore(Integer creditScore, Double loanAmount) {
        Double riskScore;
        if (creditScore < 300) {
            riskScore = loanAmount * 0.0005; // Low credit score
        } else if (creditScore < 600) {
            riskScore = loanAmount * 0.0003; // Average credit score
        } else {
            riskScore = loanAmount * 0.0001; // Excellent credit score
        }
        // Ensure riskScore does not exceed 100.00
        return Math.min(riskScore, 100.00);
    }
}