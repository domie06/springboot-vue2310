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

import com.entity.FangwuLiuyanEntity;

import com.service.FangwuLiuyanService;
import com.entity.view.FangwuLiuyanView;
import com.service.FangwuService;
import com.entity.FangwuEntity;
import com.service.KehuService;
import com.entity.KehuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 房屋留言
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/fangwuLiuyan")
public class FangwuLiuyanController {
    private static final Logger logger = LoggerFactory.getLogger(FangwuLiuyanController.class);

    @Autowired
    private FangwuLiuyanService fangwuLiuyanService;


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
            params.put("orderBy","id");
        PageUtils page = fangwuLiuyanService.queryPage(params);

        //字典表数据转换
        List<FangwuLiuyanView> list =(List<FangwuLiuyanView>)page.getList();
        for(FangwuLiuyanView c:list){
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
        FangwuLiuyanEntity fangwuLiuyan = fangwuLiuyanService.selectById(id);
        if(fangwuLiuyan !=null){
            //entity转view
            FangwuLiuyanView view = new FangwuLiuyanView();
            BeanUtils.copyProperties( fangwuLiuyan , view );//把实体数据重构到view中

            //级联表
            FangwuEntity fangwu = fangwuService.selectById(fangwuLiuyan.getFangwuId());
            if(fangwu != null){
                BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setFangwuId(fangwu.getId());
            }
            //级联表
            KehuEntity kehu = kehuService.selectById(fangwuLiuyan.getKehuId());
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
    public R save(@RequestBody FangwuLiuyanEntity fangwuLiuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangwuLiuyan:{}",this.getClass().getName(),fangwuLiuyan.toString());
        fangwuLiuyan.setInsertTime(new Date());
        fangwuLiuyan.setCreateTime(new Date());
        fangwuLiuyanService.insert(fangwuLiuyan);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangwuLiuyanEntity fangwuLiuyan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangwuLiuyan:{}",this.getClass().getName(),fangwuLiuyan.toString());
        fangwuLiuyanService.updateById(fangwuLiuyan);//根据id更新
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangwuLiuyanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fangwuLiuyanService.queryPage(params);

        //字典表数据转换
        List<FangwuLiuyanView> list =(List<FangwuLiuyanView>)page.getList();
        for(FangwuLiuyanView c:list){
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
        FangwuLiuyanEntity fangwuLiuyan = fangwuLiuyanService.selectById(id);
            if(fangwuLiuyan !=null){
                //entity转view
        FangwuLiuyanView view = new FangwuLiuyanView();
                BeanUtils.copyProperties( fangwuLiuyan , view );//把实体数据重构到view中

                //级联表
                    FangwuEntity fangwu = fangwuService.selectById(fangwuLiuyan.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
                //级联表
                    KehuEntity kehu = kehuService.selectById(fangwuLiuyan.getKehuId());
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
    public R add(@RequestBody FangwuLiuyanEntity fangwuLiuyan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangwuLiuyan:{}",this.getClass().getName(),fangwuLiuyan.toString());
        fangwuLiuyan.setInsertTime(new Date());
        fangwuLiuyan.setCreateTime(new Date());
        fangwuLiuyanService.insert(fangwuLiuyan);
        return R.ok();
    }





}

