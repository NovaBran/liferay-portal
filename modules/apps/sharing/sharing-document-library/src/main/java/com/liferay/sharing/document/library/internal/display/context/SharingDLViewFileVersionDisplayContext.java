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

package com.liferay.sharing.document.library.internal.display.context;

import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.document.library.display.context.BaseDLViewFileVersionDisplayContext;
import com.liferay.document.library.display.context.DLViewFileVersionDisplayContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.servlet.taglib.ui.Menu;
import com.liferay.portal.kernel.servlet.taglib.ui.MenuItem;
import com.liferay.portal.kernel.servlet.taglib.ui.ToolbarItem;
import com.liferay.portal.kernel.settings.PortletInstanceSettingsLocator;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.settings.SettingsFactoryUtil;
import com.liferay.portal.kernel.settings.TypedSettings;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sharing.document.library.internal.display.context.logic.SharingDLDisplayContextHelper;

import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sergio González
 */
public class SharingDLViewFileVersionDisplayContext
	extends BaseDLViewFileVersionDisplayContext {

	public SharingDLViewFileVersionDisplayContext(
		DLViewFileVersionDisplayContext parentDLDisplayContext,
		HttpServletRequest request, HttpServletResponse response,
		FileVersion fileVersion, ResourceBundle resourceBundle,
		SharingDLDisplayContextHelper sharingDLDisplayContextHelper) {

		super(_UUID, parentDLDisplayContext, request, response, fileVersion);

		_resourceBundle = resourceBundle;
		_sharingDLDisplayContextHelper = sharingDLDisplayContextHelper;
		_themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	@Override
	public Menu getMenu() throws PortalException {
		Menu menu = super.getMenu();

		if (!_isShowShareAction()) {
			return menu;
		}

		List<MenuItem> menuItems = menu.getMenuItems();

		menuItems.add(
			_sharingDLDisplayContextHelper.
				getJavacriptEditWithImageEditorMenuItem(_resourceBundle));

		return menu;
	}

	@Override
	public List<ToolbarItem> getToolbarItems() throws PortalException {
		List<ToolbarItem> toolbarItems = super.getToolbarItems();

		if (!_isShowShareAction()) {
			return toolbarItems;
		}

		toolbarItems.add(
			_sharingDLDisplayContextHelper.
				getJavacriptEditWithImageEditorToolbarItem(_resourceBundle));

		return toolbarItems;
	}

	private boolean _isShowActions() throws PortalException {
		PortletDisplay portletDisplay = _themeDisplay.getPortletDisplay();

		String portletName = portletDisplay.getPortletName();

		if (portletName.equals(DLPortletKeys.DOCUMENT_LIBRARY_ADMIN)) {
			return true;
		}

		Settings settings = SettingsFactoryUtil.getSettings(
			new PortletInstanceSettingsLocator(
				_themeDisplay.getLayout(), portletDisplay.getId()));

		TypedSettings typedSettings = new TypedSettings(settings);

		return typedSettings.getBooleanValue("showActions");
	}

	private boolean _isShowShareAction() throws PortalException {
		if (_showImageEditorAction != null) {
			return _showImageEditorAction;
		}

		if (!_themeDisplay.isSignedIn() || !_isShowActions()) {
			_showImageEditorAction = false;
		}
		else {
			_showImageEditorAction = true;
		}

		return _showImageEditorAction;
	}

	private static final UUID _UUID = UUID.fromString(
		"6d7d30de-01fa-49db-a422-d78748aa03a7");

	private final ResourceBundle _resourceBundle;
	private final SharingDLDisplayContextHelper _sharingDLDisplayContextHelper;
	private Boolean _showImageEditorAction;
	private final ThemeDisplay _themeDisplay;

}