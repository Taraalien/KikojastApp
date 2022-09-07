package com.kurdsoft.kikojast.comment;


import com.kurdsoft.kikojast.base.BaseDTO;
import com.kurdsoft.kikojast.place.PlaceDTO;
import com.kurdsoft.kikojast.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommentDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private UserDTO user;

    @ApiModelProperty(required = true,hidden = false)
    private PlaceDTO place;

    @ApiModelProperty(required =false,hidden = false)
    private String comment;
}
