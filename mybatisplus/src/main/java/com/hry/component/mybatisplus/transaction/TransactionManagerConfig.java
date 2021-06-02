package com.hry.component.mybatisplus.transaction;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置全局事务
 * @author: huangrongyou@yixin.im
 * @date: 2021/6/1 17:16
 */
@Aspect
@Configuration
public class TransactionManagerConfig{
    private final static Logger logger = LoggerFactory.getLogger(TransactionManagerConfig.class);
    private static final int AOP_TIME_OUT = 5;
    /**配置切入点表达式*/
    /**execution(修饰符 返回值 包.类.方法(参数)throws异常)*/
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.hry.component.mybatisplus.service.impl..*.*(..))";

    /**事务管理器*/
    @Autowired
    private TransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice(){
        /**事务管理规则，声明具备事务管理的方法名*/
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();

        /** 只读事务，不做更新操作 */
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        /** 当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务 */
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();

        /** 抛出异常后执行切点回滚，可以自己更换异常类型 */
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        /**PROPAGATION_REQUIRED:事务隔离性为1，若当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值*/
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        /**
         * 单位：秒，此值不建议配置
         * 这个值，不是配置事物方法执行的时间超过 AOP_TIME_OUT ，事物就进行回滚，
         * 而是，详细见这里：https://my.oschina.net/u/2377110/blog/1617723
         */
        // requiredTx.setTimeout(AOP_TIME_OUT);

        Map<String, TransactionAttribute> methodMap = new HashMap<>();

        /** 可以提及事务或回滚事务的方法 */
        methodMap.put("add*", requiredTx);
        methodMap.put("save*", requiredTx);
        methodMap.put("update*", requiredTx);
        methodMap.put("modify*", requiredTx);
        methodMap.put("edit*", requiredTx);
        methodMap.put("insert*", requiredTx);
        methodMap.put("delete*", requiredTx);
        methodMap.put("remove*", requiredTx);
        methodMap.put("repair*", requiredTx);
        methodMap.put("binding*", requiredTx);
        methodMap.put("batch*", requiredTx);
        methodMap.put("clear*", requiredTx);
        methodMap.put("append*", requiredTx);
        methodMap.put("edit*", requiredTx);
        methodMap.put("create*", requiredTx);
        methodMap.put("import*", requiredTx);
        methodMap.put("do*", requiredTx);
        /** 其他方法无事务，只读 */
        methodMap.put("*", readOnlyTx);
        source.setNameMap(methodMap);

        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, source);
        return txAdvice;
    }

    /**
     * 设置切面=切点pointcut+通知TxAdvice
     * @return
     */
    @Bean(name = "txAdviceAdvisor")
    public Advisor txAdviceAdvisor() {
        logger.info("===============================创建txAdviceAdvisor===================================");
        /** 声明切点的面：切面就是通知和切入点的结合。通知和切入点共同定义了关于切面的全部内容——它的功能、在何时和何地完成其功能*/
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        /**声明和设置需要拦截的方法,用切点语言描写*/
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        /**设置切面=切点pointcut+通知TxAdvice*/
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}
