package org.sfm.jdbc.impl.getter;

import org.sfm.reflect.Getter;
import org.sfm.reflect.primitive.ShortGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ShortResultSetGetter implements ShortGetter<ResultSet>, Getter<ResultSet, Short> {

	private final int column;
	
	public ShortResultSetGetter(final int column) {
		this.column = column;
	}

	@Override
	public short getShort(final ResultSet target) throws SQLException {
		return target.getShort(column);
	}

	@Override
	public Short get(final ResultSet target) throws Exception {
		final short s = getShort(target);
		if (s == 0 && target.wasNull()) {
			return null;
		} else {
			return Short.valueOf(s);
		}
	}
}
