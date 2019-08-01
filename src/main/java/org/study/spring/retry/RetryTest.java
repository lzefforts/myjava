package org.study.spring.retry;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialRandomBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

public class RetryTest {

    public static void main(String[] args) {
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(new SimpleRetryPolicy(5));
        ExponentialRandomBackOffPolicy backOffPolicy = new ExponentialRandomBackOffPolicy();
        backOffPolicy.setInitialInterval(3000L);
        backOffPolicy.setMaxInterval(5*3600L);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        try {
            retryTemplate.execute(new RetryCallback<Integer,Exception>() {
                @Override
                public Integer doWithRetry(RetryContext retryContext) throws Exception {
                    int retryCount = retryContext.getRetryCount();
                    System.out.println("第"+(retryCount+1)+"次重试！");
                    doRequest();
                    return null;
                }
            });
        } catch (Exception e) {
            System.out.println("exception:"+e.getMessage());
        }

    }

    private static void doRequest() {
        System.out.println("hahah");

        throw new RuntimeException("sss");
    }
}
