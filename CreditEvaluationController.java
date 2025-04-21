package com.creditEvaluation.controller;

import com.creditEvaluation.entity.CreditEvaluationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.creditEvaluation.service.CreditEvaluationService;
import com.creditEvaluation.config.DateFormatter;


@Controller
@RequestMapping("/credit-evaluation")
public class CreditEvaluationController {

    @Autowired
    private CreditEvaluationService service;

    @Autowired
    private DateFormatter dateFormatter;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(dateFormatter);
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("creditEvaluation", new CreditEvaluationEntity());
        return "index"; // Ensure this matches the name of your HTML file without the suffix
    }

    @PostMapping("/evaluate")
    public String evaluateCredit(@ModelAttribute CreditEvaluationEntity entity, @RequestParam Double loanAmount, Model model) {
        CreditEvaluationEntity result = service.evaluateCredit(entity, loanAmount);
        model.addAttribute("result", result);
        return "result"; // Ensure you have a result.html template
    }

    @GetMapping("/risk-score/{id}")
    @ResponseBody
    public Double getRiskScore(@PathVariable Integer id) {
        return service.getRiskScore(id);
    }

    @GetMapping("/back")
    public String goBack() {
        return "redirect:/credit-evaluation/"; // Redirects to the showForm method
    }
}