package org.sfm.jdbc.impl.getter;

import org.sfm.reflect.Getter;
import org.sfm.reflect.primitive.IntGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class IntResultSetGetter implements IntGetter<ResultSet>, Getter<ResultSet, Integer> {

	private final int column;
	
	public IntResultSetGetter(final int column) {
		this.column = column;
	}

	@Override
	public int getInt(final ResultSet target) throws SQLException {
		return target.getInt(column);
	}

	@Override
	public Integer get(final ResultSet target) throws Exception {
		final int i = getInt(target);
		if (i == 0 && target.wasNull()) {
			return null;
		} else {
			return Integer.valueOf(i);
		}
	}
}
