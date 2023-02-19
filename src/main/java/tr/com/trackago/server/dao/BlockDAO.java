package tr.com.trackago.server.dao;

import org.springframework.stereotype.Repository;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.domain.Block;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlockDAO extends TrackAgoBaseDao<Block, Long> {

    Optional<Block> getBlockBySite_SiteId(Long siteId);

}
