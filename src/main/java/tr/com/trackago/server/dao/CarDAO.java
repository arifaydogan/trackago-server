package tr.com.trackago.server.dao;

import org.springframework.stereotype.Repository;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.domain.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarDAO extends TrackAgoBaseDao<Car, Long> {

    List<Car> findAllByFlat_FlatId(Long flatId);

    Optional<Car> findByPlate(String plate);
}
