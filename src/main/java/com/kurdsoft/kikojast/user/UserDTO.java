package com.kurdsoft.kikojast.user;


import com.kurdsoft.kikojast.base.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class UserDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = true,hidden = false)
    private String lastName;

    @ApiModelProperty(required = true,hidden = false)
    private String gmail;

    @ApiModelProperty(required = true,hidden = false)
    private String passWord;
}
