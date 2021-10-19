package tr.com.trackago.server.dao;

import org.springframework.stereotype.Repository;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.domain.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDAO extends TrackAgoBaseDao<Product, Long> {

    Optional<Product> getByCategory_IdAndName(Long categoryId, String name);

    List<Product> getAllByCategory_Id(Long categoryId);

}
