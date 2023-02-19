package tr.com.trackago.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.base.service.impl.TrackAgoAbstractServiceImpl;
import tr.com.trackago.server.converter.SiteConverter;
import tr.com.trackago.server.dao.SiteDAO;
import tr.com.trackago.server.domain.Site;
import tr.com.trackago.server.dto.domain.SiteDTO;
import tr.com.trackago.server.service.SiteService;
import tr.com.trackago.taconverter.TrackAgoConverter;
import tr.com.trackago.taexception.TrackAgoBusinessException;

import java.util.Optional;

@Service
public class SiteServiceImpl extends TrackAgoAbstractServiceImpl<Site, SiteDTO> implements SiteService {


    SiteDAO dao;
    SiteConverter converter;

    @Autowired
    public SiteServiceImpl(SiteDAO dao, SiteConverter converter) {
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
    protected void preInsertValid(SiteDTO siteDTO) throws TrackAgoBusinessException {
        Optional<Site> existingProduct = dao.findByName(siteDTO.getName());
        if (existingProduct.isPresent())
            throw new TrackAgoBusinessException("This site already exist in the Category", this.getClass().getSimpleName(), "preInsert");
    }

    @Override
    protected void preUpdateValid(SiteDTO productDTO) throws TrackAgoBusinessException {

    }

    @Override
    protected void preDeleteValid(SiteDTO productDTO) throws TrackAgoBusinessException {

    }

    @Override
    protected void validate(SiteDTO productDTO) throws TrackAgoBusinessException {

    }


}
