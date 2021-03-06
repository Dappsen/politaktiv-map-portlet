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

package org.politaktiv.map.infrastructure.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.politaktiv.map.infrastructure.NoSuchPictureException;
import org.politaktiv.map.infrastructure.model.Picture;
import org.politaktiv.map.infrastructure.model.impl.PictureImpl;
import org.politaktiv.map.infrastructure.model.impl.PictureModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the picture service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see PicturePersistence
 * @see PictureUtil
 * @generated
 */
public class PicturePersistenceImpl extends BasePersistenceImpl<Picture>
	implements PicturePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PictureUtil} to access the picture persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PictureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BACKGROUNDID =
		new FinderPath(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureModelImpl.FINDER_CACHE_ENABLED, PictureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybackgroundId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID =
		new FinderPath(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureModelImpl.FINDER_CACHE_ENABLED, PictureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybackgroundId",
			new String[] { Long.class.getName() },
			PictureModelImpl.BACKGROUNDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BACKGROUNDID = new FinderPath(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybackgroundId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureModelImpl.FINDER_CACHE_ENABLED, PictureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureModelImpl.FINDER_CACHE_ENABLED, PictureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByname",
			new String[] { String.class.getName() },
			PictureModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureModelImpl.FINDER_CACHE_ENABLED, PictureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureModelImpl.FINDER_CACHE_ENABLED, PictureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the picture in the entity cache if it is enabled.
	 *
	 * @param picture the picture
	 */
	public void cacheResult(Picture picture) {
		EntityCacheUtil.putResult(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureImpl.class, picture.getPrimaryKey(), picture);

		picture.resetOriginalValues();
	}

	/**
	 * Caches the pictures in the entity cache if it is enabled.
	 *
	 * @param pictures the pictures
	 */
	public void cacheResult(List<Picture> pictures) {
		for (Picture picture : pictures) {
			if (EntityCacheUtil.getResult(
						PictureModelImpl.ENTITY_CACHE_ENABLED,
						PictureImpl.class, picture.getPrimaryKey()) == null) {
				cacheResult(picture);
			}
			else {
				picture.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pictures.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PictureImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PictureImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the picture.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Picture picture) {
		EntityCacheUtil.removeResult(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureImpl.class, picture.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Picture> pictures) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Picture picture : pictures) {
			EntityCacheUtil.removeResult(PictureModelImpl.ENTITY_CACHE_ENABLED,
				PictureImpl.class, picture.getPrimaryKey());
		}
	}

	/**
	 * Creates a new picture with the primary key. Does not add the picture to the database.
	 *
	 * @param pictureId the primary key for the new picture
	 * @return the new picture
	 */
	public Picture create(long pictureId) {
		Picture picture = new PictureImpl();

		picture.setNew(true);
		picture.setPrimaryKey(pictureId);

		return picture;
	}

	/**
	 * Removes the picture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pictureId the primary key of the picture
	 * @return the picture that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture remove(long pictureId)
		throws NoSuchPictureException, SystemException {
		return remove(Long.valueOf(pictureId));
	}

	/**
	 * Removes the picture with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the picture
	 * @return the picture that was removed
	 * @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Picture remove(Serializable primaryKey)
		throws NoSuchPictureException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Picture picture = (Picture)session.get(PictureImpl.class, primaryKey);

			if (picture == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPictureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(picture);
		}
		catch (NoSuchPictureException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Picture removeImpl(Picture picture) throws SystemException {
		picture = toUnwrappedModel(picture);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, picture);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(picture);

		return picture;
	}

	@Override
	public Picture updateImpl(
		org.politaktiv.map.infrastructure.model.Picture picture, boolean merge)
		throws SystemException {
		picture = toUnwrappedModel(picture);

		boolean isNew = picture.isNew();

		PictureModelImpl pictureModelImpl = (PictureModelImpl)picture;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, picture, merge);

			picture.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PictureModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((pictureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(pictureModelImpl.getOriginalBackgroundId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BACKGROUNDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID,
					args);

				args = new Object[] {
						Long.valueOf(pictureModelImpl.getBackgroundId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BACKGROUNDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID,
					args);
			}

			if ((pictureModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { pictureModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { pictureModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(PictureModelImpl.ENTITY_CACHE_ENABLED,
			PictureImpl.class, picture.getPrimaryKey(), picture);

		return picture;
	}

	protected Picture toUnwrappedModel(Picture picture) {
		if (picture instanceof PictureImpl) {
			return picture;
		}

		PictureImpl pictureImpl = new PictureImpl();

		pictureImpl.setNew(picture.isNew());
		pictureImpl.setPrimaryKey(picture.getPrimaryKey());

		pictureImpl.setPictureId(picture.getPictureId());
		pictureImpl.setCompanyId(picture.getCompanyId());
		pictureImpl.setGroupId(picture.getGroupId());
		pictureImpl.setUserId(picture.getUserId());
		pictureImpl.setName(picture.getName());
		pictureImpl.setDescription(picture.getDescription());
		pictureImpl.setReferenceUrl(picture.getReferenceUrl());
		pictureImpl.setBackgroundId(picture.getBackgroundId());
		pictureImpl.setRotation(picture.getRotation());
		pictureImpl.setWidth(picture.getWidth());
		pictureImpl.setHeight(picture.getHeight());
		pictureImpl.setResolution(picture.getResolution());
		pictureImpl.setOcupacy(picture.getOcupacy());
		pictureImpl.setLongitude(picture.getLongitude());
		pictureImpl.setLatitude(picture.getLatitude());
		pictureImpl.setFileEntryUuid(picture.getFileEntryUuid());

		return pictureImpl;
	}

	/**
	 * Returns the picture with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the picture
	 * @return the picture
	 * @throws com.liferay.portal.NoSuchModelException if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Picture findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the picture with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchPictureException} if it could not be found.
	 *
	 * @param pictureId the primary key of the picture
	 * @return the picture
	 * @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture findByPrimaryKey(long pictureId)
		throws NoSuchPictureException, SystemException {
		Picture picture = fetchByPrimaryKey(pictureId);

		if (picture == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + pictureId);
			}

			throw new NoSuchPictureException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				pictureId);
		}

		return picture;
	}

	/**
	 * Returns the picture with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the picture
	 * @return the picture, or <code>null</code> if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Picture fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the picture with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pictureId the primary key of the picture
	 * @return the picture, or <code>null</code> if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture fetchByPrimaryKey(long pictureId) throws SystemException {
		Picture picture = (Picture)EntityCacheUtil.getResult(PictureModelImpl.ENTITY_CACHE_ENABLED,
				PictureImpl.class, pictureId);

		if (picture == _nullPicture) {
			return null;
		}

		if (picture == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				picture = (Picture)session.get(PictureImpl.class,
						Long.valueOf(pictureId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (picture != null) {
					cacheResult(picture);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PictureModelImpl.ENTITY_CACHE_ENABLED,
						PictureImpl.class, pictureId, _nullPicture);
				}

				closeSession(session);
			}
		}

		return picture;
	}

	/**
	 * Returns all the pictures where backgroundId = &#63;.
	 *
	 * @param backgroundId the background ID
	 * @return the matching pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picture> findBybackgroundId(long backgroundId)
		throws SystemException {
		return findBybackgroundId(backgroundId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pictures where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param backgroundId the background ID
	 * @param start the lower bound of the range of pictures
	 * @param end the upper bound of the range of pictures (not inclusive)
	 * @return the range of matching pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picture> findBybackgroundId(long backgroundId, int start,
		int end) throws SystemException {
		return findBybackgroundId(backgroundId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pictures where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param backgroundId the background ID
	 * @param start the lower bound of the range of pictures
	 * @param end the upper bound of the range of pictures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picture> findBybackgroundId(long backgroundId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKGROUNDID;
			finderArgs = new Object[] { backgroundId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BACKGROUNDID;
			finderArgs = new Object[] {
					backgroundId,
					
					start, end, orderByComparator
				};
		}

		List<Picture> list = (List<Picture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_PICTURE_WHERE);

			query.append(_FINDER_COLUMN_BACKGROUNDID_BACKGROUNDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(backgroundId);

				list = (List<Picture>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first picture in the ordered set where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param backgroundId the background ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching picture
	 * @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a matching picture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture findBybackgroundId_First(long backgroundId,
		OrderByComparator orderByComparator)
		throws NoSuchPictureException, SystemException {
		List<Picture> list = findBybackgroundId(backgroundId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("backgroundId=");
			msg.append(backgroundId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPictureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last picture in the ordered set where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param backgroundId the background ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching picture
	 * @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a matching picture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture findBybackgroundId_Last(long backgroundId,
		OrderByComparator orderByComparator)
		throws NoSuchPictureException, SystemException {
		int count = countBybackgroundId(backgroundId);

		List<Picture> list = findBybackgroundId(backgroundId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("backgroundId=");
			msg.append(backgroundId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPictureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the pictures before and after the current picture in the ordered set where backgroundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pictureId the primary key of the current picture
	 * @param backgroundId the background ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next picture
	 * @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture[] findBybackgroundId_PrevAndNext(long pictureId,
		long backgroundId, OrderByComparator orderByComparator)
		throws NoSuchPictureException, SystemException {
		Picture picture = findByPrimaryKey(pictureId);

		Session session = null;

		try {
			session = openSession();

			Picture[] array = new PictureImpl[3];

			array[0] = getBybackgroundId_PrevAndNext(session, picture,
					backgroundId, orderByComparator, true);

			array[1] = picture;

			array[2] = getBybackgroundId_PrevAndNext(session, picture,
					backgroundId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Picture getBybackgroundId_PrevAndNext(Session session,
		Picture picture, long backgroundId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PICTURE_WHERE);

		query.append(_FINDER_COLUMN_BACKGROUNDID_BACKGROUNDID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(backgroundId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(picture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Picture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pictures where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picture> findByname(String name) throws SystemException {
		return findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pictures where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pictures
	 * @param end the upper bound of the range of pictures (not inclusive)
	 * @return the range of matching pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picture> findByname(String name, int start, int end)
		throws SystemException {
		return findByname(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pictures where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of pictures
	 * @param end the upper bound of the range of pictures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picture> findByname(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Picture> list = (List<Picture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_PICTURE_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<Picture>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first picture in the ordered set where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching picture
	 * @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a matching picture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture findByname_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchPictureException, SystemException {
		List<Picture> list = findByname(name, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPictureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last picture in the ordered set where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching picture
	 * @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a matching picture could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture findByname_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchPictureException, SystemException {
		int count = countByname(name);

		List<Picture> list = findByname(name, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchPictureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the pictures before and after the current picture in the ordered set where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pictureId the primary key of the current picture
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next picture
	 * @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Picture[] findByname_PrevAndNext(long pictureId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchPictureException, SystemException {
		Picture picture = findByPrimaryKey(pictureId);

		Session session = null;

		try {
			session = openSession();

			Picture[] array = new PictureImpl[3];

			array[0] = getByname_PrevAndNext(session, picture, name,
					orderByComparator, true);

			array[1] = picture;

			array[2] = getByname_PrevAndNext(session, picture, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Picture getByname_PrevAndNext(Session session, Picture picture,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PICTURE_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(picture);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Picture> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pictures.
	 *
	 * @return the pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picture> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Picture> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pictures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of pictures
	 * @param end the upper bound of the range of pictures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pictures
	 * @throws SystemException if a system exception occurred
	 */
	public List<Picture> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Picture> list = (List<Picture>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PICTURE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PICTURE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Picture>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Picture>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the pictures where backgroundId = &#63; from the database.
	 *
	 * @param backgroundId the background ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBybackgroundId(long backgroundId)
		throws SystemException {
		for (Picture picture : findBybackgroundId(backgroundId)) {
			remove(picture);
		}
	}

	/**
	 * Removes all the pictures where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByname(String name) throws SystemException {
		for (Picture picture : findByname(name)) {
			remove(picture);
		}
	}

	/**
	 * Removes all the pictures from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Picture picture : findAll()) {
			remove(picture);
		}
	}

	/**
	 * Returns the number of pictures where backgroundId = &#63;.
	 *
	 * @param backgroundId the background ID
	 * @return the number of matching pictures
	 * @throws SystemException if a system exception occurred
	 */
	public int countBybackgroundId(long backgroundId) throws SystemException {
		Object[] finderArgs = new Object[] { backgroundId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BACKGROUNDID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PICTURE_WHERE);

			query.append(_FINDER_COLUMN_BACKGROUNDID_BACKGROUNDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(backgroundId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BACKGROUNDID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pictures where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching pictures
	 * @throws SystemException if a system exception occurred
	 */
	public int countByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PICTURE_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pictures.
	 *
	 * @return the number of pictures
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PICTURE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the picture persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.politaktiv.map.infrastructure.model.Picture")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Picture>> listenersList = new ArrayList<ModelListener<Picture>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Picture>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PictureImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BackgroundPersistence.class)
	protected BackgroundPersistence backgroundPersistence;
	@BeanReference(type = MarkerPersistence.class)
	protected MarkerPersistence markerPersistence;
	@BeanReference(type = PicturePersistence.class)
	protected PicturePersistence picturePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PICTURE = "SELECT picture FROM Picture picture";
	private static final String _SQL_SELECT_PICTURE_WHERE = "SELECT picture FROM Picture picture WHERE ";
	private static final String _SQL_COUNT_PICTURE = "SELECT COUNT(picture) FROM Picture picture";
	private static final String _SQL_COUNT_PICTURE_WHERE = "SELECT COUNT(picture) FROM Picture picture WHERE ";
	private static final String _FINDER_COLUMN_BACKGROUNDID_BACKGROUNDID_2 = "picture.backgroundId = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "picture.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "picture.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(picture.name IS NULL OR picture.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "picture.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Picture exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Picture exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PicturePersistenceImpl.class);
	private static Picture _nullPicture = new PictureImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Picture> toCacheModel() {
				return _nullPictureCacheModel;
			}
		};

	private static CacheModel<Picture> _nullPictureCacheModel = new CacheModel<Picture>() {
			public Picture toEntityModel() {
				return _nullPicture;
			}
		};
}