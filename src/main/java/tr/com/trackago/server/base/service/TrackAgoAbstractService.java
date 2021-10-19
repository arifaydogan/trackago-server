package tr.com.trackago.server.base.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.trackago.server.base.entity.BaseEntity;
import tr.com.trackago.tadto.BaseDTO;
import tr.com.trackago.taexception.TrackAgoException;

import java.util.List;

public interface TrackAgoAbstractService<E extends BaseEntity, D extends BaseDTO> {

    D save(D dto) throws TrackAgoException;

    D update(D dto) throws TrackAgoException;

    void delete(D dto) throws TrackAgoException;

    D find(Long id) throws TrackAgoException;

    E toEntity(D dto);

    D toDto(E entity);

    List<D> toListDto(List<E> entityList);

    Page<D> entityToPageDto(Pageable pageRequest, Page<E> source);
}
