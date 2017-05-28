package com.cnv.cms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cnv.cms.model.HostHolder;
import com.cnv.cms.service.ArticleService;
import com.cnv.cms.service.ChannelService;
import com.cnv.cms.service.PVService;

@Controller
//@RequestMapping("/")
public class UserResourcesController {
	
	private final Logger logger = LoggerFactory.getLogger(UserResourcesController.class);
	@Autowired
	private HostHolder hostHolder;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private ArticleService articleService;
	
	
	
	@RequestMapping(value="/user/{file}.html",method=RequestMethod.GET)
	public String userInterceptro(@PathVariable("file") String file){
		return "user/"+file;
		
	}
	@RequestMapping(value="/user/home.html",method=RequestMethod.GET)
	public String userhome(Model model,HttpServletRequest request){
		model.addAllAttributes(this.getCommontInfo(request));
		return "user/home";
	}
	
	@RequestMapping(value="/user/article_add.html",method=RequestMethod.GET)
	public String userArticlAdd(Model model,HttpServletRequest request){
		model.addAllAttributes(this.getCommontInfo(request));
		model.addAttribute("topChannels", channelService.selectTopChannels());
		return "user/article_add";
	}
	@RequestMapping(value="/user/mynews.html",method=RequestMethod.GET)
	public String usernews(Model model,HttpServletRequest request){
		model.addAllAttributes(this.getCommontInfo(request));
		model.addAttribute("articles", articleService.selectByUserId(hostHolder.getUserId()));
		return "user/mynews";
	}
	@RequestMapping(value="/user/innermsg.html",method=RequestMethod.GET)
	public String innermsg(Model model,HttpServletRequest request){
		model.addAllAttributes(this.getCommontInfo(request));
		return "user/innermsg";
	}
    public  Map<String, Object> getCommontInfo(HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("user", hostHolder.getUserName());
    	map.put("userid", hostHolder.getUserId());
    	map.put("channels", channelService.selectAll());
    	map.put("contextPath", request.getContextPath());
    	return map;
    }
}