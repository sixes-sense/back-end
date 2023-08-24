package com.sixesSense.recorder.tag.query.application.service;

import com.sixesSense.recorder.tag.query.domain.entity.QueryTag;
import com.sixesSense.recorder.tag.query.domain.repository.QueryTagRepository;
import com.sixesSense.recorder.tag.query.domain.service.QueryTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryTagServiceImpl implements QueryTagService {
    private final QueryTagRepository tagRepository;

    @Autowired
    public QueryTagServiceImpl(QueryTagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    @Override
    public List<QueryTag> getAllTags() {
        return tagRepository.findAll();
    }
}
