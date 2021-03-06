package org.sfm.jdbc.impl.getter;

import org.sfm.reflect.Getter;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UrlResultSetGetter implements
		Getter<java.sql.ResultSet, URL> {
	private final int column;
	
	public UrlResultSetGetter(final int column) {
		this.column = column;
	}

	public URL get(final ResultSet target) throws SQLException {
		return target.getURL(column);
	}
}
