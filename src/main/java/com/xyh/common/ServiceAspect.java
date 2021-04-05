package com.xyh.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author : xiangyida
 * @date : 10:33 下午 2021/3/18
 */
@Aspect
@Component
public class ServiceAspect {

    @Around(value = "execution(* com.xyh.api..*(..))")
    public Object handleParam(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取参数的值
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取method
        Method method = methodSignature.getMethod();
        //通过method获取参数
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            //校验String类型参数
            if (parameter.isAnnotationPresent(NotEmpty.class) && StringUtils.isEmpty(args[i])) {
                return "参数不能为空: " + parameter.toString();
            }
            //校验对象类型参数
            if (parameter.isAnnotationPresent(NotNull.class)) {
                if (args[i] == null) {
                    return "参数不能为空: " + parameter.toString();
                }
                //校验对象内部
                String msg = checkObjectInternField(args[i]);
                if (msg != null) {
                    return msg;
                }
            }
        }
        return joinPoint.proceed();
    }

    /**
     * 校验对象内部参数，注意递归调用
     * @param obj arg
     * @return 校验不通过返回不通过信息，通过则返回null
     * @throws IllegalAccessException filed.get(obj)异常
     */
    public String checkObjectInternField(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            //属性为String类型
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotEmpty.class) && StringUtils.isEmpty(field.get(obj))) {
                return "参数不能为空: " + field.toString();
            }
            //属性为对象类型
            if (field.isAnnotationPresent(NotNull.class)) {
                if (field.get(obj) == null) {
                    return "参数不能为空: " + field.toString();
                }
                return checkObjectInternField(field.get(obj));
            }
        }
        return null;
    }
}
