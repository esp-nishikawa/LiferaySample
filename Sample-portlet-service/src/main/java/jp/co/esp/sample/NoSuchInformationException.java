/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package jp.co.esp.sample;

import com.liferay.portal.NoSuchModelException;

/**
 * @author SampleDeveloper
 */
public class NoSuchInformationException extends NoSuchModelException {

	public NoSuchInformationException() {
		super();
	}

	public NoSuchInformationException(String msg) {
		super(msg);
	}

	public NoSuchInformationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchInformationException(Throwable cause) {
		super(cause);
	}

}