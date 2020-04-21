package com.artisan.controller;

import java.util.List;

import com.artisan.exception.MyCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artisan.model.Artisan;
import com.artisan.result.CodeMsg;
import com.artisan.result.Result;
import com.artisan.service.ArtisanService;

@RestController
public class ArtisanController {
	
	@Autowired
	private ArtisanService artisanService;
	
	@GetMapping("/test")
	public String test() {
		return "artisan test";
	}
	
	// 正常情况
	@GetMapping("/artisans")
	public Result<List<Artisan>> selectAllArtisan() {
		return Result.success(artisanService.getArtisanList());
	}
	
	
	// 模拟异常情况
	@GetMapping("/artisansError")
	public Result<List<Artisan>> selectAllArtisanError() {
		return Result.error(CodeMsg.SERVER_ERROR);
	}

	// 模拟异常情况
	@GetMapping("/artisansError2")
	public Result<List<Artisan>> selectAllArtisanErrorWithAop() {
		return Result.success(artisanService.getArtisanErrorList());
	}

	// 模拟异常情况
	@GetMapping("/artisansError3")
	public Result<List<Artisan>> selectAllArtisanErrorWithAop3() {
		if(1 == 1){
			throw new MyCustomException(HttpStatus.INTERNAL_SERVER_ERROR.value(),"遇到了傻子");
		}
		return Result.success(artisanService.getArtisanErrorList());
	}
	
}
