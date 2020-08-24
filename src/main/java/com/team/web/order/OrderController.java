package com.team.web.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/esitmateform")
    public ResponseEntity<Order> estiFirst(@RequestBody Order estiJsnon) {

        Optional<Order> estiFirst = orderService.estiFirst(estiJsnon);
        System.out.println("폼 :" + estiJsnon.toString());
        if (estiFirst.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/calculator")
    public ResponseEntity<Order> estiPrice(@RequestBody Order result) {
        Optional<Order> estiPrice = orderService.estiPrice(result);
        System.out.println("자바 들어옴");
        System.out.println(result.getMovingPrice());
        if (estiPrice.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/totalPrice/{orderId}")
    public void calc(Order order){

    }



}

