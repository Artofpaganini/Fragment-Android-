package by.andersen.intern.dobrov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


/**
 * Первый Fragment. Добавление EditText и TextWatcher. Вывод введенного в EditText в Toast.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new FirstFragment())
                    .commit();
        }

    }

}




