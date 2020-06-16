package com.example.shristitiwari.cryptography;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class StimulationFragment extends Fragment {
    public Button button;


    public StimulationFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_stimulation,
                container, false);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity().getBaseContext(),"Successful!!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),MainStimulationActivity.class);
                startActivity(intent);

            }
        });
        return view;

    }

}
