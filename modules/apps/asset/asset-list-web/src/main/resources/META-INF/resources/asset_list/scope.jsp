<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
Set<Group> availableGroups = editAssetListDisplayContext.getAvailableGroups();

List<Group> selectedGroups = editAssetListDisplayContext.getSelectedGroups();

PortletURL portletURL = editAssetListDisplayContext.getPortletURL();
%>

<liferay-frontend:edit-form
	name="fm"
>
	<liferay-frontend:edit-form-body>
		<liferay-ui:search-container
			compactEmptyResultsMessage="<%= true %>"
			emptyResultsMessage="none"
			iteratorURL="<%= editAssetListDisplayContext.getPortletURL() %>"
			total="<%= selectedGroups.size() %>"
		>
			<liferay-ui:search-container-results
				results="<%= selectedGroups %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.portal.kernel.model.Group"
				keyProperty="groupId"
				modelVar="group"
			>
				<liferay-ui:search-container-column-text
					name="name"
					truncate="<%= true %>"
					value="<%= group.getScopeDescriptiveName(themeDisplay) %>"
				/>

				<liferay-ui:search-container-column-text
					name="type"
					value="<%= LanguageUtil.get(request, group.getScopeLabel(themeDisplay)) %>"
				/>

				<liferay-ui:search-container-column-text>
					<portlet:actionURL name="/asset_list/delete_scope_group" var="deleteScopeGroupURL">
						<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
						<portlet:param name="assetListEntryId" value="<%= String.valueOf(editAssetListDisplayContext.getAssetListEntryId()) %>" />
						<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
					</portlet:actionURL>

					<liferay-ui:icon
						icon="times"
						markupView="lexicon"
						url="<%= deleteScopeGroupURL %>"
					/>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				markupView="lexicon"
				paginate="<%= false %>"
			/>
		</liferay-ui:search-container>

		<liferay-ui:icon-menu
			cssClass="select-existing-selector"
			direction="right"
			message="select"
			showArrow="<%= false %>"
			showWhenSingleIcon="<%= true %>"
		>

			<%
			for (Group group : availableGroups) {
				if (selectedGroups.contains(group)) {
					continue;
				}
			%>

				<portlet:actionURL name="/asset_list/add_scope_group" var="addScopeGroupURL">
					<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
					<portlet:param name="assetListEntryId" value="<%= String.valueOf(editAssetListDisplayContext.getAssetListEntryId()) %>" />
					<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
				</portlet:actionURL>

				<liferay-ui:icon
					id='<%= "scope" + group.getGroupId() %>'
					message="<%= group.getScopeDescriptiveName(themeDisplay) %>"
					method="post"
					url="<%= addScopeGroupURL %>"
				/>

			<%
			}
			%>

		</liferay-ui:icon-menu>
	</liferay-frontend:edit-form-body>
</liferay-frontend:edit-form>