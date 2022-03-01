## JSONArray按照某字段排序

```jshelllanguage

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyJsonUtils {

    /**
     * 将JSONArray按照某个字段排序
     * @param array JSONArray
     * @param sortColName 排序的字段
     * @param isAsc 是否升序
     * @return
     */
    public static JSONArray jsonArraySort(JSONArray array, final String sortColName, final boolean isAsc) {
        JSONArray sortedJsonArray = new JSONArray();

        // 将JSONArray的每个JSONObject放入list
        List<JSONObject> jsonList = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            jsonList.add(array.getJSONObject(i));
        }

        //将 JSONArray 转换成 List,本质上还是对 List 进行排序
        Collections.sort(jsonList, (o1, o2) -> {
            String valA = o1.getString(sortColName);
            String valB = o2.getString(sortColName);
            if (isAsc) {
                // 升序
                return valA.compareTo(valB);
            } else {
                return valB.compareTo(valA);
            }
        });

        // 此时jsonList已经是排完序的集合了
        for(JSONObject obj : jsonList) {
            sortedJsonArray.add(obj);
        }
        return sortedJsonArray;
    }
}

```




















