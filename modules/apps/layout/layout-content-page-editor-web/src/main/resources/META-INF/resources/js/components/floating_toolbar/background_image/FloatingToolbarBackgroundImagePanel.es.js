import Component from 'metal-component';
import {Config} from 'metal-state';
import Soy from 'metal-soy';

import './FloatingToolbarBackgroundImagePanelDelegateTemplate.soy';
import {getConnectedComponent} from '../../../store/ConnectedComponent.es';
import {openImageSelector} from '../../../utils/FragmentsEditorDialogUtils';
import templates from './FloatingToolbarBackgroundImagePanel.soy';
import {UPDATE_LAST_SAVE_DATE, UPDATE_ROW_CONFIG, UPDATE_SAVING_CHANGES_STATUS, UPDATE_TRANSLATION_STATUS} from '../../../actions/actions.es';

/**
 * FloatingToolbarBackgroundImagePanel
 */
class FloatingToolbarBackgroundImagePanel extends Component {

	/**
	 * Show image selector
	 * @private
	 * @review
	 */
	_handleSelectButtonClick() {
		openImageSelector(
			{
				callback: url => this._updateRowBackgroundImage(url),
				imageSelectorURL: this.imageSelectorURL,
				portletNamespace: this.portletNamespace
			}
		);
	}

	/**
	 * Remove existing image if any
	 * @private
	 * @review
	 */
	_handleClearButtonClick() {
		this._updateRowBackgroundImage('');
	}

	/**
	 * Updates row image
	 * @param {string} backgroundImage Row image
	 * @private
	 * @review
	 */
	_updateRowBackgroundImage(backgroundImage) {
		this.store
			.dispatch(
				UPDATE_SAVING_CHANGES_STATUS,
				{
					savingChanges: true
				}
			)
			.dispatch(
				UPDATE_ROW_CONFIG,
				{
					config: {
						backgroundImage
					},
					rowId: this.itemId
				}
			)
			.dispatch(
				UPDATE_TRANSLATION_STATUS
			)
			.dispatch(
				UPDATE_LAST_SAVE_DATE,
				{
					lastSaveDate: new Date()
				}
			)
			.dispatch(
				UPDATE_SAVING_CHANGES_STATUS,
				{
					savingChanges: false
				}
			);
	}

}

/**
 * State definition.
 * @review
 * @static
 * @type {!Object}
 */
FloatingToolbarBackgroundImagePanel.STATE = {

	/**
	 * @default undefined
	 * @memberof FloatingToolbarBackgroundImagePanel
	 * @review
	 * @type {!string}
	 */
	itemId: Config
		.string()
		.required()
};

const ConnectedFloatingToolbarBackgroundImagePanel = getConnectedComponent(
	FloatingToolbarBackgroundImagePanel,
	[
		'imageSelectorURL',
		'portletNamespace'
	]
);

Soy.register(ConnectedFloatingToolbarBackgroundImagePanel, templates);

export {ConnectedFloatingToolbarBackgroundImagePanel, FloatingToolbarBackgroundImagePanel};
export default ConnectedFloatingToolbarBackgroundImagePanel;