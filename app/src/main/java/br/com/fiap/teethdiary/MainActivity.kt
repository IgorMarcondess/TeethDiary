package br.com.fiap.teethdiary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    private lateinit var EmailEditText: EditText
    private lateinit var LogInbutton: Button
    private lateinit var sucessTextView: TextView
    private lateinit var ErrorTextView: TextView
    private lateinit var PasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        EmailEditText = findViewById(R.id.EmailEditText);
        LogInbutton = findViewById(R.id.LogInbutton);
        sucessTextView = findViewById(R.id.sucessTextView);
        ErrorTextView = findViewById(R.id.ErrorTextView);
        PasswordEditText = findViewById(R.id.PasswordEditText)

        LogInbutton.setOnClickListener{
            login()
        }
    }
    private fun login(){
        val email = EmailEditText.text.toString();
        val senha = PasswordEditText.text.toString().toIntOrNull();

        if (email == "admin" && senha == 12345){
            sucessTextView.isInvisible = false;
            sucessTextView.text = "Credenciais válidas! Entrando...";
            ErrorTextView.isInvisible = true;

        }else{
            ErrorTextView.isInvisible = false;
            ErrorTextView.text = "Dados inseridos estão incorretos. Tente novamente!";
            sucessTextView.isInvisible = true;
        }
    }
    private fun desabilitarCampos(){
        sucessTextView.isInvisible = true;
    }
}
