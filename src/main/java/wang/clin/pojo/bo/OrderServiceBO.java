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

    private String defaultHandler;
    private final Class<T> clazz;
    private final Map<OrderType, String> handlers = new ConcurrentHashMap<>();

    private OrderServiceBO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public static <T> OrderServiceBO<T> of(Class<T> clazz) {
        return new OrderServiceBO<>(clazz);
    }

    public T getHandler(OrderType type, ApplicationContext applicationContext) {
        return applicationContext.getBean(getHandler(type), clazz);
    }

    public T getDefaultHandler(ApplicationContext applicationContext) {
        return applicationContext.getBean(getDefaultHandler(), clazz);
    }

    public String getHandler(OrderType type) {
        return Optional.ofNullable(this.handlers.get(type))
                .orElse(defaultHandler);
    }

    public String getDefaultHandler() {
        return defaultHandler;
    }

    public void setHandler(OrderType type, String handler) {
        this.handlers.put(type, handler);
    }

    public void setHandler(OrderType type, String handler, boolean isDefault) {
        if (isDefault) setDefaultHandler(handler);
        setHandler(type, handler);
    }

    public void setDefaultHandler(String defaultHandler) {
        this.defaultHandler = defaultHandler;
    }

}
