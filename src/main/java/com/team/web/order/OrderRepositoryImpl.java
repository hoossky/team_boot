package com.team.web.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team.web.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface IOrderRepository{

}
public class OrderRepositoryImpl extends QuerydslRepositorySupport implements IOrderRepository {
    @Autowired
    JPAQueryFactory queryFactory;
    OrderRepositoryImpl() {
        super(Order.class);
    }

}
