package jo.edu.psut.psutgate.server.data;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ammar on 1/25/16.
 */
public class ServerResponse {

    public final String result_type;
    public final int status_code;
    public final Result[] results;

    public static final String TYPE_FACULTY = "faculty";
    public static final String TYPE_COURSE = "course";
    public static final String TYPE_CLUB = "club";

    public ServerResponse(JSONObject json){
        result_type = json.optString("result_type").toLowerCase();
        status_code = json.optInt("status_code");
        JSONArray jsonArray = json.optJSONArray("results");
        if(jsonArray == null) {
            this.results = new Result[0];
            return;
        }
        this.results = new Result[jsonArray.length()];
        for (int i = 0; i < this.results.length; i++) {
            this.results[i] = getResult(jsonArray.optJSONObject(i), result_type);
        }

    }

    private static Result getResult(JSONObject json, String type) {
        switch (type){
            case TYPE_CLUB:
                return new ResultClub(json);
            case TYPE_COURSE:
                return new ResultCourse(json);
            case TYPE_FACULTY:
                return new ResultFaculty(json);
        }
        return null;
    }
}
