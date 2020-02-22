package co.yixiang.service.mapper;

import co.yixiang.domain.LocalStorage;
import co.yixiang.service.dto.LocalStorageDTO;
import co.yixiang.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
* @author Zheng Jie
* @date 2019-09-05
*/
@Component
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalStorageMapper extends BaseMapper<LocalStorageDTO, LocalStorage> {

}