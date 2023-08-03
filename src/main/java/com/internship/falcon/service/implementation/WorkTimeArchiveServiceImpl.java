package com.internship.falcon.service.implementation;

import com.internship.falcon.dto.WorkTimeArchiveDto;
import com.internship.falcon.dto.mapper.Mapper;
import com.internship.falcon.entity.WorkTimeArchive;
import com.internship.falcon.filter.WorkTimeArchiveFilter;
import com.internship.falcon.repository.WorkTimeArchiveRepository;
import com.internship.falcon.service.WorkTimeArchiveService;
import com.internship.falcon.enums.MessagesEnum;
import com.internship.falcon.spec.WorkTimeArchiveSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeArchiveServiceImpl implements WorkTimeArchiveService {

    private final WorkTimeArchiveRepository workTimeArchiveRepository;

    @Autowired
    public WorkTimeArchiveServiceImpl(WorkTimeArchiveRepository workTimeArchiveRepository){
        this.workTimeArchiveRepository = workTimeArchiveRepository;
    }


    @Override
    public WorkTimeArchiveDto getWorkTimeArchiveById(Integer id) {
        return Mapper.workTimeArchiveDtoMapper(workTimeArchiveRepository.findById(id).get());
    }

    @Override
    public String addWorkTimeArchive(WorkTimeArchive workTimeArchive) {
        workTimeArchiveRepository.save(workTimeArchive);
        return MessagesEnum.successfullyAdded.getValue();
    }

    @Override
    public String updateWorkTimeArchiveById(Integer id, WorkTimeArchive workTimeArchive) {
        WorkTimeArchive wta = workTimeArchiveRepository.findById(id).get();

        if(workTimeArchive.getDate() != null){
            wta.setDate(workTimeArchive.getDate());
        }
        if(workTimeArchive.getProjectAssignment() != null){
            wta.setProjectAssignment(workTimeArchive.getProjectAssignment());
        }
        if(workTimeArchive.getWorkAmount() != null){
            wta.setWorkAmount(workTimeArchive.getWorkAmount());
        }

        workTimeArchiveRepository.save(wta);

        return MessagesEnum.successfullyUpdated.getValue();
    }

    @Override
    public String deleteWorkTimeArchiveById(Integer id) {
        workTimeArchiveRepository.deleteById(id);
        return MessagesEnum.successfullyDeleted.getValue();
    }

    @Override
    public List<WorkTimeArchiveDto> getWorkTimeArchiveByFilter(int page, int size, WorkTimeArchiveFilter workTimeArchiveFilter) {

        Pageable pageable = PageRequest.of(page, size);

        return Mapper.workTimeArchiveDtoListMapper(workTimeArchiveRepository.findAll(WorkTimeArchiveSpecification.generalFilter(workTimeArchiveFilter),pageable).getContent());
    }

    @Override
    public long getWorkTimeArchiveCountByFilter(WorkTimeArchiveFilter workTimeArchiveFilter) {
        return workTimeArchiveRepository.count(WorkTimeArchiveSpecification.generalFilter(workTimeArchiveFilter));
    }


}
