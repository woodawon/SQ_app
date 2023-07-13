package org.techtown.sq_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class Fragment1 extends Fragment {

    EditText editText;
    EditText editText2;

    OnDatabaseCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callback = (OnDatabaseCallback) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        editText = rootView.findViewById(R.id.editText);
        editText2 = rootView.findViewById(R.id.editText2);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String contents = editText2.getText().toString();

                callback.insert(name, contents);
            }
        });

        return rootView;
    }
}
