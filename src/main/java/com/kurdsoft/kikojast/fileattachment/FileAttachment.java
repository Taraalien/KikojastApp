package com.kurdsoft.kikojast.fileattachment;
import com.kurdsoft.kikojast.base.BaseEntity;
import com.kurdsoft.kikojast.place.Place;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "file_attachments_tbl")
@Data
public class FileAttachment extends BaseEntity {

    @NotNull
    @Column(name = "image")
    private String image;


    @OneToOne
    @JoinColumn(name = "place_id",unique = true)
    private Place place;



}