package com.creditEvaluation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CreditEvaluation")
public class CreditEvaluationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer evaluationId;

    @NotNull
    private Integer applicationId;

    @DecimalMin("0.00")
    @DecimalMax("100.00")
    private Double riskScore;

    @Min(0)
    @Max(800)
    private Integer creditScore;

    @Past
    private LocalDate evaluationDate;


}