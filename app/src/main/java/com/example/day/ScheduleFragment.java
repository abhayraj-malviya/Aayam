package com.example.day;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment implements View.OnClickListener{


    public ScheduleFragment() {
        // Required empty public constructor
    }
    private CardView cardView1,cardView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View x = inflater.inflate(R.layout.fragment_schedule, container, false);
       cardView1 = x.findViewById(R.id.day1);
       cardView2  = x.findViewById(R.id.day2);

       cardView1.setOnClickListener(this);
       cardView2.setOnClickListener(this);
       return x;
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.day1:
                Toast.makeText(getActivity(),"Events By Club", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getContext(),EventsByClubs.class);
                startActivity(intent);
                break;
            case R.id.day2:
                Toast.makeText(getActivity(),"Department Events", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
