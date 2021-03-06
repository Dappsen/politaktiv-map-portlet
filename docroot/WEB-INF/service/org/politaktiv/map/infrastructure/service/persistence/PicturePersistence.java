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

import com.liferay.portal.service.persistence.BasePersistence;

import org.politaktiv.map.infrastructure.model.Picture;

/**
 * The persistence interface for the picture service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author eichi
 * @see PicturePersistenceImpl
 * @see PictureUtil
 * @generated
 */
public interface PicturePersistence extends BasePersistence<Picture> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PictureUtil} to access the picture persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the picture in the entity cache if it is enabled.
	*
	* @param picture the picture
	*/
	public void cacheResult(
		org.politaktiv.map.infrastructure.model.Picture picture);

	/**
	* Caches the pictures in the entity cache if it is enabled.
	*
	* @param pictures the pictures
	*/
	public void cacheResult(
		java.util.List<org.politaktiv.map.infrastructure.model.Picture> pictures);

	/**
	* Creates a new picture with the primary key. Does not add the picture to the database.
	*
	* @param pictureId the primary key for the new picture
	* @return the new picture
	*/
	public org.politaktiv.map.infrastructure.model.Picture create(
		long pictureId);

	/**
	* Removes the picture with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pictureId the primary key of the picture
	* @return the picture that was removed
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Picture remove(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException;

	public org.politaktiv.map.infrastructure.model.Picture updateImpl(
		org.politaktiv.map.infrastructure.model.Picture picture, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the picture with the primary key or throws a {@link org.politaktiv.map.infrastructure.NoSuchPictureException} if it could not be found.
	*
	* @param pictureId the primary key of the picture
	* @return the picture
	* @throws org.politaktiv.map.infrastructure.NoSuchPictureException if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Picture findByPrimaryKey(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException;

	/**
	* Returns the picture with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pictureId the primary key of the picture
	* @return the picture, or <code>null</code> if a picture with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.infrastructure.model.Picture fetchByPrimaryKey(
		long pictureId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pictures where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @return the matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findBybackgroundId(
		long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findBybackgroundId(
		long backgroundId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findBybackgroundId(
		long backgroundId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.politaktiv.map.infrastructure.model.Picture findBybackgroundId_First(
		long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException;

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
	public org.politaktiv.map.infrastructure.model.Picture findBybackgroundId_Last(
		long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException;

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
	public org.politaktiv.map.infrastructure.model.Picture[] findBybackgroundId_PrevAndNext(
		long pictureId, long backgroundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException;

	/**
	* Returns all the pictures where name = &#63;.
	*
	* @param name the name
	* @return the matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.politaktiv.map.infrastructure.model.Picture findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException;

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
	public org.politaktiv.map.infrastructure.model.Picture findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException;

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
	public org.politaktiv.map.infrastructure.model.Picture[] findByname_PrevAndNext(
		long pictureId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.infrastructure.NoSuchPictureException;

	/**
	* Returns all the pictures.
	*
	* @return the pictures
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.infrastructure.model.Picture> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pictures where backgroundId = &#63; from the database.
	*
	* @param backgroundId the background ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBybackgroundId(long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pictures where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pictures from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pictures where backgroundId = &#63;.
	*
	* @param backgroundId the background ID
	* @return the number of matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public int countBybackgroundId(long backgroundId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pictures where name = &#63;.
	*
	* @param name the name
	* @return the number of matching pictures
	* @throws SystemException if a system exception occurred
	*/
	public int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pictures.
	*
	* @return the number of pictures
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}