package org.sfm.reflect.primitive;

import java.lang.reflect.Field;

public final class DoubleFieldSetter<T> implements DoubleSetter<T> {

	private final Field field;
	
	public DoubleFieldSetter(final Field field) {
		this.field = field;
	}

	@Override
	public void setDouble(final T target, final double value) throws IllegalArgumentException, IllegalAccessException {
		field.setDouble(target, value);
	}

}
