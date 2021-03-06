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
 * This class is a wrapper for {@link PictureLocalService}.
 * </p>
 *
 * @author    eichi
 * @see       PictureLocalService
 * @generated
 */
public class PictureLocalServiceWrapper implements PictureLocalService,
	ServiceWrapper<PictureLocalService> {
	public PictureLocalServiceWrapper(PictureLocalService pictureLocalService) {
		_pictureLocalService = pictureLocalService;
	}

	/**
	* Adds the picture to the database. Also notifies the appropriate model listeners.
	*
	* @param picture the picture
	* @return the picture that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Picture addPicture(
		org.politaktiv.map.infrastructure.model.Picture picture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.addPicture(picture);
	}

	/**
	* Creates a new picture with the primary key. Does not add the picture to the database.
	*
	* @param pictureId the primary key for the new picture
	* @return the new picture
	*/
	public org.politaktiv.map.infrastructure.model.Picture createPicture(
		long pictureId) {
		return _pictureLocalService.createPicture(pictureId);
	}

	/**
	* Deletes the picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pictureId the primary key of the picture
	* @throws PortalException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePicture(long pictureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pictureLocalService.deletePicture(pictureId);
	}

	/**
	* Deletes the picture from the database. Also notifies the appropriate model listeners.
	*
	* @param picture the picture
	* @throws SystemException if a system exception occurred
	*/
	public void deletePicture(
		org.politaktiv.map.infrastructure.model.Picture picture)
		throws com.liferay.portal.kernel.exception.SystemException {
		_pictureLocalService.deletePicture(picture);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.politaktiv.map.infrastructure.model.Picture fetchPicture(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.fetchPicture(pictureId);
	}

	/**
	* Returns the picture with the primary key.
	*
	* @param pictureId the primary key of the picture
	* @return the picture
	* @throws PortalException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Picture getPicture(
		long pictureId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.getPicture(pictureId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the pictures.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pictures
	* @param end the upper bound of the range of pictures (not inclusive)
	* @return the range of pictures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> getPictures(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.getPictures(start, end);
	}

	/**
	* Returns the number of pictures.
	*
	* @return the number of pictures
	* @throws SystemException if a system exception occurred
	*/
	public int getPicturesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.getPicturesCount();
	}

	/**
	* Updates the picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param picture the picture
	* @return the picture that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Picture updatePicture(
		org.politaktiv.map.infrastructure.model.Picture picture)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.updatePicture(picture);
	}

	/**
	* Updates the picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param picture the picture
	* @param merge whether to merge the picture with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the picture that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Picture updatePicture(
		org.politaktiv.map.infrastructure.model.Picture picture, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.updatePicture(picture, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _pictureLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_pictureLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findByBackgroundId(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pictureLocalService.findByBackgroundId(backgroundId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PictureLocalService getWrappedPictureLocalService() {
		return _pictureLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPictureLocalService(
		PictureLocalService pictureLocalService) {
		_pictureLocalService = pictureLocalService;
	}

	public PictureLocalService getWrappedService() {
		return _pictureLocalService;
	}

	public void setWrappedService(PictureLocalService pictureLocalService) {
		_pictureLocalService = pictureLocalService;
	}

	private PictureLocalService _pictureLocalService;
}