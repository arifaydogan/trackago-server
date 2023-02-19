package tr.com.trackago.server.dao;

import org.springframework.stereotype.Repository;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.domain.Site;

import java.util.Optional;

@Repository
public interface SiteDAO extends TrackAgoBaseDao<Site, Long> {

    Optional<Site> findByName(String name);
}
