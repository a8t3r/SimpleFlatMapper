package org.sfm.jdbc.impl.getter;

import org.sfm.reflect.Getter;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class InputStreamResultSetGetter implements Getter<ResultSet, InputStream> {
	private final int column;
	
	public InputStreamResultSetGetter(final int column) {
		this.column = column;
	}

	public InputStream get(final ResultSet target) throws SQLException {
		return target.getBinaryStream(column);
	}

}
