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

package org.politaktiv.map.infrastructure.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Background service. Represents a row in the &quot;politaktivmap_Background&quot; database table, with each column mapped to a property of this class.
 *
 * @author eichi
 * @see BackgroundModel
 * @see org.politaktiv.map.infrastructure.model.impl.BackgroundImpl
 * @see org.politaktiv.map.infrastructure.model.impl.BackgroundModelImpl
 * @generated
 */
public interface Background extends BackgroundModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.politaktiv.map.infrastructure.model.impl.BackgroundImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getPictureUrl();

	public boolean isMap();
}