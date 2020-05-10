package wang.clin.pojo.bo;

import org.springframework.context.ApplicationContext;
import wang.clin.enums.OrderType;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wcLin
 * @since 2020/5/9 上午 10:15
 **/
public class OrderServiceBO<T> {

    private Class<T> clazz;
    private ApplicationContext applicationContext;

    private String defaultHandler;
    private final Map<OrderType, String> handlers = new ConcurrentHashMap<>();

    private OrderServiceBO(Class<T> clazz, ApplicationContext applicationContext) {
        this.clazz = clazz;
        this.applicationContext = applicationContext;
    }

    public static <T> OrderServiceBO<T> of(Class<T> clazz, ApplicationContext applicationContext) {
        return new OrderServiceBO<>(clazz, applicationContext);
    }

    public String getHandlerBeanName(OrderType type) {
        return Optional.ofNullable(this.handlers.get(type))
                .orElse(defaultHandler);
    }

    public T getHandler(OrderType type) {
        return applicationContext.getBean(getHandlerBeanName(type), clazz);
    }

    public void setHandler(OrderType type, String handler) {
        this.handlers.put(type, handler);
    }

    public void setHandler(OrderType type, String handler, boolean isDefault) {
        if (isDefault) setDefaultHandler(handler);
        setHandler(type, handler);
    }

    public T getDefaultHandler() {
        return applicationContext.getBean(defaultHandler, clazz);
    }

    public String getDefaultHandlerBeanName() {
        return defaultHandler;
    }

    public void setDefaultHandler(String defaultHandler) {
        this.defaultHandler = defaultHandler;
    }

}
