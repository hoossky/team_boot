package com.team.web.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 1367148976L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    public final ListPath<com.team.web.izzifile.IzziFileDB, com.team.web.izzifile.QIzziFileDB> izziFileDBList = this.<com.team.web.izzifile.IzziFileDB, com.team.web.izzifile.QIzziFileDB>createList("izziFileDBList", com.team.web.izzifile.IzziFileDB.class, com.team.web.izzifile.QIzziFileDB.class, PathInits.DIRECT2);

    public final StringPath movingDate = createString("movingDate");

    public final StringPath movingDetail = createString("movingDetail");

    public final StringPath movingFrom = createString("movingFrom");

    public final StringPath movingName = createString("movingName");

    public final StringPath movingPhone = createString("movingPhone");

    public final NumberPath<Integer> movingPrice = createNumber("movingPrice", Integer.class);

    public final StringPath movingTo = createString("movingTo");

    public final StringPath movingType = createString("movingType");

    public final StringPath movingWriter = createString("movingWriter");

    public final StringPath optionalAddrFrom = createString("optionalAddrFrom");

    public final StringPath optionalAddrTo = createString("optionalAddrTo");

    public final DatePath<java.time.LocalDate> orderDate = createDate("orderDate", java.time.LocalDate.class);

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final DatePath<java.time.LocalDate> paymentDate = createDate("paymentDate", java.time.LocalDate.class);

    public final StringPath paymentMethod = createString("paymentMethod");

    public final StringPath paymentStatus = createString("paymentStatus");

    public final NumberPath<Integer> square = createNumber("square", Integer.class);

    public final com.team.web.user.QUser user;

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrder(PathMetadata metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.team.web.user.QUser(forProperty("user")) : null;
    }

}

