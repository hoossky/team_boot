package com.team.web.izzifile;

import com.team.web.board.Board;
import com.team.web.order.Order;
import com.team.web.user.User;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Getter
@Setter
@Entity
@ToString
/*@NoArgsConstructor*/

@Table(name="izzi_file")
public class IzziFileDB {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "type") private String type;
    @Column(name = "name") private String name;
/*    @Column(name = "date") private LocalDate date;*/
  /*  @Column(name = "size")
    private Long size;*/
/*    @Column(name="upload_id") private String uploadId;*/

    @Lob
    @Column private byte[] data;

   /* @Builder
    private IzziFile(String fileType, String fileName, LocalDate fileDate, String fileSize,byte[] data) {
        this.fileType = fileType;
        this.fileName = fileName;
        this.fileDate = fileDate;
        this.fileSize = fileSize;
        this.data=data;
   *//*     this.uploadId=uploadId;*//*

    }*/
    public IzziFileDB(){

    }
    public IzziFileDB(String type, String name, byte[] data){
        this.type = type;
        this.name = name;
        this.data=data;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board;



}

