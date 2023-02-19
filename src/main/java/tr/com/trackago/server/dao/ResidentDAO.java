package tr.com.trackago.server.dao;

import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import org.springframework.stereotype.Repository;
import tr.com.trackago.server.domain.Resident;

@Repository
public interface ResidentDAO extends TrackAgoBaseDao<Resident, Long> {

}
