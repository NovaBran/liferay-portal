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

package com.liferay.document.library.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.document.library.model.DLFileVersionPreview;
import com.liferay.document.library.model.DLFileVersionPreviewModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DLFileVersionPreview service. Represents a row in the &quot;DLFileVersionPreview&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DLFileVersionPreviewModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DLFileVersionPreviewImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileVersionPreviewImpl
 * @generated
 */
@ProviderType
public class DLFileVersionPreviewModelImpl
	extends BaseModelImpl<DLFileVersionPreview>
	implements DLFileVersionPreviewModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dl file version preview model instance should use the <code>DLFileVersionPreview</code> interface instead.
	 */
	public static final String TABLE_NAME = "DLFileVersionPreview";

	public static final Object[][] TABLE_COLUMNS = {
		{"dlFileVersionPreviewId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"fileEntryId", Types.BIGINT}, {"fileVersionId", Types.BIGINT},
		{"previewStatus", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("dlFileVersionPreviewId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("previewStatus", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DLFileVersionPreview (dlFileVersionPreviewId LONG not null primary key,groupId LONG,fileEntryId LONG,fileVersionId LONG,previewStatus INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table DLFileVersionPreview";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dlFileVersionPreview.dlFileVersionPreviewId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DLFileVersionPreview.dlFileVersionPreviewId DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long FILEENTRYID_COLUMN_BITMASK = 1L;

	public static final long FILEVERSIONID_COLUMN_BITMASK = 2L;

	public static final long PREVIEWSTATUS_COLUMN_BITMASK = 4L;

	public static final long DLFILEVERSIONPREVIEWID_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public DLFileVersionPreviewModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dlFileVersionPreviewId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDlFileVersionPreviewId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dlFileVersionPreviewId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DLFileVersionPreview.class;
	}

	@Override
	public String getModelClassName() {
		return DLFileVersionPreview.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DLFileVersionPreview, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DLFileVersionPreview, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DLFileVersionPreview, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DLFileVersionPreview)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DLFileVersionPreview, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DLFileVersionPreview, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DLFileVersionPreview)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DLFileVersionPreview, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DLFileVersionPreview, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DLFileVersionPreview, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DLFileVersionPreview, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DLFileVersionPreview, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DLFileVersionPreview, Object>>();
		Map<String, BiConsumer<DLFileVersionPreview, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<DLFileVersionPreview, ?>>();

		attributeGetterFunctions.put(
			"dlFileVersionPreviewId",
			DLFileVersionPreview::getDlFileVersionPreviewId);
		attributeSetterBiConsumers.put(
			"dlFileVersionPreviewId",
			(BiConsumer<DLFileVersionPreview, Long>)
				DLFileVersionPreview::setDlFileVersionPreviewId);
		attributeGetterFunctions.put(
			"groupId", DLFileVersionPreview::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DLFileVersionPreview, Long>)
				DLFileVersionPreview::setGroupId);
		attributeGetterFunctions.put(
			"fileEntryId", DLFileVersionPreview::getFileEntryId);
		attributeSetterBiConsumers.put(
			"fileEntryId",
			(BiConsumer<DLFileVersionPreview, Long>)
				DLFileVersionPreview::setFileEntryId);
		attributeGetterFunctions.put(
			"fileVersionId", DLFileVersionPreview::getFileVersionId);
		attributeSetterBiConsumers.put(
			"fileVersionId",
			(BiConsumer<DLFileVersionPreview, Long>)
				DLFileVersionPreview::setFileVersionId);
		attributeGetterFunctions.put(
			"previewStatus", DLFileVersionPreview::getPreviewStatus);
		attributeSetterBiConsumers.put(
			"previewStatus",
			(BiConsumer<DLFileVersionPreview, Integer>)
				DLFileVersionPreview::setPreviewStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getDlFileVersionPreviewId() {
		return _dlFileVersionPreviewId;
	}

	@Override
	public void setDlFileVersionPreviewId(long dlFileVersionPreviewId) {
		_columnBitmask = -1L;

		_dlFileVersionPreviewId = dlFileVersionPreviewId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_columnBitmask |= FILEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalFileEntryId) {
			_setOriginalFileEntryId = true;

			_originalFileEntryId = _fileEntryId;
		}

		_fileEntryId = fileEntryId;
	}

	public long getOriginalFileEntryId() {
		return _originalFileEntryId;
	}

	@Override
	public long getFileVersionId() {
		return _fileVersionId;
	}

	@Override
	public void setFileVersionId(long fileVersionId) {
		_columnBitmask |= FILEVERSIONID_COLUMN_BITMASK;

		if (!_setOriginalFileVersionId) {
			_setOriginalFileVersionId = true;

			_originalFileVersionId = _fileVersionId;
		}

		_fileVersionId = fileVersionId;
	}

	public long getOriginalFileVersionId() {
		return _originalFileVersionId;
	}

	@Override
	public int getPreviewStatus() {
		return _previewStatus;
	}

	@Override
	public void setPreviewStatus(int previewStatus) {
		_columnBitmask |= PREVIEWSTATUS_COLUMN_BITMASK;

		if (!_setOriginalPreviewStatus) {
			_setOriginalPreviewStatus = true;

			_originalPreviewStatus = _previewStatus;
		}

		_previewStatus = previewStatus;
	}

	public int getOriginalPreviewStatus() {
		return _originalPreviewStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, DLFileVersionPreview.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DLFileVersionPreview toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DLFileVersionPreview)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DLFileVersionPreviewImpl dlFileVersionPreviewImpl =
			new DLFileVersionPreviewImpl();

		dlFileVersionPreviewImpl.setDlFileVersionPreviewId(
			getDlFileVersionPreviewId());
		dlFileVersionPreviewImpl.setGroupId(getGroupId());
		dlFileVersionPreviewImpl.setFileEntryId(getFileEntryId());
		dlFileVersionPreviewImpl.setFileVersionId(getFileVersionId());
		dlFileVersionPreviewImpl.setPreviewStatus(getPreviewStatus());

		dlFileVersionPreviewImpl.resetOriginalValues();

		return dlFileVersionPreviewImpl;
	}

	@Override
	public int compareTo(DLFileVersionPreview dlFileVersionPreview) {
		int value = 0;

		if (getDlFileVersionPreviewId() <
				dlFileVersionPreview.getDlFileVersionPreviewId()) {

			value = -1;
		}
		else if (getDlFileVersionPreviewId() >
					dlFileVersionPreview.getDlFileVersionPreviewId()) {

			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DLFileVersionPreview)) {
			return false;
		}

		DLFileVersionPreview dlFileVersionPreview = (DLFileVersionPreview)obj;

		long primaryKey = dlFileVersionPreview.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		DLFileVersionPreviewModelImpl dlFileVersionPreviewModelImpl = this;

		dlFileVersionPreviewModelImpl._originalFileEntryId =
			dlFileVersionPreviewModelImpl._fileEntryId;

		dlFileVersionPreviewModelImpl._setOriginalFileEntryId = false;

		dlFileVersionPreviewModelImpl._originalFileVersionId =
			dlFileVersionPreviewModelImpl._fileVersionId;

		dlFileVersionPreviewModelImpl._setOriginalFileVersionId = false;

		dlFileVersionPreviewModelImpl._originalPreviewStatus =
			dlFileVersionPreviewModelImpl._previewStatus;

		dlFileVersionPreviewModelImpl._setOriginalPreviewStatus = false;

		dlFileVersionPreviewModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DLFileVersionPreview> toCacheModel() {
		DLFileVersionPreviewCacheModel dlFileVersionPreviewCacheModel =
			new DLFileVersionPreviewCacheModel();

		dlFileVersionPreviewCacheModel.dlFileVersionPreviewId =
			getDlFileVersionPreviewId();

		dlFileVersionPreviewCacheModel.groupId = getGroupId();

		dlFileVersionPreviewCacheModel.fileEntryId = getFileEntryId();

		dlFileVersionPreviewCacheModel.fileVersionId = getFileVersionId();

		dlFileVersionPreviewCacheModel.previewStatus = getPreviewStatus();

		return dlFileVersionPreviewCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DLFileVersionPreview, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DLFileVersionPreview, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DLFileVersionPreview, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((DLFileVersionPreview)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<DLFileVersionPreview, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DLFileVersionPreview, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DLFileVersionPreview, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((DLFileVersionPreview)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		DLFileVersionPreview.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		DLFileVersionPreview.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _dlFileVersionPreviewId;
	private long _groupId;
	private long _fileEntryId;
	private long _originalFileEntryId;
	private boolean _setOriginalFileEntryId;
	private long _fileVersionId;
	private long _originalFileVersionId;
	private boolean _setOriginalFileVersionId;
	private int _previewStatus;
	private int _originalPreviewStatus;
	private boolean _setOriginalPreviewStatus;
	private long _columnBitmask;
	private DLFileVersionPreview _escapedModel;

}