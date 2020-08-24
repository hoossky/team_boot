package com.team.web.statistics;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStatistics is a Querydsl query type for Statistics
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStatistics extends EntityPathBase<Statistics> {

    private static final long serialVersionUID = 1104848272L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStatistics statistics = new QStatistics("statistics");

    public final StringPath dailyProfit = createString("dailyProfit");

    public final NumberPath<Long> keyId = createNumber("keyId", Long.class);

    public final StringPath monthlyProfit = createString("monthlyProfit");

    public final StringPath pattern = createString("pattern");

    public final NumberPath<Float> pbRain = createNumber("pbRain", Float.class);

    public final NumberPath<Double> precipitationDaily = createNumber("precipitationDaily", Double.class);

    public final StringPath precipitationDate = createString("precipitationDate");

    public final StringPath precipitationLocation = createString("precipitationLocation");

    public final StringPath precipitationYear = createString("precipitationYear");

    public final NumberPath<Integer> rain = createNumber("rain", Integer.class);

    public final com.team.web.user.QUser user;

    public final StringPath yearlyProfit = createString("yearlyProfit");

    public QStatistics(String variable) {
        this(Statistics.class, forVariable(variable), INITS);
    }

    public QStatistics(Path<? extends Statistics> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStatistics(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStatistics(PathMetadata metadata, PathInits inits) {
        this(Statistics.class, metadata, inits);
    }

    public QStatistics(Class<? extends Statistics> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.team.web.user.QUser(forProperty("user")) : null;
    }

}

