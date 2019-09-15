package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OutraActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private EditText editText;
    private String nomeSalvo, teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);
        editText = (EditText) findViewById(R.id.editText);
        if (savedInstanceState == null) {
            editText.setText("");
        } else {
            String nomeSalvo = savedInstanceState.getString("nome");
            editText.setText(nomeSalvo);
        }
    }

    public void envia(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        if(message.length()>=1){
            intent.putExtra(EXTRA_MESSAGE, message);
        }
        startActivity(intent);
    }

    public void trocar(View view){
        Intent intent = new Intent(OutraActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        String nomeSalvo = savedInstanceState.getString("nome");
        editText.setText(nomeSalvo);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("nome", editText.getText().toString()  );
        super.onSaveInstanceState(savedInstanceState);
    }

}