package com.pers.personaltax.controller;

import com.pers.personaltax.entity.Calculation;
import com.pers.personaltax.service.RuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@RestController
@RequestMapping("/rule")
@Slf4j
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @GetMapping("/calculate")
    public Calculation calculate(@RequestParam("wage") double wage) {
        Calculation calculation = new Calculation();
        calculation.setWage(wage);
        calculation = ruleService.calculate(calculation);
        log.info("calculate: {}", calculation);
        return calculation;
    }
}
