package by.andersen.intern.dobrov;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class FirstFragment extends Fragment implements TextWatcher, View.OnKeyListener {

    private static final String TAG = "Fragment";
    private EditText text;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        text = (EditText) view.findViewById(R.id.edit_text);
        text.addTextChangedListener(this);
        text.setOnKeyListener(this);

        return view;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {

            if (!checkStringFieldByZero()) {
                Toast.makeText(getContext(), R.string.empty_field, Toast.LENGTH_SHORT).show();
                return true;

            } else if (checkStringFieldByZero()) {
                Toast.makeText(getContext(), text.getText(), Toast.LENGTH_SHORT).show();
                return true;

            }
        }
        return false;

    }

    /**
     * Check if value  has  some  entering letter  or not
     *
     * @return boolean
     */
    public boolean checkStringFieldByZero() {
        Log.d(TAG, "Starting to check our field on filling");

        if (text.getText().toString().matches("^\\s+$")) {
            Log.e(TAG, "Too much spaces!!!");
            return false;

        } else if (!text.getText().toString().matches("^\\w+$")) {
            Log.d(TAG, "Empty field");
            return false;
        }

        Log.d(TAG, "Everything is fine!!");
        return true;
    }
}