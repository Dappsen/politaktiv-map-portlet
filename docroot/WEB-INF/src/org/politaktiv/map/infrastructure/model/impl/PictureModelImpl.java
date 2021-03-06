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

package org.politaktiv.map.infrastructure.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.politaktiv.map.infrastructure.model.Picture;
import org.politaktiv.map.infrastructure.model.PictureModel;
import org.politaktiv.map.infrastructure.model.PictureSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * The base model implementation for the Picture service. Represents a row in the &quot;politaktivmap_Picture&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.politaktiv.map.infrastructure.model.PictureModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PictureImpl}.
 * </p>
 *
 * @author eichi
 * @see PictureImpl
 * @see org.politaktiv.map.infrastructure.model.Picture
 * @see org.politaktiv.map.infrastructure.model.PictureModel
 * @generated
 */
@JSON(strict = true)
public class PictureModelImpl extends BaseModelImpl<Picture>
	implements PictureModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a picture model instance should use the {@link org.politaktiv.map.infrastructure.model.Picture} interface instead.
	 */
	public static final String TABLE_NAME = "politaktivmap_Picture";
	public static final Object[][] TABLE_COLUMNS = {
			{ "pictureId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "referenceUrl", Types.VARCHAR },
			{ "backgroundId", Types.BIGINT },
			{ "rotation", Types.BIGINT },
			{ "width", Types.DOUBLE },
			{ "height", Types.DOUBLE },
			{ "resolution", Types.DOUBLE },
			{ "ocupacy", Types.DOUBLE },
			{ "longitude", Types.DOUBLE },
			{ "latitude", Types.DOUBLE },
			{ "fileEntryUuid", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table politaktivmap_Picture (pictureId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,name VARCHAR(75) null,description VARCHAR(75) null,referenceUrl VARCHAR(75) null,backgroundId LONG,rotation LONG,width DOUBLE,height DOUBLE,resolution DOUBLE,ocupacy DOUBLE,longitude DOUBLE,latitude DOUBLE,fileEntryUuid VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table politaktivmap_Picture";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.politaktiv.map.infrastructure.model.Picture"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.politaktiv.map.infrastructure.model.Picture"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.politaktiv.map.infrastructure.model.Picture"),
			true);
	public static long BACKGROUNDID_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Picture toModel(PictureSoap soapModel) {
		Picture model = new PictureImpl();

		model.setPictureId(soapModel.getPictureId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setReferenceUrl(soapModel.getReferenceUrl());
		model.setBackgroundId(soapModel.getBackgroundId());
		model.setRotation(soapModel.getRotation());
		model.setWidth(soapModel.getWidth());
		model.setHeight(soapModel.getHeight());
		model.setResolution(soapModel.getResolution());
		model.setOcupacy(soapModel.getOcupacy());
		model.setLongitude(soapModel.getLongitude());
		model.setLatitude(soapModel.getLatitude());
		model.setFileEntryUuid(soapModel.getFileEntryUuid());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Picture> toModels(PictureSoap[] soapModels) {
		List<Picture> models = new ArrayList<Picture>(soapModels.length);

		for (PictureSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.politaktiv.map.infrastructure.model.Picture"));

	public PictureModelImpl() {
	}

	public long getPrimaryKey() {
		return _pictureId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPictureId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_pictureId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Picture.class;
	}

	public String getModelClassName() {
		return Picture.class.getName();
	}

	@JSON
	public long getPictureId() {
		return _pictureId;
	}

	public void setPictureId(long pictureId) {
		_pictureId = pictureId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public String getReferenceUrl() {
		if (_referenceUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _referenceUrl;
		}
	}

	public void setReferenceUrl(String referenceUrl) {
		_referenceUrl = referenceUrl;
	}

	@JSON
	public long getBackgroundId() {
		return _backgroundId;
	}

	public void setBackgroundId(long backgroundId) {
		_columnBitmask |= BACKGROUNDID_COLUMN_BITMASK;

		if (!_setOriginalBackgroundId) {
			_setOriginalBackgroundId = true;

			_originalBackgroundId = _backgroundId;
		}

		_backgroundId = backgroundId;
	}

	public long getOriginalBackgroundId() {
		return _originalBackgroundId;
	}

	@JSON
	public long getRotation() {
		return _rotation;
	}

	public void setRotation(long rotation) {
		_rotation = rotation;
	}

	@JSON
	public double getWidth() {
		return _width;
	}

	public void setWidth(double width) {
		_width = width;
	}

	@JSON
	public double getHeight() {
		return _height;
	}

	public void setHeight(double height) {
		_height = height;
	}

	@JSON
	public double getResolution() {
		return _resolution;
	}

	public void setResolution(double resolution) {
		_resolution = resolution;
	}

	@JSON
	public double getOcupacy() {
		return _ocupacy;
	}

	public void setOcupacy(double ocupacy) {
		_ocupacy = ocupacy;
	}

	@JSON
	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	@JSON
	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	@JSON
	public String getFileEntryUuid() {
		if (_fileEntryUuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileEntryUuid;
		}
	}

	public void setFileEntryUuid(String fileEntryUuid) {
		_fileEntryUuid = fileEntryUuid;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Picture toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Picture)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Picture.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		PictureImpl pictureImpl = new PictureImpl();

		pictureImpl.setPictureId(getPictureId());
		pictureImpl.setCompanyId(getCompanyId());
		pictureImpl.setGroupId(getGroupId());
		pictureImpl.setUserId(getUserId());
		pictureImpl.setName(getName());
		pictureImpl.setDescription(getDescription());
		pictureImpl.setReferenceUrl(getReferenceUrl());
		pictureImpl.setBackgroundId(getBackgroundId());
		pictureImpl.setRotation(getRotation());
		pictureImpl.setWidth(getWidth());
		pictureImpl.setHeight(getHeight());
		pictureImpl.setResolution(getResolution());
		pictureImpl.setOcupacy(getOcupacy());
		pictureImpl.setLongitude(getLongitude());
		pictureImpl.setLatitude(getLatitude());
		pictureImpl.setFileEntryUuid(getFileEntryUuid());

		pictureImpl.resetOriginalValues();

		return pictureImpl;
	}

	public int compareTo(Picture picture) {
		long primaryKey = picture.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Picture picture = null;

		try {
			picture = (Picture)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = picture.getPrimaryKey();

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
	public void resetOriginalValues() {
		PictureModelImpl pictureModelImpl = this;

		pictureModelImpl._originalName = pictureModelImpl._name;

		pictureModelImpl._originalBackgroundId = pictureModelImpl._backgroundId;

		pictureModelImpl._setOriginalBackgroundId = false;

		pictureModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Picture> toCacheModel() {
		PictureCacheModel pictureCacheModel = new PictureCacheModel();

		pictureCacheModel.pictureId = getPictureId();

		pictureCacheModel.companyId = getCompanyId();

		pictureCacheModel.groupId = getGroupId();

		pictureCacheModel.userId = getUserId();

		pictureCacheModel.name = getName();

		String name = pictureCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			pictureCacheModel.name = null;
		}

		pictureCacheModel.description = getDescription();

		String description = pictureCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			pictureCacheModel.description = null;
		}

		pictureCacheModel.referenceUrl = getReferenceUrl();

		String referenceUrl = pictureCacheModel.referenceUrl;

		if ((referenceUrl != null) && (referenceUrl.length() == 0)) {
			pictureCacheModel.referenceUrl = null;
		}

		pictureCacheModel.backgroundId = getBackgroundId();

		pictureCacheModel.rotation = getRotation();

		pictureCacheModel.width = getWidth();

		pictureCacheModel.height = getHeight();

		pictureCacheModel.resolution = getResolution();

		pictureCacheModel.ocupacy = getOcupacy();

		pictureCacheModel.longitude = getLongitude();

		pictureCacheModel.latitude = getLatitude();

		pictureCacheModel.fileEntryUuid = getFileEntryUuid();

		String fileEntryUuid = pictureCacheModel.fileEntryUuid;

		if ((fileEntryUuid != null) && (fileEntryUuid.length() == 0)) {
			pictureCacheModel.fileEntryUuid = null;
		}

		return pictureCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{pictureId=");
		sb.append(getPictureId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", referenceUrl=");
		sb.append(getReferenceUrl());
		sb.append(", backgroundId=");
		sb.append(getBackgroundId());
		sb.append(", rotation=");
		sb.append(getRotation());
		sb.append(", width=");
		sb.append(getWidth());
		sb.append(", height=");
		sb.append(getHeight());
		sb.append(", resolution=");
		sb.append(getResolution());
		sb.append(", ocupacy=");
		sb.append(getOcupacy());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", fileEntryUuid=");
		sb.append(getFileEntryUuid());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.Picture");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pictureId</column-name><column-value><![CDATA[");
		sb.append(getPictureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referenceUrl</column-name><column-value><![CDATA[");
		sb.append(getReferenceUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backgroundId</column-name><column-value><![CDATA[");
		sb.append(getBackgroundId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rotation</column-name><column-value><![CDATA[");
		sb.append(getRotation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>width</column-name><column-value><![CDATA[");
		sb.append(getWidth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>height</column-name><column-value><![CDATA[");
		sb.append(getHeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resolution</column-name><column-value><![CDATA[");
		sb.append(getResolution());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ocupacy</column-name><column-value><![CDATA[");
		sb.append(getOcupacy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryUuid</column-name><column-value><![CDATA[");
		sb.append(getFileEntryUuid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Picture.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Picture.class
		};
	private long _pictureId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _originalName;
	private String _description;
	private String _referenceUrl;
	private long _backgroundId;
	private long _originalBackgroundId;
	private boolean _setOriginalBackgroundId;
	private long _rotation;
	private double _width;
	private double _height;
	private double _resolution;
	private double _ocupacy;
	private double _longitude;
	private double _latitude;
	private String _fileEntryUuid;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private Picture _escapedModelProxy;
}