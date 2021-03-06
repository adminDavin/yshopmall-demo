package co.yixiang.service.mapper;

import co.yixiang.domain.Log;
import co.yixiang.service.dto.LogErrorDTO;
import co.yixiang.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
 * @author Zheng Jie
 * @date 2019-5-22
 */
@Component
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogErrorMapper extends BaseMapper<LogErrorDTO, Log> {

}