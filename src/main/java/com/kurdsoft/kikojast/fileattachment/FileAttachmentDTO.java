package com.kurdsoft.kikojast.fileattachment;


import com.kurdsoft.kikojast.base.BaseDTO;
import com.kurdsoft.kikojast.place.PlaceDTO;
import io.swagger.annotations.ApiModelProperty;

public class FileAttachmentDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String image;


    @ApiModelProperty(required = true,hidden = false)
    private PlaceDTO placeDTO;
}
