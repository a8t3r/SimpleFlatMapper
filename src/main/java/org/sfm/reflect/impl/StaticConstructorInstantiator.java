package org.sfm.reflect.impl;

import org.sfm.reflect.Instantiator;

import java.lang.reflect.Constructor;

public final class StaticConstructorInstantiator<S, T> implements Instantiator<S, T> {
	
	private final Constructor<? extends T> constructor;
	private final Object[] args;
	
	public StaticConstructorInstantiator(final Constructor<? extends T> constructor, final Object[] args) {
		this.constructor = constructor;
		this.args = args;
	}

	@Override
	public T newInstance(S s) throws Exception {
		return constructor.newInstance(args);
	}

}
