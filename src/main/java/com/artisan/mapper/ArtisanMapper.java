package com.artisan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artisan.model.Artisan;
/**
 * 
 * @author yangshangwei
 *	
 * 增加@Mapper这个注解之后，Spring 启动时会自动扫描该接口，这样就可以在需要使用时直接注入 Mapper 了
 */

@Mapper
public interface ArtisanMapper {
	
	/**
	 *  查询全部数据
	 */
	List<Artisan> selectArtisan();
	
}
