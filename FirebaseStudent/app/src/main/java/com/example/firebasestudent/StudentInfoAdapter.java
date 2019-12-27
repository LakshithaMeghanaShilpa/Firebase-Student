package com.example.firebasestudent;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentInfoAdapter extends ArrayAdapter<students> {

    private Activity context;
    private List<students> studentsList;

    public StudentInfoAdapter(Activity context,List<students> studentsList){

        super(context,R.layout.list_view, studentsList);
        this.context = context;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.list_view,null,true);

        TextView studentName =(TextView)listview.findViewById(R.id.name);
        TextView studentUSN =(TextView)listview.findViewById(R.id.USN);
        TextView studentspecialization =(TextView)listview.findViewById(R.id.specialization);
        TextView studentDept =(TextView)listview.findViewById(R.id.dept);

        students student = studentsList.get(position);
        studentName.setText(student.getStudentName());
        studentUSN.setText(student.getStudentUSN());
        studentspecialization.setText(student.getStudentspecialization());
        studentDept.setText(student.getStudentdept());
        return listview;
    }
}
