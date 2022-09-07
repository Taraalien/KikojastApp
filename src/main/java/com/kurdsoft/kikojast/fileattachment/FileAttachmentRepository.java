package com.kurdsoft.kikojast.fileattachment;

import com.kurdsoft.kikojast.place.Place;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FileAttachmentRepository extends PagingAndSortingRepository<FileAttachment,Long> {


    FileAttachment findByPlace(Place place);
}
