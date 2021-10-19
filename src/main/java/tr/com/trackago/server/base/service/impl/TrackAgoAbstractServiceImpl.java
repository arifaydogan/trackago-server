package tr.com.trackago.server.base.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import tr.com.trackago.server.base.dao.TrackAgoBaseDao;
import tr.com.trackago.server.base.entity.BaseEntity;
import tr.com.trackago.server.base.service.TrackAgoAbstractService;
import tr.com.trackago.taconverter.TrackAgoConverter;
import tr.com.trackago.tadto.BaseDTO;
import tr.com.trackago.taexception.TrackAgoBusinessException;
import tr.com.trackago.taexception.TrackAgoException;
import tr.com.trackago.tautil.CollectionsUtil;
import tr.com.trackago.tautil.ObjectUtil;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public abstract class TrackAgoAbstractServiceImpl<E extends BaseEntity, D extends BaseDTO> implements TrackAgoAbstractService<E, D> {

    protected Class<E> entityClass;
    protected Class<D> dtoClass;

    @PostConstruct
    public void init() {
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected abstract TrackAgoBaseDao getDao();

    protected abstract TrackAgoConverter getConverter();

    @Override
    public D save(D dto) throws TrackAgoException {
        preInsertValid(dto);
        validate(dto);
        E mappedEntity = toEntity(dto);
        mappedEntity = (E) getDao().save(mappedEntity);
        return toDto(mappedEntity);
    }

    @Override
    public D update(D dto) throws TrackAgoException {
        preUpdateValid(dto);
        validate(dto);
        E mappedEntity = toEntity(dto);
        mappedEntity = (E) getDao().save(mappedEntity);
        return toDto(mappedEntity);
    }

    @Override
    public void delete(D dto) throws TrackAgoException {
        preDeleteValid(dto);
        E mappedEntity = toEntity(dto);
        getDao().delete(mappedEntity);
    }

    @Override
    @Cacheable(cacheNames = "findByIdCache")
    public D find(Long id) throws TrackAgoException {
        Optional<E> entity = getDao().findById(id);
        if (entity.isPresent())
            return toDto(entity.get());

        return null;
    }

    @Override
    public E toEntity(D dto) {
        if (ObjectUtil.isNotEmpty(dto))
            return (E) getConverter().dtoToEntity(dto);
        else
            return null;
    }

    @Override
    public D toDto(E entity) {
        if (ObjectUtil.isNotEmpty(entity))
            return (D) getConverter().entityToDto(entity);
        else
            return null;
    }


    @Override
    public List<D> toListDto(List<E> entityList) {
        if (CollectionsUtil.isCollectionNotEmpty(entityList)) {
            return getConverter().map(entityList);
        }
        return null;
    }

    /**
     * Page tipinde convert etmek için kullanılır.
     *
     * @param pageRequest The information of the requested page.
     * @param source      The {@code Page<E>} object.
     * @return The created {@code Page<D>} object.
     */
    @Override
    public Page<D> entityToPageDto(Pageable pageRequest, Page<E> source) {
        List<D> dtos = getConverter().map(source.get().collect(Collectors.toList())); //mapper.map(source.getContent(), dtoClass, entityClass);
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }

    protected abstract void preInsertValid(D d) throws TrackAgoBusinessException;

    protected abstract void preUpdateValid(D d) throws TrackAgoBusinessException;

    protected abstract void preDeleteValid(D d) throws TrackAgoBusinessException;

    protected abstract void validate(D d) throws TrackAgoBusinessException;

}
