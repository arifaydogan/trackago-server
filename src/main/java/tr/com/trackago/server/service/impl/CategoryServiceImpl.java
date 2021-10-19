package tr.com.trackago.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.base.service.impl.TrackAgoAbstractServiceImpl;
import tr.com.trackago.server.converter.CategoryConverter;
import tr.com.trackago.server.dao.CategoryDAO;
import tr.com.trackago.server.domain.Category;
import tr.com.trackago.server.dto.domain.CategoryDTO;
import tr.com.trackago.server.service.CategoryService;
import tr.com.trackago.taconverter.TrackAgoConverter;
import tr.com.trackago.taexception.TrackAgoBusinessException;

import java.util.Optional;

@Service
public class CategoryServiceImpl extends TrackAgoAbstractServiceImpl<Category, CategoryDTO> implements CategoryService {

    CategoryDAO dao;
    CategoryConverter converter;

    @Autowired
    public CategoryServiceImpl(CategoryDAO dao, CategoryConverter converter) {
        this.dao = dao;
        this.converter = converter;
    }

    @Override
    protected TrackAgoBaseDao getDao() {
        return dao;
    }

    @Override
    protected TrackAgoConverter getConverter() {
        return converter;
    }

    @Override
    protected void preInsertValid(CategoryDTO categoryDTO) throws TrackAgoBusinessException {
        Optional<Category> existingCategory = dao.findByName(categoryDTO.getName());
        if (existingCategory.isPresent())
            throw new TrackAgoBusinessException("This Category already exist.", this.getClass().getSimpleName(), "preInsert");

    }

    @Override
    protected void preUpdateValid(CategoryDTO categoryDTO) throws TrackAgoBusinessException {

    }

    @Override
    protected void preDeleteValid(CategoryDTO categoryDTO) throws TrackAgoBusinessException {

    }

    @Override
    protected void validate(CategoryDTO categoryDTO) throws TrackAgoBusinessException {

    }
}
