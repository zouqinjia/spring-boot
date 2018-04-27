package com.example.demo.condition.impl;

import com.example.demo.condition.MatchCondition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/27 10:42
 **/
public class MatchConditionImpl implements MatchCondition,Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        return false;
    }
}
