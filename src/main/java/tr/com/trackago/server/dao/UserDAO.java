package tr.com.trackago.server.dao;

import org.springframework.stereotype.Repository;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.domain.User;

@Repository
public interface UserDAO extends TrackAgoBaseDao<User, Long> {

}
