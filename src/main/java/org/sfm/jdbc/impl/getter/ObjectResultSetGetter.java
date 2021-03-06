package org.sfm.jdbc.impl.getter;

import org.sfm.reflect.Getter;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ObjectResultSetGetter implements Getter<ResultSet, Object> {
	private final int column;

	public ObjectResultSetGetter(final int column) {
		this.column = column;
	}

	public Object get(final ResultSet target) throws SQLException {
		return target.getObject(column);
	}
}
