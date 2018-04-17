package mg.studio.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * This is a custom ArrayAdapter that extends ArrayAdapter
 */

class ListViewStudentsArrayAdapter extends ArrayAdapter<ListViewStudents> {
    private int resourceId;

    public ListViewStudentsArrayAdapter(Context context, int resource, List<ListViewStudents> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewStudents student = getItem(position);
        View view;
        ListViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ListViewHolder();
            viewHolder.studentName = view.findViewById(R.id.tv_student_name);
            viewHolder.studentId = view.findViewById(R.id.tv_student_id);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ListViewHolder) view.getTag();

        }

        viewHolder.studentName.setText(student.getName());
        Log.d(getContext().getPackageName().toString(), student.getName());
        viewHolder.studentId.setText(String.valueOf(student.getStudentId()));
        Log.d(getContext().getPackageName().toString(), String.valueOf(student.getStudentId()));
        return view;

    }


}
