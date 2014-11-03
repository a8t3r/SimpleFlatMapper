package org.sfm.map.impl;

import org.sfm.map.FieldMapperErrorHandler;
import org.sfm.map.MapperBuilderErrorHandler;
import org.sfm.reflect.Setter;

public interface FieldMapperFactory<S, K> {
	<T, P> FieldMapper<S, T> newFieldMapper(Setter<T, P> setter, K key, FieldMapperErrorHandler<K> errorHandler, MapperBuilderErrorHandler mapperErrorHandler);
}