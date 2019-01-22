package com.artisan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}
