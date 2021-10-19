package tr.com.trackago.server.dao;

import org.springframework.stereotype.Repository;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.domain.Category;

import java.util.Optional;

@Repository
public interface CategoryDAO extends TrackAgoBaseDao<Category, Long> {

    Optional<Category> findByName(String name);
}
