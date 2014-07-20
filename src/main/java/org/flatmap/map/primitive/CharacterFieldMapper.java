package org.flatmap.map.primitive;

import org.flatmap.map.FieldMapper;
import org.flatmap.reflect.primitive.CharacterGetter;
import org.flatmap.reflect.primitive.CharacterSetter;

public class CharacterFieldMapper<S, T> implements FieldMapper<S, T> {

	private final CharacterGetter<S> getter;
	private final CharacterSetter<T> setter;
	
	
 	public CharacterFieldMapper(CharacterGetter<S> getter, CharacterSetter<T> setter) {
		this.getter = getter;
		this.setter = setter;
	}


	@Override
	public void map(S source, T target) throws Exception {
		setter.setCharacter(target, getter.getCharacter(source));
	}

}