package com.artisan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artisan.mapper.ArtisanMapper;
import com.artisan.model.Artisan;
import com.artisan.service.ArtisanService;

@Service
public class ArtisanServiceImpl implements ArtisanService {
	
	@Autowired
	private ArtisanMapper artisanMapper;
	
	@Override
	public List<Artisan> getArtisanList() {
		return artisanMapper.selectArtisan();
	}

	@Override
	public List<Artisan> getArtisanErrorList() {
		return artisanMapper.selectErrorArtisan();
	}

}
