package com.team.web.article;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.web.board.Board;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter @Setter @ToString @NoArgsConstructor
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="article_id") private Long articleId;
    @Column(name="title") private String  title;
    @Column(name="contents") private String  contents;
    @Column(name="writer" ) private String  writer;
    @Column(name="reg_date") private LocalDate regDate;
    @Column(name="image" ) private String  image;
    @Column(name="video" ) private String  video;
    @Column(name="com_contents") private String  comContents;
    @Column(name="com_reg_date" ) private LocalDate  comRegDate;
    @Column(name="com_writer" ) private String  comWriter;
    @Column(name="address") private String  address;
    @Builder
    private Article(
            String title,
            String contents,
            String writer,
            LocalDate regDate,
            String image,
            String video,
            String comContents,
            LocalDate comRegDate,
            String comWriter,
            String address
    ){

        this.title= title;
        this.contents= contents;
        this.writer= writer;
        this.regDate= regDate;
        this.image= image;
        this.video= video;
        this.comContents= comContents;
        this.comRegDate= comRegDate;
        this.comWriter= comWriter;
        this.address= address;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board;

}
