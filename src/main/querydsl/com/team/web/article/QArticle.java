package com.team.web.article;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArticle extends EntityPathBase<Article> {

    private static final long serialVersionUID = 1643035648L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticle article = new QArticle("article");

    public final StringPath address = createString("address");

    public final NumberPath<Long> articleId = createNumber("articleId", Long.class);

    public final com.team.web.board.QBoard board;

    public final StringPath comContents = createString("comContents");

    public final DatePath<java.time.LocalDate> comRegDate = createDate("comRegDate", java.time.LocalDate.class);

    public final StringPath comWriter = createString("comWriter");

    public final StringPath contents = createString("contents");

    public final StringPath image = createString("image");

    public final DatePath<java.time.LocalDate> regDate = createDate("regDate", java.time.LocalDate.class);

    public final StringPath title = createString("title");

    public final StringPath video = createString("video");

    public final StringPath writer = createString("writer");

    public QArticle(String variable) {
        this(Article.class, forVariable(variable), INITS);
    }

    public QArticle(Path<? extends Article> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticle(PathMetadata metadata, PathInits inits) {
        this(Article.class, metadata, inits);
    }

    public QArticle(Class<? extends Article> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new com.team.web.board.QBoard(forProperty("board"), inits.get("board")) : null;
    }

}

