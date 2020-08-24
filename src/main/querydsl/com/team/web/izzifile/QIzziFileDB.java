package com.team.web.izzifile;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIzziFileDB is a Querydsl query type for IzziFileDB
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIzziFileDB extends EntityPathBase<IzziFileDB> {

    private static final long serialVersionUID = 1318129166L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIzziFileDB izziFileDB = new QIzziFileDB("izziFileDB");

    public final com.team.web.board.QBoard board;

    public final ArrayPath<byte[], Byte> data = createArray("data", byte[].class);

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final com.team.web.order.QOrder order;

    public final StringPath type = createString("type");

    public QIzziFileDB(String variable) {
        this(IzziFileDB.class, forVariable(variable), INITS);
    }

    public QIzziFileDB(Path<? extends IzziFileDB> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIzziFileDB(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIzziFileDB(PathMetadata metadata, PathInits inits) {
        this(IzziFileDB.class, metadata, inits);
    }

    public QIzziFileDB(Class<? extends IzziFileDB> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new com.team.web.board.QBoard(forProperty("board"), inits.get("board")) : null;
        this.order = inits.isInitialized("order") ? new com.team.web.order.QOrder(forProperty("order"), inits.get("order")) : null;
    }

}

