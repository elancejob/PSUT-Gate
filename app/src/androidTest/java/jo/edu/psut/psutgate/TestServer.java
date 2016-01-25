package jo.edu.psut.psutgate;

import android.test.InstrumentationTestCase;
import android.util.Log;

import jo.edu.psut.psutgate.server.data.ResultClub;
import jo.edu.psut.psutgate.server.data.ResultCourse;
import jo.edu.psut.psutgate.server.data.ResultFaculty;
import jo.edu.psut.psutgate.server.data.Server;
import jo.edu.psut.psutgate.server.data.ServerResponse;


/**
 * Created by ammar on 1/25/16.
 */
public class TestServer extends InstrumentationTestCase {

    private static final String TAG = "Test";
    public void testAll(){
        testFaculties();
        testClubs();
        testCourse();
    }
    public void testFaculties() {
        ServerResponse response = Server.getInstance().getFaculties();
        assertNotNull(response);
        assertEquals(ServerResponse.TYPE_FACULTY, response.result_type);
        assertEquals(3, response.results.length);
        assertTrue(response.results[0] instanceof ResultFaculty);
        ResultFaculty[] faculties = new ResultFaculty[response.results.length];
        for (int i = 0; i < faculties.length; i++) {
            faculties[i] = (ResultFaculty) response.results[i];
            Log.i(TAG, "name: " + faculties[i].name);
            Log.i(TAG, "id: " + faculties[i].id);
        }
    }

    public void testClubs() {
        ServerResponse response = Server.getInstance().getClubs();
        assertNotNull(response);
        assertEquals(ServerResponse.TYPE_CLUB, response.result_type);
        assertEquals(3, response.results.length);
        assertTrue(response.results[0] instanceof ResultClub);
        ResultClub[] clubs = new ResultClub[response.results.length];
        for (int i = 0; i < clubs.length; i++) {
            clubs[i] = (ResultClub) response.results[i];
            Log.i(TAG, "name: " + clubs[i].name);
            Log.i(TAG, "desc: " + clubs[i].desc);
            Log.i(TAG, "id: " + clubs[i].id);
            Log.i(TAG, "image: " + clubs[i].image);
        }
    }

    public void testCourse() {
        ServerResponse response = Server.getInstance().getCourses();
        assertNotNull(response);
        assertEquals(ServerResponse.TYPE_COURSE, response.result_type);
        assertEquals(3, response.results.length);
        assertTrue(response.results[0] instanceof ResultCourse);
        ResultCourse[] courses = new ResultCourse[response.results.length];
        for (int i = 0; i < courses.length; i++) {
            courses[i] = (ResultCourse) response.results[i];
            Log.i(TAG, "name: " + courses[i].name);
            Log.i(TAG, "desc: " + courses[i].desc);
            Log.i(TAG, "id: " + courses[i].id);
            Log.i(TAG, "image: " + courses[i].image);
        }
    }

}
