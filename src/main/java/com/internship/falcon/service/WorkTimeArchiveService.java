package com.internship.falcon.service;

import com.internship.falcon.dto.WorkTimeArchiveDto;
import com.internship.falcon.entity.WorkTimeArchive;
import com.internship.falcon.filter.WorkTimeArchiveFilter;

import java.util.List;

public interface WorkTimeArchiveService {
    WorkTimeArchiveDto getWorkTimeArchiveById(Integer id);

    String addWorkTimeArchive(WorkTimeArchive workTimeArchive);

    String updateWorkTimeArchiveById(Integer id, WorkTimeArchive workTimeArchive);

    String deleteWorkTimeArchiveById(Integer id);

    List<WorkTimeArchiveDto> getWorkTimeArchiveByFilter(int page, int size, WorkTimeArchiveFilter workTimeArchiveFilter);

    long getWorkTimeArchiveCountByFilter(WorkTimeArchiveFilter workTimeArchiveFilter);
}
