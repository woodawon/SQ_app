package org.techtown.sq_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    TextView taskText;
    EditText answer;
    Button done;
    String title;static int isCorrect = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);
        answer = rootView.findViewById(R.id.answer);
        done = rootView.findViewById(R.id.done);
        taskText = rootView.findViewById(R.id.taskText);
        title = Fragment2.title;
        taskText.setText(title);

        done.setOnClickListener(view -> {
            if(answer.getText().toString().equals(Fragment2.content.toString())) {
                Toast.makeText(getContext(), "정답입니다!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "틀렸습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}
