package com.example.day;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    private TextView txtTimerDay,txtTimerHour,txtTimerMinute,txtTimerSecond;
    private TextView tvEvent;
    private Handler handler;
    private Runnable runnable;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view =inflater.inflate(R.layout.fragment_home, container, false);
        txtTimerDay=(TextView)view.findViewById(R.id.txtTimerDay);
        txtTimerHour=(TextView)view.findViewById(R.id.txtTimerHour);
        txtTimerMinute=(TextView)view.findViewById(R.id.txtTimerMinute);
        txtTimerSecond=(TextView)view.findViewById(R.id.txtTimerSecond);
        tvEvent=(TextView)view.findViewById(R.id.tvhappyevent);
        countDownStart();
       return  view;
    }

    private void countDownStart() {
        handler=new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {

                handler.postDelayed(this, 1000);
                try {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date futureDate = dateFormat.parse("2020-03-14");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime() - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / ( 60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText("" + String.format("%02d", minutes));
                        txtTimerSecond.setText("" + String.format("%02d", seconds));


                    } else {
                        tvEvent.setVisibility(View.VISIBLE);
                        tvEvent.setText("The event has started");
//                        View view;
                        textViewGone();
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }


            }
        };
        handler.postDelayed(runnable,1*1000);
    }

    private void textViewGone() {
        view.findViewById(R.id.linearLayout10).setVisibility(View.GONE);
        view.findViewById(R.id.linearLayout11).setVisibility(View.GONE);
        view.findViewById(R.id.linearLayout12).setVisibility(View.GONE);
        view.findViewById(R.id.linearLayout13).setVisibility(View.GONE);
        view.findViewById(R.id.textView).setVisibility(View.GONE);
        view.findViewById(R.id.txt_textView2).setVisibility(View.GONE);
    }

}
