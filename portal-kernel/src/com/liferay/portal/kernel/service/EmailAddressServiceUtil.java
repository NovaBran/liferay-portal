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

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service utility for EmailAddress. This utility wraps
 * <code>com.liferay.portal.service.impl.EmailAddressServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EmailAddressService
 * @generated
 */
@ProviderType
public class EmailAddressServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.EmailAddressServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.EmailAddress addEmailAddress(
			String className, long classPK, String address, long typeId,
			boolean primary, ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addEmailAddress(
			className, classPK, address, typeId, primary, serviceContext);
	}

	public static void deleteEmailAddress(long emailAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteEmailAddress(emailAddressId);
	}

	/**
	 * Returns the email address with the primary key.
	 *
	 * @param emailAddressId the primary key of the email address
	 * @return the email address with the primary key, or <code>null</code> if
	 an email address with the primary key could not be found or if
	 the user did not have permission to view the email address
	 */
	public static com.liferay.portal.kernel.model.EmailAddress
			fetchEmailAddress(long emailAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchEmailAddress(emailAddressId);
	}

	public static com.liferay.portal.kernel.model.EmailAddress getEmailAddress(
			long emailAddressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmailAddress(emailAddressId);
	}

	public static java.util.List<com.liferay.portal.kernel.model.EmailAddress>
			getEmailAddresses(String className, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEmailAddresses(className, classPK);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.EmailAddress
			updateEmailAddress(
				long emailAddressId, String address, long typeId,
				boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateEmailAddress(
			emailAddressId, address, typeId, primary);
	}

	public static EmailAddressService getService() {
		if (_service == null) {
			_service = (EmailAddressService)PortalBeanLocatorUtil.locate(
				EmailAddressService.class.getName());
		}

		return _service;
	}

	private static EmailAddressService _service;

}