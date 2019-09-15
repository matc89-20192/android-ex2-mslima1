package matc89.exercicio2;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static matc89.exercicio2.R.id.btnTrocar;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    TextView textViewSalvo;
    public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSalvo = (TextView) findViewById(R.id.textView);

//         Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);

        if (message != null) {
            textView.setText("Oi, " + message + "!");
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            textView.setText("Oi!");
        }

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView textView = (TextView) findViewById(R.id.textView);
        String salvo = savedInstanceState.getString("salvo");
        textView.setText("Oi, " + salvo + "!");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        outState.putString("salvo", message);
    }


    public void trocar(View view){
        Intent intent = new Intent(MainActivity.this, OutraActivity.class);
//        TextView textView = (TextView) findViewById(R.id.textView);
//        String message = textView.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
