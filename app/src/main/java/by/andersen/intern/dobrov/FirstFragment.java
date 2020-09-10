package by.andersen.intern.dobrov;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    private static final String TAG = "Fragment";
    private EditText text;

    public FirstFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        text = (EditText) view.findViewById(R.id.edit_text);

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (!checkStringFieldByZero()) {
                    Toast.makeText(getContext(), R.string.empty_field, Toast.LENGTH_SHORT).show();

                } else if (checkStringFieldByZero()) {
                    Toast.makeText(getContext(), text.getText(), Toast.LENGTH_SHORT).show();

                }
            }
        });
        return view;
    }


    /**
     * Check if value  has  some  entering letter  or not
     *
     * @return boolean
     */
    public boolean checkStringFieldByZero() {

        if (text.getText().toString().matches("^\\s+$")) {
            Log.e(TAG, "Too much spaces!!!");
            return false;

        } else if (!text.getText().toString().matches("^\\w+$")) {
            Log.d(TAG, "Empty field");
            return false;
        }

        return true;
    }
}