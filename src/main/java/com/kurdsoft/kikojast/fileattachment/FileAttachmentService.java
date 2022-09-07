package com.kurdsoft.kikojast.fileattachment;


import com.kurdsoft.kikojast.place.IPlaceService;
import com.kurdsoft.kikojast.place.Place;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FileAttachmentService implements IFileAttchmentService {

    private  final FileAttachmentRepository repository;
    private  final IPlaceService service;



    @Override
    public FileAttachment save(FileAttachment fileAttachment) {
        Long plcpId=  fileAttachment.getPlace().getId();
        Place place=  service.getById(plcpId);
        fileAttachment.setPlace(place);

        return repository.save(fileAttachment);
    }


    @Override
    public void delete(Long id) {


        repository.deleteById(id);
    }

    @Override
    public FileAttachment getById(Long id) {
        Optional<FileAttachment> optionalFileAttachment=repository.findById(id);

        if (!optionalFileAttachment.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalFileAttachment.get();
    }

    @Override
    public List<FileAttachment> getAll() {
        return (List<FileAttachment>) repository.findAll();
    }

    @Override
    public FileAttachment getByEmployeeId(Long plcId) {

        Place plc=  service.getById(plcId);
        return repository.findByPlace(plc);
    }


}