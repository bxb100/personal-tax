package com.pers.personaltax.service;

import com.pers.personaltax.entity.Calculation;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@Service
public class RuleService {

    @Autowired
    private KieBase kieBase;

    /**
     * 个人所得税计算
     */
    public Calculation calculate(Calculation calculation) {
        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(calculation);
        kieSession.fireAllRules();
        kieSession.dispose();
        return calculation;
    }
}
