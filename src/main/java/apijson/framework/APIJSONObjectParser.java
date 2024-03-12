/*Copyright ©2016 TommyLemon(https://github.com/TommyLemon/APIJSON)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package apijson.framework;

import java.util.List;

import javax.servlet.http.HttpSession;

import apijson.orm.*;
import com.alibaba.fastjson.JSONObject;

import apijson.NotNull;
import apijson.RequestMethod;


/**简化Parser，getObject和getArray(getArrayConfig)都能用
 * @author Lemon
 */
public class APIJSONObjectParser<T extends Object> extends AbstractObjectParser<T> {
	public static final String TAG = "APIJSONObjectParser";

	/**for single object
	 * @param session
	 * @param request
	 * @param parentPath
	 * @param arrayConfig
	 * @param isSubquery
	 * @param isTable
	 * @param isArrayMainTable
	 * @throws Exception
	 */
	public APIJSONObjectParser(HttpSession session, @NotNull JSONObject request, String parentPath, SQLConfig<T> arrayConfig
			, boolean isSubQuery, boolean isTable, boolean isArrayMainTable) throws Exception {
		super(request, parentPath, arrayConfig, isSubQuery, isTable, isArrayMainTable);
	}

	@Override
	public APIJSONObjectParser<T> setMethod(RequestMethod method) {
		super.setMethod(method);
		return this;
	}

	@Override
	public APIJSONObjectParser<T> setParser(Parser<T> parser) {
		super.setParser(parser);
		return this;
	}


	@Override
	public SQLConfig<T> newSQLConfig(RequestMethod method, String table, String alias, JSONObject request, List<Join> joinList, boolean isProcedure) throws Exception {
		return APIJSONSQLConfig.newSQLConfig(method, table, alias, request, joinList, isProcedure);
	}


}
