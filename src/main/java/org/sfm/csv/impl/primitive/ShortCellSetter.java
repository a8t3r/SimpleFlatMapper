package org.sfm.csv.impl.primitive;

import org.sfm.csv.impl.CellSetter;
import org.sfm.csv.impl.ParsingContext;
import org.sfm.csv.impl.cellreader.ShortCellValueReader;
import org.sfm.reflect.primitive.ShortSetter;

public class ShortCellSetter<T> implements CellSetter<T> {

	private final ShortSetter<T> setter;
	private final ShortCellValueReader reader;

	public ShortCellSetter(ShortSetter<T> setter, ShortCellValueReader reader) {
		this.setter = setter;
		this.reader = reader;
	}
	
	@Override
	public void set(T target, char[] chars, int offset, int length, ParsingContext parsingContext)
			throws Exception {
		setter.setShort(target, reader.readShort(chars, offset, length, parsingContext));
	}	
}
