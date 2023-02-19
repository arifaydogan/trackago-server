package tr.com.trackago.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.base.service.impl.TrackAgoAbstractServiceImpl;
import tr.com.trackago.server.converter.BlockConverter;
import tr.com.trackago.server.dao.BlockDAO;
import tr.com.trackago.server.domain.Block;
import tr.com.trackago.server.dto.domain.BlockDTO;
import tr.com.trackago.server.service.BlockService;
import tr.com.trackago.taconverter.TrackAgoConverter;
import tr.com.trackago.taexception.TrackAgoBusinessException;

import java.util.Optional;

@Service
public class BlockServiceImpl extends TrackAgoAbstractServiceImpl<Block, BlockDTO> implements BlockService {

    BlockDAO dao;
    BlockConverter converter;

    @Autowired
    public BlockServiceImpl(BlockDAO dao, BlockConverter converter) {
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
    protected void preInsertValid(BlockDTO blockDTO) throws TrackAgoBusinessException {
        Optional<Block> existingCategory = dao.getBlockBySite_SiteId(blockDTO.getSiteId());
        if (existingCategory.isPresent())
            throw new TrackAgoBusinessException("This Category already exist.", this.getClass().getSimpleName(), "preInsert");

    }

    @Override
    protected void preUpdateValid(BlockDTO categoryDTO) throws TrackAgoBusinessException {

    }

    @Override
    protected void preDeleteValid(BlockDTO categoryDTO) throws TrackAgoBusinessException {

    }

    @Override
    protected void validate(BlockDTO categoryDTO) throws TrackAgoBusinessException {

    }
}
