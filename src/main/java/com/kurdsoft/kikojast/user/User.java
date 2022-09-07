package com.kurdsoft.kikojast.user;


import com.kurdsoft.kikojast.base.BaseEntity;
import com.kurdsoft.kikojast.comment.Comment;
import com.kurdsoft.kikojast.like.Like;
import com.kurdsoft.kikojast.place.Place;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user_tbl")
@Data
@Audited
public class User extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "lastname")
    private String lastName;

    @NotNull
    @Column(name = "gmail")
    private String gmail;

    @NotNull
    @Column(name = "password")
    private String passWord;


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Like> userLikes;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Comment> userComment;

}
