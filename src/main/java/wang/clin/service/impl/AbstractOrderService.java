package wang.clin.service.impl;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.context.ApplicationContext;
import wang.clin.annotation.*;
import wang.clin.enums.OrderType;
import wang.clin.pojo.bo.OrderBO;
import wang.clin.pojo.bo.OrderServiceBO;
import wang.clin.pojo.dto.OrderOrderDTO;
import wang.clin.pojo.dto.OrderPayDTO;
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
        initHandlers();
    }

    @Override
    public OrderBO order(OrderOrderDTO order) {
        OrderType type = OrderType.of(order.getType());
        return orderBasicsServices.getHandler(type).order(order);
    }

    @Override
    public OrderBO pay(OrderPayDTO order) {
        OrderType type = OrderType.of(order.getType());
        return orderPayServices.getHandler(type).pay(order);
    }

    protected void initHandlers() {
        orderBasicsServices = initHandler(OrderBasics.class,
                OrderServiceBO.of(OrderBasicsService.class, applicationContext));
        orderErpServices = initHandler(OrderErp.class,
                OrderServiceBO.of(OrderErpService.class, applicationContext));
        orderLogisticsServices = initHandler(OrderLogistics.class,
                OrderServiceBO.of(OrderLogisticsService.class, applicationContext));
        orderPayServices = initHandler(OrderPay.class,
                OrderServiceBO.of(OrderPayService.class, applicationContext));
        orderReviewServices = initHandler(OrderReview.class,
                OrderServiceBO.of(OrderReviewService.class, applicationContext));
    }

    protected <T> OrderServiceBO<T> initHandler(Class<? extends Annotation> annotationClazz,
                                                OrderServiceBO<T> orderService) {
        var classes = ClassUtil.scanPackageByAnnotation(HANDLER_PACKAGE, annotationClazz);
        for (var clazz : classes) {
            var annotation = clazz.getAnnotation(annotationClazz);
            boolean isDefault = ReflectUtil.invoke(annotation, "isDefault");
            OrderType type = ReflectUtil.invoke(annotation, "type");
            var serviceName = StrUtil.lowerFirst(clazz.getSimpleName());
            orderService.setHandler(type, serviceName, isDefault);
        }
        if (StrUtil.isBlank(orderService.getDefaultHandlerBeanName())) {
            throw new IllegalStateException(annotationClazz.getName()
                    + " can not find default handler");
        }
        return orderService;
    }

}
