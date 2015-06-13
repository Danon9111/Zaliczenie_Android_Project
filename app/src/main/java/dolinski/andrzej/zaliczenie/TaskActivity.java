package dolinski.andrzej.zaliczenie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by andrz_000 on 2015-05-26.
 */
public class TaskActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        ListView list = (ListView) findViewById(R.id.parent);
        list.setAdapter(new RaisedTaskAdapter(this));
    }
}
