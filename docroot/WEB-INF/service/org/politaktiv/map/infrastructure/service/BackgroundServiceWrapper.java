/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 *        
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.politaktiv.map.infrastructure.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BackgroundService}.
 * </p>
 *
 * @author    eichi
 * @see       BackgroundService
 * @generated
 */
public class BackgroundServiceWrapper implements BackgroundService,
	ServiceWrapper<BackgroundService> {
	public BackgroundServiceWrapper(BackgroundService backgroundService) {
		_backgroundService = backgroundService;
	}

	public java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _backgroundService.findBycompanyIdAndGroupId(companyId, groupId);
	}

	public org.politaktiv.map.infrastructure.model.Background addBackground(
		org.politaktiv.map.infrastructure.model.Background background,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _backgroundService.addBackground(background, groupId);
	}

	public void deleteBackground(long backgroundId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_backgroundService.deleteBackground(backgroundId, groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BackgroundService getWrappedBackgroundService() {
		return _backgroundService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBackgroundService(BackgroundService backgroundService) {
		_backgroundService = backgroundService;
	}

	public BackgroundService getWrappedService() {
		return _backgroundService;
	}

	public void setWrappedService(BackgroundService backgroundService) {
		_backgroundService = backgroundService;
	}

	private BackgroundService _backgroundService;
}