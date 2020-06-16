package com.example.shristitiwari.cryptography;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class AsymmetricFragment extends Fragment {
    int PublicKey,PrivateKey;
    int[] enc = new int[35];
    char temp;




    public AsymmetricFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_asymmetric, container, false);

        final EditText publicKey=(EditText) view.findViewById(R.id.publicKey);
        final EditText privateKey =(EditText) view.findViewById(R.id.privateKey);
        final EditText msg=(EditText) view.findViewById(R.id.msgSym);
        final EditText encryptionKey=(EditText) view.findViewById(R.id.encryptionKey);
        final EditText decryptionKey=(EditText) view.findViewById(R.id.dencryptionKey);
        final TextView encrypted=(TextView) view.findViewById(R.id.encryptedMsg);
        final TextView decrypted=(TextView) view.findViewById(R.id.decryptedMsg);




        View generateKeys= (Button) view.findViewById(R.id.generateKeys);
        View encodeMsg= (Button) view.findViewById(R.id.encodeMsg);
        View decodeMsg= (Button) view.findViewById(R.id.decodeMsg);

        generateKeys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date now = new Date();
                long nowlong = now.getTime()%256;
                int gen = (int)(long)nowlong;
                PublicKey = gen;
                PrivateKey = 256 - gen;

                publicKey.setText(Integer.toString(PublicKey));
                privateKey.setText(Integer.toString(PrivateKey));
            }
        });

        encodeMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=msg.getText().toString();
                String key =encryptionKey.getText().toString();

                int length = message.length();
                String encValue = "";

                for(int i=0; i<length;i++) {
                    temp = message.charAt(i);
                    enc[i]= (int) temp;
                    for(int j=0;j<Integer.parseInt(key);j++) {
                        enc[i]++;
                    }
                    encValue+=enc[i];
                }

                encrypted.setText(encValue);

            }
        });

        decodeMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=msg.getText().toString();
                int length = message.length();
                String key = decryptionKey.getText().toString();
                int decryptionKey = Integer.parseInt(key)-256;
                String decrypValue = "";
                int DecTemp;
                for(int k=0;k<length;k++) {
                    DecTemp = (enc[k]+decryptionKey)%256;
                    char tempo = (char)DecTemp;
                    decrypValue+= tempo;
                }

                decrypted.setText(decrypValue);


            }
        });








        return view;
    }

}
