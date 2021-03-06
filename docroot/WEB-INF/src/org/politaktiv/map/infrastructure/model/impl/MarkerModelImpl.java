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

import org.politaktiv.map.infrastructure.model.Marker;
import org.politaktiv.map.infrastructure.model.MarkerModel;
import org.politaktiv.map.infrastructure.model.MarkerSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * The base model implementation for the Marker service. Represents a row in the &quot;politaktivmap_Marker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.politaktiv.map.infrastructure.model.MarkerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MarkerImpl}.
 * </p>
 *
 * @author eichi
 * @see MarkerImpl
 * @see org.politaktiv.map.infrastructure.model.Marker
 * @see org.politaktiv.map.infrastructure.model.MarkerModel
 * @generated
 */
@JSON(strict = true)
public class MarkerModelImpl extends BaseModelImpl<Marker>
	implements MarkerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a marker model instance should use the {@link org.politaktiv.map.infrastructure.model.Marker} interface instead.
	 */
	public static final String TABLE_NAME = "politaktivmap_Marker";
	public static final Object[][] TABLE_COLUMNS = {
			{ "markerId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "referenceUrl", Types.VARCHAR },
			{ "backgroundId", Types.BIGINT },
			{ "longitude", Types.DOUBLE },
			{ "latitude", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table politaktivmap_Marker (markerId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,name VARCHAR(75) null,description VARCHAR(75) null,referenceUrl VARCHAR(75) null,backgroundId LONG,longitude DOUBLE,latitude DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table politaktivmap_Marker";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.politaktiv.map.infrastructure.model.Marker"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.politaktiv.map.infrastructure.model.Marker"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.politaktiv.map.infrastructure.model.Marker"),
			true);
	public static long BACKGROUNDID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Marker toModel(MarkerSoap soapModel) {
		Marker model = new MarkerImpl();

		model.setMarkerId(soapModel.getMarkerId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setReferenceUrl(soapModel.getReferenceUrl());
		model.setBackgroundId(soapModel.getBackgroundId());
		model.setLongitude(soapModel.getLongitude());
		model.setLatitude(soapModel.getLatitude());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Marker> toModels(MarkerSoap[] soapModels) {
		List<Marker> models = new ArrayList<Marker>(soapModels.length);

		for (MarkerSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.politaktiv.map.infrastructure.model.Marker"));

	public MarkerModelImpl() {
	}

	public long getPrimaryKey() {
		return _markerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setMarkerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_markerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Marker.class;
	}

	public String getModelClassName() {
		return Marker.class.getName();
	}

	@JSON
	public long getMarkerId() {
		return _markerId;
	}

	public void setMarkerId(long markerId) {
		_markerId = markerId;
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
		_name = name;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Marker toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Marker)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Marker.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		MarkerImpl markerImpl = new MarkerImpl();

		markerImpl.setMarkerId(getMarkerId());
		markerImpl.setCompanyId(getCompanyId());
		markerImpl.setGroupId(getGroupId());
		markerImpl.setUserId(getUserId());
		markerImpl.setName(getName());
		markerImpl.setDescription(getDescription());
		markerImpl.setReferenceUrl(getReferenceUrl());
		markerImpl.setBackgroundId(getBackgroundId());
		markerImpl.setLongitude(getLongitude());
		markerImpl.setLatitude(getLatitude());

		markerImpl.resetOriginalValues();

		return markerImpl;
	}

	public int compareTo(Marker marker) {
		long primaryKey = marker.getPrimaryKey();

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

		Marker marker = null;

		try {
			marker = (Marker)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = marker.getPrimaryKey();

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
		MarkerModelImpl markerModelImpl = this;

		markerModelImpl._originalBackgroundId = markerModelImpl._backgroundId;

		markerModelImpl._setOriginalBackgroundId = false;

		markerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Marker> toCacheModel() {
		MarkerCacheModel markerCacheModel = new MarkerCacheModel();

		markerCacheModel.markerId = getMarkerId();

		markerCacheModel.companyId = getCompanyId();

		markerCacheModel.groupId = getGroupId();

		markerCacheModel.userId = getUserId();

		markerCacheModel.name = getName();

		String name = markerCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			markerCacheModel.name = null;
		}

		markerCacheModel.description = getDescription();

		String description = markerCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			markerCacheModel.description = null;
		}

		markerCacheModel.referenceUrl = getReferenceUrl();

		String referenceUrl = markerCacheModel.referenceUrl;

		if ((referenceUrl != null) && (referenceUrl.length() == 0)) {
			markerCacheModel.referenceUrl = null;
		}

		markerCacheModel.backgroundId = getBackgroundId();

		markerCacheModel.longitude = getLongitude();

		markerCacheModel.latitude = getLatitude();

		return markerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{markerId=");
		sb.append(getMarkerId());
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
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.Marker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>markerId</column-name><column-value><![CDATA[");
		sb.append(getMarkerId());
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
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Marker.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Marker.class
		};
	private long _markerId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _description;
	private String _referenceUrl;
	private long _backgroundId;
	private long _originalBackgroundId;
	private boolean _setOriginalBackgroundId;
	private double _longitude;
	private double _latitude;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private Marker _escapedModelProxy;
}