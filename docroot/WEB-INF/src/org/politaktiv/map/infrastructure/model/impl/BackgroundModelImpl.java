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

import org.politaktiv.map.infrastructure.model.Background;
import org.politaktiv.map.infrastructure.model.BackgroundModel;
import org.politaktiv.map.infrastructure.model.BackgroundSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;


/**
 * The base model implementation for the Background service. Represents a row in the &quot;politaktivmap_Background&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.politaktiv.map.infrastructure.model.BackgroundModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BackgroundImpl}.
 * </p>
 *
 * @author eichi
 * @see BackgroundImpl
 * @see org.politaktiv.map.infrastructure.model.Background
 * @see org.politaktiv.map.infrastructure.model.BackgroundModel
 * @generated
 */
@JSON(strict = true)
public class BackgroundModelImpl extends BaseModelImpl<Background>
	implements BackgroundModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a background model instance should use the {@link org.politaktiv.map.infrastructure.model.Background} interface instead.
	 */
	public static final String TABLE_NAME = "politaktivmap_Background";
	public static final Object[][] TABLE_COLUMNS = {
			{ "backgroundId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "fileEntryUuid", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table politaktivmap_Background (backgroundId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,name VARCHAR(75) null,fileEntryUuid VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table politaktivmap_Background";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.politaktiv.map.infrastructure.model.Background"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.politaktiv.map.infrastructure.model.Background"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.politaktiv.map.infrastructure.model.Background"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Background toModel(BackgroundSoap soapModel) {
		Background model = new BackgroundImpl();

		model.setBackgroundId(soapModel.getBackgroundId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setName(soapModel.getName());
		model.setFileEntryUuid(soapModel.getFileEntryUuid());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Background> toModels(BackgroundSoap[] soapModels) {
		List<Background> models = new ArrayList<Background>(soapModels.length);

		for (BackgroundSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.politaktiv.map.infrastructure.model.Background"));

	public BackgroundModelImpl() {
	}

	public long getPrimaryKey() {
		return _backgroundId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBackgroundId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_backgroundId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Background.class;
	}

	public String getModelClassName() {
		return Background.class.getName();
	}

	@JSON
	public long getBackgroundId() {
		return _backgroundId;
	}

	public void setBackgroundId(long backgroundId) {
		_backgroundId = backgroundId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
	public Background toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Background)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Background.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		BackgroundImpl backgroundImpl = new BackgroundImpl();

		backgroundImpl.setBackgroundId(getBackgroundId());
		backgroundImpl.setCompanyId(getCompanyId());
		backgroundImpl.setGroupId(getGroupId());
		backgroundImpl.setUserId(getUserId());
		backgroundImpl.setName(getName());
		backgroundImpl.setFileEntryUuid(getFileEntryUuid());

		backgroundImpl.resetOriginalValues();

		return backgroundImpl;
	}

	public int compareTo(Background background) {
		long primaryKey = background.getPrimaryKey();

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

		Background background = null;

		try {
			background = (Background)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = background.getPrimaryKey();

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
		BackgroundModelImpl backgroundModelImpl = this;

		backgroundModelImpl._originalCompanyId = backgroundModelImpl._companyId;

		backgroundModelImpl._setOriginalCompanyId = false;

		backgroundModelImpl._originalGroupId = backgroundModelImpl._groupId;

		backgroundModelImpl._setOriginalGroupId = false;

		backgroundModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Background> toCacheModel() {
		BackgroundCacheModel backgroundCacheModel = new BackgroundCacheModel();

		backgroundCacheModel.backgroundId = getBackgroundId();

		backgroundCacheModel.companyId = getCompanyId();

		backgroundCacheModel.groupId = getGroupId();

		backgroundCacheModel.userId = getUserId();

		backgroundCacheModel.name = getName();

		String name = backgroundCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			backgroundCacheModel.name = null;
		}

		backgroundCacheModel.fileEntryUuid = getFileEntryUuid();

		String fileEntryUuid = backgroundCacheModel.fileEntryUuid;

		if ((fileEntryUuid != null) && (fileEntryUuid.length() == 0)) {
			backgroundCacheModel.fileEntryUuid = null;
		}

		return backgroundCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{backgroundId=");
		sb.append(getBackgroundId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", fileEntryUuid=");
		sb.append(getFileEntryUuid());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.infrastructure.model.Background");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>backgroundId</column-name><column-value><![CDATA[");
		sb.append(getBackgroundId());
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
			"<column><column-name>fileEntryUuid</column-name><column-value><![CDATA[");
		sb.append(getFileEntryUuid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Background.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Background.class
		};
	private long _backgroundId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _fileEntryUuid;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private Background _escapedModelProxy;
}