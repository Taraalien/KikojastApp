package com.kurdsoft.kikojast.place;


import com.kurdsoft.kikojast.fileattachment.FileAttachment;
import com.kurdsoft.kikojast.base.BaseEntity;
import com.kurdsoft.kikojast.comment.Comment;
import com.kurdsoft.kikojast.like.Like;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "plc_tbl")
@Audited
public class Place  extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "startservice")
    private Integer startService;


    @NotNull
    @Column(name = "endservice")
    private Integer endService;

    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "location")
    private Point<G2D> location;

    @OneToMany(mappedBy = "place",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Like> placeLikes;

    @OneToMany(mappedBy = "place",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Comment> placeComment;

    @OneToOne(mappedBy = "place")
    private FileAttachment attachment;




}
