/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
/**
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.politaktiv.map.infrastructure.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import org.politaktiv.map.infrastructure.model.Picture;
import org.politaktiv.map.infrastructure.service.BackgroundLocalService;
import org.politaktiv.map.infrastructure.service.BackgroundService;
import org.politaktiv.map.infrastructure.service.MarkerLocalService;
import org.politaktiv.map.infrastructure.service.MarkerService;
import org.politaktiv.map.infrastructure.service.PictureLocalService;
import org.politaktiv.map.infrastructure.service.PictureService;
import org.politaktiv.map.infrastructure.service.persistence.BackgroundPersistence;
import org.politaktiv.map.infrastructure.service.persistence.MarkerPersistence;
import org.politaktiv.map.infrastructure.service.persistence.PicturePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the picture local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.politaktiv.map.infrastructure.service.impl.PictureLocalServiceImpl}.
 * </p>
 *
 * @author eichi
 * @see org.politaktiv.map.infrastructure.service.impl.PictureLocalServiceImpl
 * @see org.politaktiv.map.infrastructure.service.PictureLocalServiceUtil
 * @generated
 */
public abstract class PictureLocalServiceBaseImpl implements PictureLocalService,
	IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.politaktiv.map.infrastructure.service.PictureLocalServiceUtil} to access the picture local service.
	 */

	/**
	 * Adds the picture to the database. Also notifies the appropriate model listeners.
	 *
	 * @param picture the picture
	 * @return the picture that was added
	 * @throws SystemException if a system exception occurred
	 */
	public Picture addPicture(Picture picture) throws SystemException {
		picture.setNew(true);

		picture = picturePersistence.update(picture, false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(picture);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return picture;
	}

	/**
	 * Creates a new picture with the primary key. Does not add the picture to the database.
	 *
	 * @param pictureId the primary key for the new picture
	 * @return the new picture
	 */
	public Picture createPicture(long pictureId) {
		return picturePersistence.create(pictureId);
	}

	/**
	 * Deletes the picture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pictureId the primary key of the picture
	 * @throws PortalException if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deletePicture(long pictureId)
		throws PortalException, SystemException {
		Picture picture = picturePersistence.remove(pictureId);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(picture);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Deletes the picture from the database. Also notifies the appropriate model listeners.
	 *
	 * @param picture the picture
	 * @throws SystemException if a system exception occurred
	 */
	public void deletePicture(Picture picture) throws SystemException {
		picturePersistence.remove(picture);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(picture);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return picturePersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return picturePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return picturePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return picturePersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Picture fetchPicture(long pictureId) throws SystemException {
		return picturePersistence.fetchByPrimaryKey(pictureId);
	}

	/**
	 * Returns the picture with the primary key.
	 *
	 * @param pictureId the primary key of the picture
	 * @return the picture
	 * @throws PortalException if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture getPicture(long pictureId)
		throws PortalException, SystemException {
		return picturePersistence.findByPrimaryKey(pictureId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return picturePersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Picture> getPictures(int start, int end)
		throws SystemException {
		return picturePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of pictures.
	 *
	 * @return the number of pictures
	 * @throws SystemException if a system exception occurred
	 */
	public int getPicturesCount() throws SystemException {
		return picturePersistence.countAll();
	}

	/**
	 * Updates the picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param picture the picture
	 * @return the picture that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Picture updatePicture(Picture picture) throws SystemException {
		return updatePicture(picture, true);
	}

	/**
	 * Updates the picture in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param picture the picture
	 * @param merge whether to merge the picture with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the picture that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public Picture updatePicture(Picture picture, boolean merge)
		throws SystemException {
		picture.setNew(false);

		picture = picturePersistence.update(picture, merge);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(picture);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return picture;
	}

	/**
	 * Returns the background local service.
	 *
	 * @return the background local service
	 */
	public BackgroundLocalService getBackgroundLocalService() {
		return backgroundLocalService;
	}

	/**
	 * Sets the background local service.
	 *
	 * @param backgroundLocalService the background local service
	 */
	public void setBackgroundLocalService(
		BackgroundLocalService backgroundLocalService) {
		this.backgroundLocalService = backgroundLocalService;
	}

	/**
	 * Returns the background remote service.
	 *
	 * @return the background remote service
	 */
	public BackgroundService getBackgroundService() {
		return backgroundService;
	}

	/**
	 * Sets the background remote service.
	 *
	 * @param backgroundService the background remote service
	 */
	public void setBackgroundService(BackgroundService backgroundService) {
		this.backgroundService = backgroundService;
	}

	/**
	 * Returns the background persistence.
	 *
	 * @return the background persistence
	 */
	public BackgroundPersistence getBackgroundPersistence() {
		return backgroundPersistence;
	}

	/**
	 * Sets the background persistence.
	 *
	 * @param backgroundPersistence the background persistence
	 */
	public void setBackgroundPersistence(
		BackgroundPersistence backgroundPersistence) {
		this.backgroundPersistence = backgroundPersistence;
	}

	/**
	 * Returns the marker local service.
	 *
	 * @return the marker local service
	 */
	public MarkerLocalService getMarkerLocalService() {
		return markerLocalService;
	}

	/**
	 * Sets the marker local service.
	 *
	 * @param markerLocalService the marker local service
	 */
	public void setMarkerLocalService(MarkerLocalService markerLocalService) {
		this.markerLocalService = markerLocalService;
	}

	/**
	 * Returns the marker remote service.
	 *
	 * @return the marker remote service
	 */
	public MarkerService getMarkerService() {
		return markerService;
	}

	/**
	 * Sets the marker remote service.
	 *
	 * @param markerService the marker remote service
	 */
	public void setMarkerService(MarkerService markerService) {
		this.markerService = markerService;
	}

	/**
	 * Returns the marker persistence.
	 *
	 * @return the marker persistence
	 */
	public MarkerPersistence getMarkerPersistence() {
		return markerPersistence;
	}

	/**
	 * Sets the marker persistence.
	 *
	 * @param markerPersistence the marker persistence
	 */
	public void setMarkerPersistence(MarkerPersistence markerPersistence) {
		this.markerPersistence = markerPersistence;
	}

	/**
	 * Returns the picture local service.
	 *
	 * @return the picture local service
	 */
	public PictureLocalService getPictureLocalService() {
		return pictureLocalService;
	}

	/**
	 * Sets the picture local service.
	 *
	 * @param pictureLocalService the picture local service
	 */
	public void setPictureLocalService(PictureLocalService pictureLocalService) {
		this.pictureLocalService = pictureLocalService;
	}

	/**
	 * Returns the picture remote service.
	 *
	 * @return the picture remote service
	 */
	public PictureService getPictureService() {
		return pictureService;
	}

	/**
	 * Sets the picture remote service.
	 *
	 * @param pictureService the picture remote service
	 */
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	/**
	 * Returns the picture persistence.
	 *
	 * @return the picture persistence
	 */
	public PicturePersistence getPicturePersistence() {
		return picturePersistence;
	}

	/**
	 * Sets the picture persistence.
	 *
	 * @param picturePersistence the picture persistence
	 */
	public void setPicturePersistence(PicturePersistence picturePersistence) {
		this.picturePersistence = picturePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("org.politaktiv.map.infrastructure.model.Picture",
			pictureLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.politaktiv.map.infrastructure.model.Picture");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return Picture.class;
	}

	protected String getModelClassName() {
		return Picture.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = picturePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = BackgroundLocalService.class)
	protected BackgroundLocalService backgroundLocalService;
	@BeanReference(type = BackgroundService.class)
	protected BackgroundService backgroundService;
	@BeanReference(type = BackgroundPersistence.class)
	protected BackgroundPersistence backgroundPersistence;
	@BeanReference(type = MarkerLocalService.class)
	protected MarkerLocalService markerLocalService;
	@BeanReference(type = MarkerService.class)
	protected MarkerService markerService;
	@BeanReference(type = MarkerPersistence.class)
	protected MarkerPersistence markerPersistence;
	@BeanReference(type = PictureLocalService.class)
	protected PictureLocalService pictureLocalService;
	@BeanReference(type = PictureService.class)
	protected PictureService pictureService;
	@BeanReference(type = PicturePersistence.class)
	protected PicturePersistence picturePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static Log _log = LogFactoryUtil.getLog(PictureLocalServiceBaseImpl.class);
	private String _beanIdentifier;
}