package jo.edu.psut.psutgate.server.data;

import org.json.JSONObject;

/**
 * Created by ammar on 1/25/16.
 */
public class ResultFaculty implements Result{
    public final String name;
    public final int id;

    public ResultFaculty(JSONObject json) {
        name = json.optString("name");
        id = json.optInt("id");
    }

    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", name);
            json.put("id", id);
        } catch (Exception ignore) {
        }
        return json;
    }
}
