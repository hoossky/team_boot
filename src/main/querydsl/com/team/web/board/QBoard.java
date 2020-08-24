package com.team.web.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = -1990867232L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final ListPath<com.team.web.article.Article, com.team.web.article.QArticle> articleList = this.<com.team.web.article.Article, com.team.web.article.QArticle>createList("articleList", com.team.web.article.Article.class, com.team.web.article.QArticle.class, PathInits.DIRECT2);

    public final NumberPath<Long> boardId = createNumber("boardId", Long.class);

    public final StringPath contact = createString("contact");

    public final ListPath<com.team.web.izzifile.IzziFileDB, com.team.web.izzifile.QIzziFileDB> izziFileDBList = this.<com.team.web.izzifile.IzziFileDB, com.team.web.izzifile.QIzziFileDB>createList("izziFileDBList", com.team.web.izzifile.IzziFileDB.class, com.team.web.izzifile.QIzziFileDB.class, PathInits.DIRECT2);

    public final StringPath market = createString("market");

    public final StringPath notice = createString("notice");

    public final StringPath review = createString("review");

    public final com.team.web.user.QUser user;

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.team.web.user.QUser(forProperty("user")) : null;
    }

}

