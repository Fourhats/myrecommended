package com.myrecommended.services.utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

import com.myrecommended.models.Page;

public class MapperUtil {
	public static <T, U> List<U> map(final Mapper mapper, final List<T> source, final Class<U> destType) {
		final List<U> destination = new ArrayList<U>();
		for(T item : source){
			destination.add(mapper.map(item, destType));
		}
		return destination;
	}
	
	public static <T, U> Page<U> map(final Mapper mapper, final Page<T> source, final Class<U> destType) {
		final List<U> elements = map(mapper, source.getElements(), destType);
		return new Page<U>(elements, source.getPageIndex(), source.getPageSize(), source.getTotalItems());
	}
	
	public static <T, U> U map(final Mapper mapper, final T source, final Class<U> destType) {
		return mapper.map(source, destType);
	}
}