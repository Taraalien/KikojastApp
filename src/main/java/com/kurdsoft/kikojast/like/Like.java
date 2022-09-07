package com.kurdsoft.kikojast.like;


import com.kurdsoft.kikojast.base.BaseEntity;
import com.kurdsoft.kikojast.place.Place;
import com.kurdsoft.kikojast.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
@Table(name = "like_tbl")
@Data
public class Like extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    Place place;

    @Column(name="like")
    private boolean like;


}
