package org.sfm.jdbc.impl.getter;

import org.sfm.reflect.Getter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public final class TimeResultSetGetter implements Getter<ResultSet, Time> {
	private final int column;
	
	public TimeResultSetGetter(final int column) {
		this.column = column;
	}

	public Time get(final ResultSet target) throws SQLException {
		return target.getTime(column);
	}

}
