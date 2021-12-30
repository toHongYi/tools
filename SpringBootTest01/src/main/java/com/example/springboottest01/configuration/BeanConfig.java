package com.example.springboottest01.configuration;

import com.example.springboottest01.service.UserReader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @version : V1.0
 * @date : 2021/12/28 15:06
 * @Author : LLH
 * @Desc :
 */
@Component
public class BeanConfig implements InitializingBean, ApplicationContextAware {

    private Map<String, UserReader> queryServiceImplMap = new HashMap<>();
    private ApplicationContext applicationContext;

    public UserReader createQueryService(String type){

        //根据传入的参数调用不同的实现类;去进行处理;
        UserReader userReader = queryServiceImplMap.get(type);
        if (userReader == null) {
            //非法判断、参数非法时,调用方法;
            return queryServiceImplMap.get("UserReader1Impl");
        }
        return userReader;
    }

    /**
     * 当Bean的属性被设置完毕后，由BeanFactory调用该方法。
     * 该方法允许bean的实例去执行一些初始化动作，当所有的bean属性完成设置之后执行。
     */
    @Override   //Spring容器在启动后调用该方法;
    public void afterPropertiesSet() throws Exception {
        //获取bean的实现;
        Map<String,UserReader> beanMap = applicationContext.getBeansOfType(UserReader.class);
        //遍历该接口的所有实现,将其放入Map中;
        for (UserReader serviceImpl : beanMap.values()) {
            queryServiceImplMap.put(serviceImpl.getClass().getSimpleName(),serviceImpl);
        }
        System.out.println("查看调用顺序");
        System.out.println("查看调用顺序");
        System.out.println("查看调用顺序");
    }

    /** 即容器启动后，将ApplicationContext 注入到该方法中。 */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}