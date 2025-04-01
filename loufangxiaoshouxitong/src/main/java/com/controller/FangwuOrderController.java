package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.FangwuOrderEntity;

import com.service.FangwuOrderService;
import com.entity.view.FangwuOrderView;
import com.service.FangwuService;
import com.entity.FangwuEntity;
import com.service.KehuService;
import com.entity.KehuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 房屋订单
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/fangwuOrder")
public class FangwuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(FangwuOrderController.class);

    @Autowired
    private FangwuOrderService fangwuOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private FangwuService fangwuService;
    @Autowired
    private KehuService kehuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "客户".equals(role)){
            params.put("kehuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = fangwuOrderService.queryPage(params);

        //字典表数据转换
        List<FangwuOrderView> list =(List<FangwuOrderView>)page.getList();
        for(FangwuOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangwuOrderEntity fangwuOrder = fangwuOrderService.selectById(id);
        if(fangwuOrder !=null){
            //entity转view
            FangwuOrderView view = new FangwuOrderView();
            BeanUtils.copyProperties( fangwuOrder , view );//把实体数据重构到view中

            //级联表
            FangwuEntity fangwu = fangwuService.selectById(fangwuOrder.getFangwuId());
            if(fangwu != null){
                BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setFangwuId(fangwu.getId());
            }
            //级联表
            KehuEntity kehu = kehuService.selectById(fangwuOrder.getKehuId());
            if(kehu != null){
                BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setKehuId(kehu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangwuOrderEntity fangwuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangwuOrder:{}",this.getClass().getName(),fangwuOrder.toString());
        fangwuOrder.setInsertTime(new Date());
        fangwuOrder.setCreateTime(new Date());
        fangwuOrderService.insert(fangwuOrder);
        return R.ok();
    }

    /**
     * 后端修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FangwuOrderEntity fangwuOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangwuOrder:{}",this.getClass().getName(),fangwuOrder.toString());
        FangwuOrderEntity fangwuOrderEntity = fangwuOrderService.selectById(fangwuOrder.getId());//当前订单数据
        if(fangwuOrder.getFangwuOrderTypes()== 2 && fangwuOrderEntity.getFangwuOrderTypes() == 1){
            Integer fangwuId = fangwuOrderEntity.getFangwuId();
            FangwuEntity fangwuEntity = fangwuService.selectById(fangwuId);
            int i = fangwuEntity.getFangwuNumber() - 1;
            fangwuEntity.setFangwuNumber(i);
            fangwuService.updateById(fangwuEntity); // 更新房屋信息
        }
        fangwuOrderService.updateById(fangwuOrder);//根据订单信息
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangwuOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "客户".equals(role)){
            params.put("kehuId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fangwuOrderService.queryPage(params);

        //字典表数据转换
        List<FangwuOrderView> list =(List<FangwuOrderView>)page.getList();
        for(FangwuOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangwuOrderEntity fangwuOrder = fangwuOrderService.selectById(id);
            if(fangwuOrder !=null){
                //entity转view
        FangwuOrderView view = new FangwuOrderView();
                BeanUtils.copyProperties( fangwuOrder , view );//把实体数据重构到view中

                //级联表
                    FangwuEntity fangwu = fangwuService.selectById(fangwuOrder.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
                //级联表
                    KehuEntity kehu = kehuService.selectById(fangwuOrder.getKehuId());
                if(kehu != null){
                    BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKehuId(kehu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangwuOrderEntity fangwuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangwuOrder:{}",this.getClass().getName(),fangwuOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("客户".equals(role)){

            fangwuOrder.setCreateTime(new Date());
            fangwuOrder.setInsertTime(new Date());
            fangwuOrder.setFangwuOrderTypes(1);
            fangwuOrderService.insert(fangwuOrder);
            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }





}

