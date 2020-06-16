package com.example.shristitiwari.cryptography;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RSAFragment extends Fragment {
    private ImageButton addOne, subtractOne;
    EditText msg;
    String message;
    int msgTxt;
    int count,p,q,n,e,phi;
    double d;


    public RSAFragment() {
        // Required empty public constructor
    }

    public int getPrime(){
        int primes[]={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,

                73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127,  137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239,

                241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397};
        int index=(int)Math.floor(Math.random() * primes.length);

        return(primes[index]);
    }


    static int gcd(int e, int z)
    {
        if(e==0)
            return z;
        else
            return gcd(z%e,e);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_rsa, container, false);


        final TextView genratedP =(TextView) view.findViewById(R.id.generatedP);
        final TextView genratedQ =(TextView) view.findViewById(R.id.generatedQ);

        final TextView genratedN =(TextView) view.findViewById(R.id.generatedN);
        final TextView genratedPHI =(TextView) view.findViewById(R.id.generatedPHI);
        final TextView genratedE =(TextView) view.findViewById(R.id.generatedE);
        final TextView genratedD =(TextView) view.findViewById(R.id.generatedD);
        final TextView genratedPublicKey =(TextView) view.findViewById(R.id.generatedPublicKey);
        final TextView genratedPrivateKey =(TextView) view.findViewById(R.id.generatedPrivateKey);
        final TextView genratedEncrypt =(TextView) view.findViewById(R.id.generatedEncrypt);
        final TextView genratedDecrypt =(TextView) view.findViewById(R.id.generatedDecrypt);


        addOne=(ImageButton) view.findViewById(R.id.plusOne);
        subtractOne=(ImageButton) view.findViewById(R.id.SubtractOne);
        msg =(EditText) view.findViewById(R.id.msgSym);


        View generatePQ =(Button) view.findViewById(R.id.generatePQ);
        View generateNPHIE =(Button) view.findViewById(R.id.generateNPHIE);
        View generateKeys =(Button) view.findViewById(R.id.generatekeys);
        View encryptDecrypt =(Button) view.findViewById(R.id.encryptDecrypt);

        generatePQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p=getPrime();
                q= getPrime();
                if(p == q){
                    while(p==q){
                        q=getPrime();
                    }
                }
                genratedP.setText(Integer.toString(p));
                genratedQ.setText(Integer.toString(q));


            }
        });

        generateNPHIE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=p*q;
                genratedN.setText(Integer.toString(n));
                phi=(p-1)*(q-1);
                genratedPHI.setText(Integer.toString(phi));

                for(e=2;e<phi;e++)
                {
                    if(gcd(e,phi)==1)            // e is for public key exponent
                    {
                        break;
                    }
                }

                genratedE.setText(Integer.toString(e));
            }
        });


        generateKeys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=1/(Double.valueOf(e));

                genratedD.setText(Double.toString(d));
                String publicKey ="("+Integer.toString(n)+","+Integer.toString(e)+")";
                String privateKey ="("+Integer.toString(n)+","+Double.toString(d)+")";

                genratedPublicKey.setText(publicKey);

                genratedPrivateKey.setText(privateKey);
            }
        });


        addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+1;
                msg.setText(Integer.toString(count), TextView.BufferType.EDITABLE);


            }
        });

        subtractOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==0){
                    msg.setText(Integer.toString(count), TextView.BufferType.EDITABLE);
                }else{
                count=count-1;
                msg.setText(Integer.toString(count), TextView.BufferType.EDITABLE);}


            }
        });

        encryptDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int message=Integer.parseInt(msg.getText().toString());
                double cipher=Math.pow(message,e);
                cipher=cipher%n;
                genratedEncrypt.setText(Double.toString(cipher));

                double decrypt=Math.pow(cipher,d);
                decrypt=decrypt%n;
                genratedDecrypt.setText(Integer.toString((int)decrypt));



            }
        });






        return view;

    }

}
