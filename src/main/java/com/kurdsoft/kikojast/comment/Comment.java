package com.kurdsoft.kikojast.comment;

import com.kurdsoft.kikojast.base.BaseEntity;
import com.kurdsoft.kikojast.place.Place;
import com.kurdsoft.kikojast.user.User;
import com.kurdsoft.kikojast.user.UserDTO;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;


@Entity
@Data
@Audited
@Table(name = "comment_tbl")
public class Comment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    Place place;

    @Column(name = "comment")
    private String comment;

}
