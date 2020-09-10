package by.andersen.intern.dobrov;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Первый Fragment. Добавление EditText и TextWatcher. Вывод введенного в EditText в Toast.
 */

public class MainActivity extends FragmentActivity implements TextWatcher, View.OnClickListener {

    private static final String TAG = "Fragment";
    private EditText showMeTheText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMeTheText = (EditText) findViewById(R.id.edit_text);
        showMeTheText.addTextChangedListener(this);
        showMeTheText.setOnClickListener(this);

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
    public void onClick(View view) {

        if (!checkStringFieldByZero()) {
            Toast.makeText(this, R.string.empty_field, Toast.LENGTH_SHORT).show();

        } else if (checkStringFieldByZero()) {
            Toast.makeText(this, showMeTheText.getText(), Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * Check if value  has  some  entering letter  or not
     *
     * @return boolean
     */
    public boolean checkStringFieldByZero() {
        Log.d(TAG, "Starting to check our field on filling");

        if (showMeTheText.getText().toString().matches("^\\s+$")) {
            Log.e(TAG, "Too much spaces!!!");
            return false;

        } else if (!showMeTheText.getText().toString().matches("^\\w+$")) {
            Log.d(TAG, "Empty field");
            return false;
        }

        Log.d(TAG, "Everything is fine!!");
        return true;
    }
}




