package kersh.wael.waelfinal2;

import android.content.Context;
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
        ImageButton imageButton1=vitem.findViewById(R.id.btnMap);
        ImageButton imageButton=vitem.findViewById(R.id.BtnDel);
//getting data source
        final Route route  = getItem(position);



        //c
        // ]onnect item view to data source
        tvDistance.setText(route.getLength()+"");
        tvTime.setText(route.getStartDate()+"");
        tvCalories.setText(route.getCalories()+"");






        return vitem;
    }
}
