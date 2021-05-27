package kersh.wael.waelfinal2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



public class signup extends AppCompatActivity {
    EditText etEmail, etPhone, etFirstName, etLastName, etPassword, etPassword2;
    Button btnsave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etPassword2 = findViewById(R.id.etPassword2);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        btnsave = findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//class without name
                checkForm();
                btnsave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkForm();
                    }
                });            }
        });
    }

    /**
     * המתודה בודקת תקינות טופם ההרשמה ואם תקין מבצעת הרשמה\The method checks the correctness of the registration top and whether it is correct performs the registration
     */
    private void checkForm() {
        String PhoneNumber = etPhone.getText().toString();
        String Email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String password2 = etPassword2.getText().toString();
        String FirstName = etFirstName.getText().toString();
        String LastName = etLastName.getText().toString();

        boolean isOk = true;


        if (FirstName.length() < 2) {
            isOk = false;
            etFirstName.setError("at least two letters");
        }
        if (LastName.length() < 2) {
            isOk = false;
            etLastName.setError("at least two letters");
        }
        if (Email.length() < 5 || Email.indexOf('@') == 0 || Email.indexOf('@') >= Email.length() - 2 ||
                Email.indexOf('.') == 0 || Email.indexOf('.') >= Email.length() - 1 || Email.lastIndexOf('.') < Email.indexOf('@')) {
            isOk = false;
            etEmail.setError("wrong Email syntax");
        }
        if (password.equals(password2) == false) {
            isOk = false;
            etPassword.setError("Password must ne the same");
        } else {
            //MyValidation myValidations=new MyValidations();
            if (password.length() < 8 || password.indexOf(' ') >= 0) {
                isOk = false;
                etPassword.setError("Invalid Password");
            }
        }
        if (isOk)// isOk = true
        {
            // todo: create account and return to sign in screen/ close this screen
            createNewAccount(Email, FirstName, LastName, password, PhoneNumber);
        }


    }

    private void saveTask(MyValidations myTask) {
        //1.
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //2.
        DatabaseReference reference = database.getReference();
        //3. user id
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String uid = auth.getCurrentUser().getUid();
        //4. My Object Key
        String key = reference.child("AllTasks").push().getKey();
        //5. Update Your Object
        myTask.setOwner(uid);
        myTask.setKey(key);
        //6. Actual Stroring
        reference.child("AllTasks").child(uid).child(key).setValue(myTask).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonN


                                           ull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"add successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(AddMedicineActivity.this,"add successful"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });

    }
}

    /**
     * @param gmail
     * @param firstName
     * @param lastName
     * @param password
     * @param phone
     */

    private void createNewAccount(String gmail, String firstName, String lastName, String password, String phone) {
        FirebaseAuth auth = FirebaseAuth.getInstance(); // אחראית על רישום וכניסת משתמשים
    }

    public EditText getEtEmail() {
        return etEmail;
    }

    public void setEtEmail(EditText etEmail) {
        this.etEmail = etEmail;
    }

    public EditText getEtPhone() {
        return etPhone;
    }

    public void setEtPhone(EditText etPhone) {
        this.etPhone = etPhone;
    }

    public EditText getEtFirstName() {
        return etFirstName;
    }

    public void setEtFirstName(EditText etFirstName) {
        this.etFirstName = etFirstName;
    }

    public EditText getEtLastName() {
        return etLastName;
    }

    public void setEtLastName(EditText etLastName) {
        this.etLastName = etLastName;
    }

    public EditText getEtPassword() {
        return etPassword;
    }

    public void setEtPassword(EditText etPassword) {
        this.etPassword = etPassword;
    }

    public EditText getEtPassword2() {
        return etPassword2;
    }

    public void setEtPassword2(EditText etPassword2) {
        this.etPassword2 = etPassword2;
    }

    public Button getBtnsave() {
        return btnsave;
    }

    public void setBtnsave(Button btnsave) {
        this.btnsave = btnsave;
    }
}
