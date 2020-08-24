package com.team.web.order;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.team.web.common.JpaService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.text.ParseException;

@Component
interface OrderService extends JpaService<Order> {
    Optional<Order> estiFirst(Order order);

    Optional<Order> estiPrice(Order result);

}
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> estiFirst(Order order) {
        Order createOrder = new Order();
        createOrder.setMovingName(order.getMovingName());
        createOrder.setMovingDate(order.getMovingDate());
        createOrder.setMovingFrom(order.getMovingFrom());
        createOrder.setMovingTo(order.getMovingTo());
        createOrder.setMovingPhone(order.getMovingPhone());
        createOrder.setMovingType(order.getMovingType());
        createOrder.setOptionalAddrFrom(order.getOptionalAddrFrom());
        createOrder.setOptionalAddrTo(order.getOptionalAddrTo());
        createOrder.setMovingDetail(order.getMovingDetail());
        createOrder.setMovingWriter(order.getMovingWriter());

        System.out.println(createOrder);

        Order orderData = orderRepository.save(createOrder);
        return Optional.of(orderData);
    }


    @Override
    public Optional<Order> estiPrice(Order order) {
        Order createResult = new Order();
        createResult.setMovingPrice(order.getMovingPrice());
        createResult.setMovingDate(order.getMovingDate());

        Order resultData = orderRepository.save(createResult);
        return Optional.of(resultData);
    }

    public void dayCount(Order order) throws ParseException{

        String day = order.getMovingDate();
        String startDate = "2020-11-09";
        String endDate = "2020-11-20";

        System.out.println(isRange(day, startDate, endDate));
    }

    public static boolean isRange(String day, String startDate, String endDate) throws ParseException{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            simpleDateFormat.parse(day);
            simpleDateFormat.parse(startDate);
            simpleDateFormat.parse(endDate);
        } catch (ParseException e) {
            throw e;
        }

        LocalDate Localdate = LocalDate.parse(day);
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        endLocalDate = endLocalDate.plusDays(1);

        return ((!Localdate.isBefore(startLocalDate)) && (Localdate.isBefore(endLocalDate)));
    }

    public double calc(Order order) throws ParseException{
        String day = order.getMovingDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = SimpleDateFormat.parse(day);
        String returnVal = simpleDateFormat.format(date);
        System.out.println(returnVal);

        double result;
        int price = order.getMovingPrice();

        switch (returnVal){
            case "2020-08-27" : result = price * 0.8;
                break;
            case "10" : result = price * 1.15;
                break;
            case "11" : result = price * 1.35;
                break;
            default: result = price;
                break;
        }
        System.out.println(result);
        return result;
    }





    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderRepository.findById(Long.valueOf(id));
    }

    @Override
    public int count() {
        return 0;
    }


    @Override
    public boolean exists(String id) {
        return false;
    }
}
