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

package com.liferay.bulk.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
@GraphQLName("BulkAssetEntryUpdateCategoriesAction")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "BulkAssetEntryUpdateCategoriesAction")
public class BulkAssetEntryUpdateCategoriesAction {

	public Boolean getAppend() {
		return append;
	}

	public void setAppend(Boolean append) {
		this.append = append;
	}

	@JsonIgnore
	public void setAppend(
		UnsafeSupplier<Boolean, Exception> appendUnsafeSupplier) {

		try {
			append = appendUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean append;

	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	@JsonIgnore
	public void setFolderId(
		UnsafeSupplier<Long, Exception> folderIdUnsafeSupplier) {

		try {
			folderId = folderIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long folderId;

	public Long getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(Long repositoryId) {
		this.repositoryId = repositoryId;
	}

	@JsonIgnore
	public void setRepositoryId(
		UnsafeSupplier<Long, Exception> repositoryIdUnsafeSupplier) {

		try {
			repositoryId = repositoryIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long repositoryId;

	public Boolean getSelectAll() {
		return selectAll;
	}

	public void setSelectAll(Boolean selectAll) {
		this.selectAll = selectAll;
	}

	@JsonIgnore
	public void setSelectAll(
		UnsafeSupplier<Boolean, Exception> selectAllUnsafeSupplier) {

		try {
			selectAll = selectAllUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean selectAll;

	public String[] getSelection() {
		return selection;
	}

	public void setSelection(String[] selection) {
		this.selection = selection;
	}

	@JsonIgnore
	public void setSelection(
		UnsafeSupplier<String[], Exception> selectionUnsafeSupplier) {

		try {
			selection = selectionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] selection;

	public Long[] getToAddCategoryIds() {
		return toAddCategoryIds;
	}

	public void setToAddCategoryIds(Long[] toAddCategoryIds) {
		this.toAddCategoryIds = toAddCategoryIds;
	}

	@JsonIgnore
	public void setToAddCategoryIds(
		UnsafeSupplier<Long[], Exception> toAddCategoryIdsUnsafeSupplier) {

		try {
			toAddCategoryIds = toAddCategoryIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long[] toAddCategoryIds;

	public Long[] getToRemoveCategoryIds() {
		return toRemoveCategoryIds;
	}

	public void setToRemoveCategoryIds(Long[] toRemoveCategoryIds) {
		this.toRemoveCategoryIds = toRemoveCategoryIds;
	}

	@JsonIgnore
	public void setToRemoveCategoryIds(
		UnsafeSupplier<Long[], Exception> toRemoveCategoryIdsUnsafeSupplier) {

		try {
			toRemoveCategoryIds = toRemoveCategoryIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long[] toRemoveCategoryIds;

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		sb.append("\"append\": ");

		sb.append(append);
		sb.append(", ");

		sb.append("\"folderId\": ");

		sb.append(folderId);
		sb.append(", ");

		sb.append("\"repositoryId\": ");

		sb.append(repositoryId);
		sb.append(", ");

		sb.append("\"selectAll\": ");

		sb.append(selectAll);
		sb.append(", ");

		sb.append("\"selection\": ");

		if (selection == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < selection.length; i++) {
				sb.append("\"");
				sb.append(selection[i]);
				sb.append("\"");

				if ((i + 1) < selection.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append(", ");

		sb.append("\"toAddCategoryIds\": ");

		if (toAddCategoryIds == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < toAddCategoryIds.length; i++) {
				sb.append(toAddCategoryIds[i]);

				if ((i + 1) < toAddCategoryIds.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append(", ");

		sb.append("\"toRemoveCategoryIds\": ");

		if (toRemoveCategoryIds == null) {
			sb.append("null");
		}
		else {
			sb.append("[");

			for (int i = 0; i < toRemoveCategoryIds.length; i++) {
				sb.append(toRemoveCategoryIds[i]);

				if ((i + 1) < toRemoveCategoryIds.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

}