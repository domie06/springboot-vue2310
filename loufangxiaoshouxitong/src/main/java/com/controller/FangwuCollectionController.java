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

import com.entity.FangwuCollectionEntity;

import com.service.FangwuCollectionService;
import com.entity.view.FangwuCollectionView;
import com.service.FangwuService;
import com.entity.FangwuEntity;
import com.service.KehuService;
import com.entity.KehuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 房屋收藏
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/fangwuCollection")
public class FangwuCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(FangwuCollectionController.class);

    @Autowired
    private FangwuCollectionService fangwuCollectionService;


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
        PageUtils page = fangwuCollectionService.queryPage(params);

        //字典表数据转换
        List<FangwuCollectionView> list =(List<FangwuCollectionView>)page.getList();
        for(FangwuCollectionView c:list){
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
        FangwuCollectionEntity fangwuCollection = fangwuCollectionService.selectById(id);
        if(fangwuCollection !=null){
            //entity转view
            FangwuCollectionView view = new FangwuCollectionView();
            BeanUtils.copyProperties( fangwuCollection , view );//把实体数据重构到view中

            //级联表
            FangwuEntity fangwu = fangwuService.selectById(fangwuCollection.getFangwuId());
            if(fangwu != null){
                BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setFangwuId(fangwu.getId());
            }
            //级联表
            KehuEntity kehu = kehuService.selectById(fangwuCollection.getKehuId());
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
    public R save(@RequestBody FangwuCollectionEntity fangwuCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangwuCollection:{}",this.getClass().getName(),fangwuCollection.toString());
        Wrapper<FangwuCollectionEntity> queryWrapper = new EntityWrapper<FangwuCollectionEntity>()
            .eq("fangwu_id", fangwuCollection.getFangwuId())
            .eq("kehu_id", fangwuCollection.getKehuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangwuCollectionEntity fangwuCollectionEntity = fangwuCollectionService.selectOne(queryWrapper);
        if(fangwuCollectionEntity==null){
            fangwuCollection.setInsertTime(new Date());
            fangwuCollection.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      fangwuCollection.set
        //  }
            fangwuCollectionService.insert(fangwuCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangwuCollectionEntity fangwuCollection, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangwuCollection:{}",this.getClass().getName(),fangwuCollection.toString());
        //根据字段查询是否有相同数据
        Wrapper<FangwuCollectionEntity> queryWrapper = new EntityWrapper<FangwuCollectionEntity>()
            .notIn("id",fangwuCollection.getId())
            .andNew()
            .eq("fangwu_id", fangwuCollection.getFangwuId())
            .eq("kehu_id", fangwuCollection.getKehuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangwuCollectionEntity fangwuCollectionEntity = fangwuCollectionService.selectOne(queryWrapper);
        if(fangwuCollectionEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      fangwuCollection.set
            //  }
            fangwuCollectionService.updateById(fangwuCollection);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangwuCollectionService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fangwuCollectionService.queryPage(params);

        //字典表数据转换
        List<FangwuCollectionView> list =(List<FangwuCollectionView>)page.getList();
        for(FangwuCollectionView c:list){
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
        FangwuCollectionEntity fangwuCollection = fangwuCollectionService.selectById(id);
            if(fangwuCollection !=null){
                //entity转view
        FangwuCollectionView view = new FangwuCollectionView();
                BeanUtils.copyProperties( fangwuCollection , view );//把实体数据重构到view中

                //级联表
                    FangwuEntity fangwu = fangwuService.selectById(fangwuCollection.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
                //级联表
                    KehuEntity kehu = kehuService.selectById(fangwuCollection.getKehuId());
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
    public R add(@RequestBody FangwuCollectionEntity fangwuCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangwuCollection:{}",this.getClass().getName(),fangwuCollection.toString());
        Wrapper<FangwuCollectionEntity> queryWrapper = new EntityWrapper<FangwuCollectionEntity>()
            .eq("fangwu_id", fangwuCollection.getFangwuId())
            .eq("kehu_id", fangwuCollection.getKehuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    FangwuCollectionEntity fangwuCollectionEntity = fangwuCollectionService.selectOne(queryWrapper);
        if(fangwuCollectionEntity==null){
            fangwuCollection.setInsertTime(new Date());
            fangwuCollection.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      fangwuCollection.set
        //  }
        fangwuCollectionService.insert(fangwuCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

