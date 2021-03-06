package org.sfm.jdbc.impl.getter;

import org.sfm.reflect.Getter;

import java.math.BigInteger;
import java.sql.ResultSet;

public final class BigIntegerResultSetGetter implements Getter<ResultSet, BigInteger> {

	private final int column;

	public BigIntegerResultSetGetter(final int column) {
		this.column = column;
	}

	@Override
	public BigInteger get(final ResultSet target) throws Exception {
		return new BigInteger(target.getString(column));
	}
}
