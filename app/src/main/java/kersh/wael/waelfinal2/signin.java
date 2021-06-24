package kersh.wael.waelfinal2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class signin extends AppCompatActivity {
    private EditText etemail, etpassword;
    private Button btnlog, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        etemail = findViewById(R.id.etFirstName);
        etpassword = findViewById(R.id.etLastName);
        btnlog = findViewById(R.id.btnlog);
        btnSignup = findViewById(R.id.btnsignUP);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MapsActivity.class));
            finish();
        }
        //4
        /**
         * this function run the button .
         */
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5
                validateForm();
            }
        });
        /**
         * this function run the button .
         */
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),signup.class));


            }
        });
    }

    /**
     * The method checks the correctness of the registration top and whether it is correct performs the registration
     */

    private void validateForm()
    {
        String email=etemail.getText().toString();
        String passw=etpassword.getText().toString();
        boolean isOK=true;
        if(email.length()<5 || email.indexOf('@')==0 || email.indexOf('@')>=email.length()-2 ||
                email.indexOf('.')==0 || email.indexOf('.')>=email.length()-1 || email.lastIndexOf('.')<email.indexOf('@'))
        {
            isOK=false;
            etemail.setError("Wrong Eamil syntax");
        }

        if(isOK)
        {
            signIn(email,passw);
        }
    }
    //6

    /**
     *
     * @param email: this is the email of the owner .
     *
     * @param passw:this is the password of the owner .
     */
    private void signIn(String email, String passw)
    {
        FirebaseAuth auth= FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    /**
                     * this function move the owner from sign in to maps activity.
                     */
                    Intent i=new Intent(getApplicationContext(),MapsActivity.class);
                    startActivity(i);
                }
                else
                {
                    /**
                     * the one gives us note if there is something wrong in the email or the password.
                     */
                    Toast.makeText(getApplicationContext() , "Failed", Toast.LENGTH_SHORT).show();
                    etemail.setError(task.getException().getMessage());
                }
            }
        });
    }


      }

