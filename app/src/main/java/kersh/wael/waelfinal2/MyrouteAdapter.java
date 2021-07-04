package kersh.wael.waelfinal2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyrouteAdapter extends ArrayAdapter<Route>
{

    public MyrouteAdapter(@NonNull Context context, int resource) {
        super(context, R.layout.item_route);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.item_route,parent,false);
        TextView tvDistance=vitem.findViewById(R.id.itDis);
        TextView tvTime=vitem.findViewById(R.id.itTime);
        TextView tvCalories=vitem.findViewById(R.id.itCal);
        ImageButton DEL=vitem.findViewById(R.id.BtnDel);
//getting data source
        final Route route  = getItem(position);
        DEL.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       //todo delete this item
                                       FirebaseAuth auth = FirebaseAuth.getInstance();
                                       route.setOwner(auth.getCurrentUser().getUid());
                                       // to get the database root reference
                                       DatabaseReference reference = FirebaseDatabase.getInstance().getReference();


                                       reference.child(auth.getCurrentUser().getUid()).child("MyRoutes").child(route.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                                           @Override
                                           public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                               if (databaseError == null) {
                                                   Toast.makeText(getContext(), "deleted", Toast.LENGTH_SHORT).show();

                                               } else {
                                                   Toast.makeText(getContext(), "not deleted:" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                                               }
                                           }
                                       });


                                   }

                               });



        //c
        // ]onnect item view to data source
        tvDistance.setText(route.getLength()+"");
        tvDistance.setTextColor(Color.BLACK);
        tvTime.setText(route.getStartDate()+"");
        tvCalories.setText(route.getCalories()+"");






        return vitem;
    }
}
