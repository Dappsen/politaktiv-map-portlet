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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the background remote service. This utility wraps {@link org.politaktiv.map.infrastructure.service.impl.BackgroundServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author eichi
 * @see BackgroundService
 * @see org.politaktiv.map.infrastructure.service.base.BackgroundServiceBaseImpl
 * @see org.politaktiv.map.infrastructure.service.impl.BackgroundServiceImpl
 * @generated
 */
public class BackgroundServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.infrastructure.service.impl.BackgroundServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<org.politaktiv.map.infrastructure.model.Background> findBycompanyIdAndGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBycompanyIdAndGroupId(companyId, groupId);
	}

	public static org.politaktiv.map.infrastructure.model.Background addBackground(
		org.politaktiv.map.infrastructure.model.Background background,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService().addBackground(background, groupId);
	}

	public static void deleteBackground(long backgroundId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBackground(backgroundId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BackgroundService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BackgroundService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					BackgroundService.class.getName(), portletClassLoader);

			_service = new BackgroundServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(BackgroundServiceUtil.class,
				"_service");
			MethodCache.remove(BackgroundService.class);
		}

		return _service;
	}

	public void setService(BackgroundService service) {
		MethodCache.remove(BackgroundService.class);

		_service = service;

		ReferenceRegistry.registerReference(BackgroundServiceUtil.class,
			"_service");
		MethodCache.remove(BackgroundService.class);
	}

	private static BackgroundService _service;
}