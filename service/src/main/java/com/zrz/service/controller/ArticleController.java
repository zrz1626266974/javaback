package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrz.common.R;
import com.zrz.service.entity.Article;
import com.zrz.service.entity.view.VActivity;
import com.zrz.service.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/getArticleList")
    public R getArticleList() {
        List<Article> list;
        list = articleService.list();
        return R.ok().data("list",list);
    }

    @GetMapping("/getArticleById/{arid}")
    public R getArticleById(@PathVariable int arid){
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("arid",arid);
        Article one = articleService.getOne(wrapper);
        if(one != null){
            return R.ok().data("one",one);
        }
        else {
            return R.error().message("文章不存在");
        }
    }

    // ------ 分页获取文章列表 (关键词搜索)-------
    @GetMapping("/getArticleByPage/{cur}/{limit}")
    public R getArticleByPage(@PathVariable long cur,
                              @PathVariable long limit,
                              @RequestParam String keyword){
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.like("article_title", keyword);
        Page<Article> page = new Page<>(cur, limit);
        articleService.page(page,wrapper);
        long total = page.getTotal();
        List<Article> list = page.getRecords();
        return R.ok().data("total", total).data("list",list);
    }

    // ---------（分页）获取用户作者文章列表 (同时关键词搜索） -----
    @GetMapping("/getUserArticleByPage/{id}/{cur}/{limit}")
    public R getUserArticleByPage(@PathVariable String id,
                                  @PathVariable long cur,
                                  @PathVariable long limit,
                                  @RequestParam String keyword){
        Page<Article> page = new Page<>(cur, limit);
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",id);
        wrapper.like("article_title", keyword);
        articleService.page(page, wrapper);
        long total = page.getTotal();
        List<Article> list = page.getRecords();
        return R.ok().data("total", total).data("list",list);
    }

//    // 根据作者获取文章列表
//    @GetMapping("/getArticleByUser/{id}")
//    public R getArticleByUser(@PathVariable String id){
//        QueryWrapper<Article> wrapper = new QueryWrapper<>();
//        wrapper.eq("id",id);
//        List<Article> list;
//        list = articleService.list(wrapper);
//        if(list != null){
//            return R.ok().data("list",list);
//        }
//        else{
//            return R.error().message("用户无文章");
//        }
//    }

    @PostMapping("/addArticle")
    public R addArticle(@RequestBody Article one){
        boolean flag = false;
        flag = articleService.save(one);
        if(flag){
            return R.ok().message("文章添加成功");
        }
        else{
            return R.error().message("文章添加失败");
        }
    }

    @PostMapping("/delArticle")
    public R delArticle(@RequestBody Article one) {
        boolean flag = false;
        UpdateWrapper<Article> wrapper = new UpdateWrapper<>();
        wrapper.eq("arid", one.getArid());
        flag = articleService.remove(wrapper);
        if(flag){
            return R.ok().message("文章删除成功");
        }
        else{
            return R.error().message("文章删除失败");
        }
    }
}
