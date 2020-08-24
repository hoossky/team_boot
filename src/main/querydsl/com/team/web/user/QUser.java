package com.team.web.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 611542480L;

    public static final QUser user = new QUser("user");

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    public final ListPath<com.team.web.board.Board, com.team.web.board.QBoard> board = this.<com.team.web.board.Board, com.team.web.board.QBoard>createList("board", com.team.web.board.Board.class, com.team.web.board.QBoard.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> joinDate = createDate("joinDate", java.time.LocalDate.class);

    public final StringPath latitude = createString("latitude");

    public final StringPath longitude = createString("longitude");

    public final StringPath name = createString("name");

    public final StringPath optionalAddr = createString("optionalAddr");

    public final ListPath<com.team.web.order.Order, com.team.web.order.QOrder> orderList = this.<com.team.web.order.Order, com.team.web.order.QOrder>createList("orderList", com.team.web.order.Order.class, com.team.web.order.QOrder.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final ListPath<com.team.web.statistics.Statistics, com.team.web.statistics.QStatistics> statistics = this.<com.team.web.statistics.Statistics, com.team.web.statistics.QStatistics>createList("statistics", com.team.web.statistics.Statistics.class, com.team.web.statistics.QStatistics.class, PathInits.DIRECT2);

    public final StringPath userId = createString("userId");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

