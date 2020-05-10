package wang.clin.service.impl.weekend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wang.clin.annotation.OrderReview;
import wang.clin.enums.OrderType;
import wang.clin.service.impl.AbstractOrderReviewService;
import wang.clin.service.weekend.WeekendOrderReviewService;

/**
 * @author wcLin
 * @since 2020/5/9 上午 09:05
 **/
@Slf4j
@Service
@OrderReview(type = OrderType.WEEKEND, isDefault = true)
public class WeekendOrderReviewServiceImpl extends AbstractOrderReviewService
        implements WeekendOrderReviewService {
}
