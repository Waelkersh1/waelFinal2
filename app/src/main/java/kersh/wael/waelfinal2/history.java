package kersh.wael.waelfinal2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.security.AccessController.getContext;

public class history extends AppCompatActivity {
    private MyrouteAdapter myrouteAdapter;
    private ListView lst ;
    private TextView History2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        lst= findViewById(R.id.lst);
        History2 = findViewById(R.id.History2);
        myrouteAdapter = new MyrouteAdapter(this,R.layout.item_route);
        lst.setAdapter(myrouteAdapter);

    }
    public void readTasksFromFirebase(final String stTosearch)
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();//to connect to database
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get current UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();
        //orderByChild("title").equalTo(stTosearch)// 5+6
        reference.child("tasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                myrouteAdapter.clear();
                for (DataSnapshot d : dataSnapshot.getChildren())
                {
                    Route t=d.getValue(Route.class);
                    Log.d("MYTASK",t.toString());
                    //5 search:
                    if(stTosearch==null || stTosearch.length()==0)
                    {
                        myrouteAdapter.add(t);
                    }
                    else //6 search:
                        if(t.getType().contains(stTosearch))
                            myrouteAdapter.add(t);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    @Override
    public void onResume() {
        super.onResume();
        readTasksFromFirebase("");
        //6 search: delete method calling
        // readTasksFromFirebase("");
    }

}