package cn.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@RequestMapping("/{path}")
//	restfull风格,如果有精确的匹配,则会有精确匹配.
	public String path(@PathVariable(value="path")String path){
		System.out.println("走了restfull!"+path);
		return path;
	}
}
