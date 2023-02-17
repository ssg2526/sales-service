package com.ssg.sales.model.context.model;

import java.util.HashMap;
import java.util.Map;

public class DBContext {
    private static ThreadLocal<ContextProps> currentDBContext = new InheritableThreadLocal<>();

    public static ContextProps getCurrentDBContext(){
        return currentDBContext.get();
    }

    public static void setCurrentDBContext(ContextProps contextProps){
//        contextMap.put(property, value);
        currentDBContext.set(contextProps);
    }

    public static void clear(){
        currentDBContext.set(null);
    }
}
