package co.yixiang.modules.shop.rest;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import co.yixiang.aop.log.Log;
import co.yixiang.exception.BadRequestException;
import co.yixiang.modules.shop.domain.YxUser;
import co.yixiang.modules.shop.service.YxUserService;
import co.yixiang.modules.shop.service.dto.UserMoneyDTO;
import co.yixiang.modules.shop.service.dto.YxUserQueryCriteria;
import co.yixiang.modules.wechat.service.YxSystemConfigService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author hupeng
* @date 2019-10-06
*/
@Api(tags = "用户管理")
@RestController
@RequestMapping("api")
public class YxUserController {

    @Autowired
    private YxUserService yxUserService;

    @Autowired
    private YxSystemConfigService yxSystemConfigService;

    @Log("查询用户")
    @ApiOperation(value = "查询用户")
    @GetMapping(value = "/yxUser")
    @PreAuthorize("@el.check('admin','YXUSER_ALL','YXUSER_SELECT')")
    public ResponseEntity getYxUsers(YxUserQueryCriteria criteria, Pageable pageable){
        if(ObjectUtil.isNotNull(criteria.getIsPromoter())){
            if(criteria.getIsPromoter() == 1){
                String key = yxSystemConfigService.findByKey("store_brokerage_statu")
                        .getValue();
                if(Integer.valueOf(key) == 2){
                    return new ResponseEntity(null,HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity(yxUserService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增用户")
    @ApiOperation(value = "新增用户")
    @PostMapping(value = "/yxUser")
    @PreAuthorize("@el.check('admin','YXUSER_ALL','YXUSER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody YxUser resources){
        return new ResponseEntity(yxUserService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改用户")
    @ApiOperation(value = "修改用户")
    @PutMapping(value = "/yxUser")
    @PreAuthorize("@el.check('admin','YXUSER_ALL','YXUSER_EDIT')")
    public ResponseEntity update(@Validated @RequestBody YxUser resources){
        yxUserService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除用户")
    @ApiOperation(value = "删除用户")
    @DeleteMapping(value = "/yxUser/{uid}")
    @PreAuthorize("@el.check('admin','YXUSER_ALL','YXUSER_DELETE')")
    public ResponseEntity delete(@PathVariable Integer uid){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        yxUserService.delete(uid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "用户禁用启用")
    @PostMapping(value = "/yxUser/onStatus/{id}")
    public ResponseEntity onStatus(@PathVariable Integer id,@RequestBody String jsonStr){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        int status = Integer.valueOf(jsonObject.get("status").toString());
        //System.out.println(status);
        yxUserService.onStatus(id,status);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "修改余额")
    @PostMapping(value = "/yxUser/money")
    @PreAuthorize("@el.check('admin','YXUSER_ALL','YXUSER_EDIT')")
    public ResponseEntity updatePrice(@Validated @RequestBody UserMoneyDTO param){

        yxUserService.updateMoney(param);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}