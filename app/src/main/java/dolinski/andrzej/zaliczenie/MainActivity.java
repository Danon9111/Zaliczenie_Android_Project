package dolinski.andrzej.zaliczenie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button checkTasksButton = (Button) findViewById(R.id.checkTasks);
        checkTasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TaskActivity.class);
                startActivity(i);
            }
        });

        Button addTasksButton = (Button) findViewById(R.id.addTask);
        addTasksButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, NewTaskActivity.class);
                startActivity(j);
            }
        });
    }
}
