package dolinski.andrzej.zaliczenie;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class RaisedTaskAdapter extends BaseAdapter {

    private final List<TaskEntry> items;
    private final Context context;

    public RaisedTaskAdapter(Context context) {
        this.context = context;
        items = new LinkedList<>();

        List<TaskEntry> taskEntries = new RaisedTaskDB(context).readData();
        items.addAll(taskEntries);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;

        if (convertView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.activity_task_list_row, parent, false);
        } else {
            itemView = convertView;
        }
        TaskEntry taskEntry = items.get(position);

        TextView summary = (TextView) itemView.findViewById(R.id.summary);
        summary.setText(taskEntry.getSummary());

        TextView description = (TextView) itemView.findViewById(R.id.description);
        description.setText(taskEntry.getDescription());

        TextView date = (TextView) itemView.findViewById(R.id.date);
        date.setText(taskEntry.getDate());

        return itemView;
    }
}
