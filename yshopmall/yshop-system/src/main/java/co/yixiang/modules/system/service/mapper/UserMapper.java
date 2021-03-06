package co.yixiang.modules.system.service.mapper;

import co.yixiang.modules.system.service.dto.UserDTO;
import co.yixiang.base.BaseMapper;
import co.yixiang.modules.system.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Component
@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class },unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserDTO, User> {

    /**
     * 转换
     * @param user 原始数据
     * @return /
     */
    @Override
    @Mapping(source = "user.userAvatar.realName",target = "avatar")
    UserDTO toDto(User user);
}
