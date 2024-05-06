package cn.edu.bjut.studentsearchpost.controller;

import cn.edu.bjut.entity.post.PostAndEnterprise;
import cn.edu.bjut.entity.post.PostFilter;
import cn.edu.bjut.studentsearchpost.mapper.FilterByEnterprise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class StudentFilterPostByEnterprise {
    @Autowired
    private FilterByEnterprise filterPost;
    @PostMapping("/sendFilterEnterprise")
    public List<PostAndEnterprise> getPostFilter(@RequestBody PostFilter postFilter){
        System.out.println(postFilter);
        List<PostAndEnterprise> posts = null;
        //判断条件个数
        if (!Objects.equals(postFilter.getRegion(), "") &&Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-只有地域条件时
            System.out.println(postFilter.getRegion());
            posts = filterPost.getPostByFilter(postFilter.getRegion(), postFilter.getInput());
        }
        if (!Objects.equals(postFilter.getMonth(), "") &&Objects.equals(postFilter.getRegion(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-只有月份条件时
            System.out.println(postFilter.getMonth());
            posts=filterPost.getPostByFilterMonth(postFilter.getMonth(),postFilter.getInput());
        }
        if (!Objects.equals(postFilter.getSalary(), "") && Objects.equals(postFilter.getRegion(), "") && Objects.equals(postFilter.getMonth(), "")) {
            //岗位信息-只有薪资条件时
            posts = filterPost.getPostByFilterSalary(postFilter.getSalary(), postFilter.getInput());
        }
        if (!Objects.equals(postFilter.getRegion(), "") &&!Objects.equals(postFilter.getMonth(), "")&& Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-地域+月份
            posts=filterPost.getPostByFilterRegionMonth(postFilter.getInput(),postFilter.getRegion(),postFilter.getMonth());
        }
        if (!Objects.equals(postFilter.getRegion(), "") &&Objects.equals(postFilter.getMonth(), "")&&!Objects.equals(postFilter.getSalary(), "")){
            //岗位信息-地域+薪资
            posts=filterPost.getPostByFilterRegionSalary(postFilter.getInput(),postFilter.getRegion(),postFilter.getSalary());
        }
        if(!Objects.equals(postFilter.getMonth(), "")&& !Objects.equals(postFilter.getSalary(), "")&& Objects.equals(postFilter.getRegion(), "")){
            //岗位信息-月份+薪资
            posts=filterPost.getPostByFilterMonthSalary(postFilter.getInput(),postFilter.getMonth(),postFilter.getSalary());
        }

        if(!Objects.equals(postFilter.getMonth(), "")&& !Objects.equals(postFilter.getSalary(), "")&& !Objects.equals(postFilter.getRegion(), "")){
            //筛选条件全选
            posts=filterPost.getPostByFilterAll(postFilter.getInput(),postFilter.getRegion(),postFilter.getMonth(),postFilter.getSalary());
        }
        return posts;
    }
    @PostMapping("/sendOnlyEnterprise")
    public List<PostAndEnterprise> getPostOnlyEnterprise(@RequestBody PostFilter postFilter) {

        List<PostAndEnterprise> posts = filterPost.getPostOnlyEnterprise(postFilter.getInput());
        return posts;


    }

    }
