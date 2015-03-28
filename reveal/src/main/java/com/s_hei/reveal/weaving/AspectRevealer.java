package com.s_hei.reveal.weaving;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;

import java.util.concurrent.TimeUnit;

@Aspect
public class AspectRevealer {

    private static final String TAG = AspectRevealer.class.getSimpleName();

    @Pointcut("execution(@com.s_hei.reveal.Reveal * *(..))")
    public void method() { }

    @Pointcut("execution(@com.s_hei.reveal.Reveal *.new(..))")
    public void constructor() { }

    @Around("method() || constructor()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.nanoTime();
        final Object result = joinPoint.proceed();
        final long stop = System.nanoTime();
        Log.v(TAG, string(joinPoint, start, stop));
        return result;
    }

    private static String string(ProceedingJoinPoint joinPoint, long start, long stop) {
        CodeSignature signature = (CodeSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        return new StringBuilder(className)
                .append("#").append(methodName).append(" :: ")
                .append("[").append(TimeUnit.NANOSECONDS.toMillis(stop - start)).append(" ms]").toString();
    }
}
