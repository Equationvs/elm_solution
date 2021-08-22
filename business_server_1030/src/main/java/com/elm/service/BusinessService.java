package com.elm.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.entity.Business;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface BusinessService extends IService<Business> {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    //通过商家 ID 查询商家信息(包括商家发布食品---Food_Server_1020,跨服务访问)
    public Business getBusinessById(Long businessId);
}
