/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.portal.search.admin.web.internal.display.context;

import com.liferay.portal.search.engine.SearchEngineInformation;

/**
 * @author Adam Brandizzi
 */
public class IndexActionsDisplayBuilder {

	public IndexActionsDisplayContext build() {
		IndexActionsDisplayContext indexActionsDisplayContext =
			new IndexActionsDisplayContext();

		if (_searchEngineInformation != null) {
			indexActionsDisplayContext.setClientVersionString(
				_searchEngineInformation.getClientVersionString());
			indexActionsDisplayContext.setNodesString(
				_searchEngineInformation.getNodesString());
			indexActionsDisplayContext.setVendorString(
				_searchEngineInformation.getVendorString());
		}
		else {
			indexActionsDisplayContext.setMissingSearchEngine(true);
		}

		return indexActionsDisplayContext;
	}

	public void setSearchEngineInformation(
		SearchEngineInformation searchEngineInformation) {

		_searchEngineInformation = searchEngineInformation;
	}

	private SearchEngineInformation _searchEngineInformation;

}