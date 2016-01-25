package jo.edu.psut.psutgate.server.data;

import org.json.JSONObject;

/**
 * Created by ammar on 1/25/16.
 */
public class ResultClub implements Result {
    public final String name;
    public final String desc;
    public final int id;
    public final String image;

    public ResultClub(JSONObject json) {
        name = json.optString("name");
        desc = json.optString("desc");
        id = json.optInt("id");
        image = json.optString("image");
    }

    @Override
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", name);
            json.put("desc", desc);
            json.put("id", id);
            json.put("image", image);
        } catch (Exception ignore) {
        }
        return json;
    }
}
