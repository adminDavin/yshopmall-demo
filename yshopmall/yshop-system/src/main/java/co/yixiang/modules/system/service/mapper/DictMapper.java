package co.yixiang.modules.system.service.mapper;

import co.yixiang.modules.system.service.dto.DictDTO;
import co.yixiang.base.BaseMapper;
import co.yixiang.modules.system.domain.Dict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDTO, Dict> {

}