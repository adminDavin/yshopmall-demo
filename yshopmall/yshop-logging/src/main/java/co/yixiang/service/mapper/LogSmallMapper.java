package co.yixiang.service.mapper;

import co.yixiang.domain.Log;
import co.yixiang.base.BaseMapper;
import co.yixiang.service.dto.LogSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
 * @author Zheng Jie
 * @date 2019-5-22
 */
@Component
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends BaseMapper<LogSmallDTO, Log> {

}