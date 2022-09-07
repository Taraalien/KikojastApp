package com.kurdsoft.kikojast.fileattachment;

import com.kurdsoft.kikojast.place.PlaceMapper;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring",uses = {PlaceMapper.class})
public interface FileAttachmentMapper {

    FileAttachment toFileAttachment(FileAttachmentDTO fileAttachmentDTO);
    FileAttachmentDTO toFileAttachmentDTO(FileAttachment fileAttachment);
    List<FileAttachment> toFileAttachmentList(List<FileAttachmentDTO> fileAttachmentDTOs);
    List<FileAttachmentDTO> toFileAttachmentDTOs(List<FileAttachment> fileAttachments);

}
