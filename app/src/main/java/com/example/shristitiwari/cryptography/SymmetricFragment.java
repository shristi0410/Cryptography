package com.example.shristitiwari.cryptography;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SymmetricFragment extends Fragment {

    private EditText msg;
    private EditText secretKey_entered;
    private Button firstSubmit,secondSubmit;
    private TextView encryptedMsg;
    private TextView decreyptedMsg;
    String message , secretKey;

    String output;




    public SymmetricFragment() {
        // Required empty public constructor
    }


    public static String encryptDecrypt(String inputString ,  String xorKey)
    {
        // Any character value will work

        // Define String to store encrypted/decrypted String
        String outputString = "";

        // calculate length of input string
        int len = inputString.length();

        // perform XOR operation of key
        // with every caracter in string
        int key_len=xorKey.length();
        int j=0;
        for (int i = 0; i < len; i++)
        {
            if(j<key_len) {
                outputString = outputString +
                        Character.toString((char) (inputString.charAt(i) ^ xorKey.charAt(j)));
                j++;
            }else {
                j=0;
                outputString = outputString +
                        Character.toString((char) (inputString.charAt(i) ^ xorKey.charAt(j)));
                j++;

            }

        }

        return outputString;
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rview= inflater.inflate(R.layout.fragment_symmetric, container, false);

        /*msg = (EditText) rview.findViewById(R.id.msgSym);
        message = msg.getText().toString();
        secretKey_entered =(EditText)rview.findViewById(R.id.secretKey);
        secretKey=secretKey_entered.getText().toString();
        encryptedMsg = (TextView) rview.findViewById(R.id.encryptedSym);
        decreyptedMsg = (TextView) rview.findViewById(R.id.dencryptedSym);*/
        View firstSubmit=(Button) rview.findViewById(R.id.submit1);
        View secondSubmit=(Button) rview.findViewById(R.id.submit2);

//        rview.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                submit(view);
//            }
//
//        });


        firstSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = (EditText) rview.findViewById(R.id.msgSym);
                secretKey_entered =(EditText)rview.findViewById(R.id.secretKey);
                message = msg.getText().toString();
                Toast.makeText(getActivity().getBaseContext(),message,Toast.LENGTH_SHORT).show();
                secretKey=secretKey_entered.getText().toString();
                encryptedMsg = (TextView) rview.findViewById(R.id.encryptedSym);
                encryptedMsg.setText(encryptDecrypt(message,secretKey));

                Toast.makeText(getActivity().getBaseContext(),"encrypted: "+ encryptDecrypt(message,secretKey),Toast.LENGTH_SHORT).show();
                Log.i("encrypted: ",encryptDecrypt(message,secretKey));

            }
        });


        secondSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output=encryptDecrypt(message,secretKey);
                msg = (EditText) rview.findViewById(R.id.msgSym);
                secretKey_entered =(EditText)rview.findViewById(R.id.secretKey2);
                message = msg.getText().toString();
                secretKey=secretKey_entered.getText().toString();
                decreyptedMsg = (TextView) rview.findViewById(R.id.dencryptedSym);
                decreyptedMsg.setText(encryptDecrypt(output,secretKey));

                Toast.makeText(getActivity().getBaseContext(),"decrypted: "+ encryptDecrypt(output,secretKey),Toast.LENGTH_SHORT).show();
                Log.i("decrypted: ",encryptDecrypt(output,secretKey));
            }
        });

        return rview;
    }

}