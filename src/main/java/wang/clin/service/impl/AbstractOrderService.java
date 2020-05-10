package wang.clin.service.impl;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.context.ApplicationContext;
import wang.clin.annotation.*;
import wang.clin.enums.OrderType;
import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.bo.OrderServiceBO;
import wang.clin.pojo.dto.OrderLogisticsDTO;
import wang.clin.pojo.dto.OrderOrderDTO;
import wang.clin.pojo.dto.OrderPayDTO;
import wang.clin.pojo.dto.OrderReviewDTO;
import wang.clin.service.*;

import java.lang.annotation.Annotation;

/**
 * 接口调度器
 *
 * @author wcLin
 * @since 2020/5/9 上午 08:49
 **/
public abstract class AbstractOrderService implements OrderService {

    /**
     * 处理器的包名位置
     */
    private static final String HANDLER_PACKAGE = "wang.clin.service.impl";

    /**
     * spring app 上下文
     */
    private final ApplicationContext applicationContext;

    private OrderServiceBO<OrderBasicsService> orderBasicsServices;
    private OrderServiceBO<OrderErpService> orderErpServices;
    private OrderServiceBO<OrderLogisticsService> orderLogisticsServices;
    private OrderServiceBO<OrderPayService> orderPayServices;
    private OrderServiceBO<OrderReviewService> orderReviewServices;

    public AbstractOrderService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        initServices();
    }

    @Override
    public OrderBO order(OrderOrderDTO order) {
        var type = OrderType.of(order.getType());
        return orderBasicsServices
                .getHandler(type, applicationContext).order(order);
    }

    @Override
    public OrderBO pay(OrderPayDTO order) {
        var type = OrderType.of(order.getType());
        orderPayServices
                .getHandler(type, applicationContext).pay(order);
        return orderErpServices
                .getHandler(type, applicationContext).erp(order);
    }

    @Override
    public OrderBO review(OrderReviewDTO order) {
        var type = OrderType.of(order.getType());
        return orderReviewServices
                .getHandler(type, applicationContext).review(order);
    }

    @Override
    public OrderBO logistics(OrderLogisticsDTO order) {
        var type = OrderType.of(order.getType());
        return orderLogisticsServices
                .getHandler(type, applicationContext).logistics(order);
    }

    /**
     * 初始化所有订单业务处理器
     */
    protected void initServices() {
        orderBasicsServices = initService(OrderBasics.class, OrderBasicsService.class);
        orderErpServices = initService(OrderErp.class, OrderErpService.class);
        orderLogisticsServices = initService(OrderLogistics.class, OrderLogisticsService.class);
        orderPayServices = initService(OrderPay.class, OrderPayService.class);
        orderReviewServices = initService(OrderReview.class, OrderReviewService.class);
    }

    /**
     * 初始化某一类业务的订单处理器
     *
     * @param annotationClazz   业务代表注解
     * @param orderServiceClazz 业务代表服务
     */
    protected <T> OrderServiceBO<T> initService(Class<? extends Annotation> annotationClazz,
                                                Class<T> orderServiceClazz) {
        var classes = ClassUtil.scanPackageByAnnotation(HANDLER_PACKAGE, annotationClazz);
        OrderServiceBO<T> orderService = OrderServiceBO.of(orderServiceClazz);
        for (var clazz : classes) {
            var annotation = clazz.getAnnotation(annotationClazz);
            var isDefault = (Boolean) ReflectUtil.invoke(annotation, "isDefault");
            var type = (OrderType) ReflectUtil.invoke(annotation, "type");
            var serviceName = StrUtil.lowerFirst(clazz.getSimpleName());
            orderService.setHandler(type, serviceName, isDefault);
        }
        if (StrUtil.isBlank(orderService.getDefaultHandler())) {
            throw new IllegalCallerException(annotationClazz.getName()
                    + " can not find default handler");
        }
        return orderService;
    }

}
