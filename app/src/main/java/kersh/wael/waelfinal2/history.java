package kersh.wael.waelfinal2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class history extends AppCompatActivity {

    private ListView lst ;
    private TextView History2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        lst= findViewById(R.id.lst);
        History2 = findViewById(R.id.History2);


    }
}