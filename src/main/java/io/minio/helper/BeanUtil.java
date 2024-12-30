package io.minio.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Author: Khonimov Ulugbek
 * Date: 12/30/2024 10:29 AM
 * Info:
 */
@Component
public class BeanUtil {
    private static ApplicationContext context;

    private BeanUtil(ApplicationContext applicationContext) {
        BeanUtil.context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) throws BeansException {
        Assert.state(context != null, "Spring context in the BeanUtil is not been initialized yet!");
        return context.getBean(clazz);
    }

    public static <T> T getBean(Class<T> clazz, String beanName) throws BeansException {
        Assert.state(context != null, "Spring context in the BeanUtil is not been initialized yet!");
        return context.getBean(beanName, clazz);
    }
}
