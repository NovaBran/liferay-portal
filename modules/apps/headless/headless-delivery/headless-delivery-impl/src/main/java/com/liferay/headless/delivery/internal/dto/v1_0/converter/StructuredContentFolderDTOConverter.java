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

package com.liferay.headless.delivery.internal.dto.v1_0.converter;

import com.liferay.headless.common.spi.util.CustomFieldsUtil;
import com.liferay.headless.delivery.dto.v1_0.StructuredContentFolder;
import com.liferay.headless.delivery.dto.v1_0.converter.DTOConverter;
import com.liferay.headless.delivery.dto.v1_0.converter.DTOConverterContext;
import com.liferay.headless.delivery.internal.dto.v1_0.util.CreatorUtil;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleService;
import com.liferay.journal.service.JournalFolderService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rubén Pulido
 * @author Víctor Galán
 */
@Component(
	property = "asset.entry.class.name=com.liferay.journal.model.JournalFolder",
	service = {DTOConverter.class, StructuredContentFolderDTOConverter.class}
)
public class StructuredContentFolderDTOConverter implements DTOConverter {

	@Override
	public String getContentType() {
		return StructuredContentFolder.class.getSimpleName();
	}

	@Override
	public StructuredContentFolder toDTO(
			DTOConverterContext dtoConverterContext)
		throws Exception {

		JournalFolder journalFolder = _journalFolderService.getFolder(
			dtoConverterContext.getResourcePrimKey());

		return new StructuredContentFolder() {
			{
				creator = CreatorUtil.toCreator(
					_portal,
					_userLocalService.getUser(journalFolder.getUserId()));
				customFields = CustomFieldsUtil.toCustomFields(
					journalFolder.getCompanyId(), journalFolder.getFolderId(),
					JournalFolder.class, dtoConverterContext.getLocale());
				dateCreated = journalFolder.getCreateDate();
				dateModified = journalFolder.getModifiedDate();
				description = journalFolder.getDescription();
				id = journalFolder.getFolderId();
				name = journalFolder.getName();
				numberOfStructuredContentFolders =
					_journalFolderService.getFoldersCount(
						journalFolder.getGroupId(),
						journalFolder.getFolderId());
				numberOfStructuredContents =
					_journalArticleService.getArticlesCount(
						journalFolder.getGroupId(), journalFolder.getFolderId(),
						WorkflowConstants.STATUS_APPROVED);
				siteId = journalFolder.getGroupId();
			}
		};
	}

	@Reference
	private JournalArticleService _journalArticleService;

	@Reference
	private JournalFolderService _journalFolderService;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;

}