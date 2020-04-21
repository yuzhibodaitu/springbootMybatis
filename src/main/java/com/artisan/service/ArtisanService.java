package com.artisan.service;

import java.util.List;

import com.artisan.model.Artisan;

public interface ArtisanService {
	
	List<Artisan> getArtisanList();

	List<Artisan> getArtisanErrorList();

}
