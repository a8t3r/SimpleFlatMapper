package org.sfm.reflect.meta;

import org.sfm.reflect.ReflectionService;
import org.sfm.reflect.Setter;

import java.lang.reflect.Type;

public class SubPropertyMeta<O, P> extends PropertyMeta<O, P> {
	private final PropertyMeta<O, P> ownerProperty;
	private final PropertyMeta<P, ?> subProperty;
	
	public SubPropertyMeta(ReflectionService reflectService, PropertyMeta<O, P> property, PropertyMeta<P, ?> subProperty) {
		super(property.getName(),  property.getColumn(), reflectService);
		this.ownerProperty = property;
		this.subProperty = subProperty;
	}
	@Override
	protected Setter<O, P> newSetter() {
		return ownerProperty.newSetter();
	}
	@Override
	public Type getType() {
		return ownerProperty.getType();
	}
	public PropertyMeta<O, P> getOwnerProperty() {
		return ownerProperty;
	}
	public PropertyMeta<P, ?> getSubProperty() {
		return subProperty;
	}
	@Override
	protected ClassMeta<P> newClassMeta() {
		return ownerProperty.getClassMeta();
	}
	@Override
	public boolean isSubProperty() {
		return true;
	}
	@Override
	public String getPath() {
		return getOwnerProperty().getPath() + "." + subProperty.getPath();
	}
}
