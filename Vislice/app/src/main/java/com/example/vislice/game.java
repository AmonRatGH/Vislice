package com.example.vislice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class game extends AppCompatActivity {
    static String [] lahko={"uho","glava","grdo","urška","lep","drag","gumi","hrana","voda","pepsi"};
    static String [] srednje={"jabolko","limona","medvedek","lubenica","vodomet","mercedes","slovenec","arabec","publika","kamper"};
    static String [] tezko={"fantastično","slovenščina","slovenija","maksimalno","petersburg","pikapolonica"," implementacija","heterogena","areyoueventryingmate","bruteforce"};
    static String [] napake=new String[11];
    static int nivo;
    static String beseda;
    static String crtice="";
    StringBuffer sb;
    public static int narobe=0;
    int i=0;
    int random=0;
    private Button button2;
    private Button button1;
    TextView dif;
    TextView besedaText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        dif = (TextView)findViewById(R.id.zahtevnost);
        besedaText=(TextView)findViewById(R.id.beseda);
        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                preveriCrko();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dobiTezavnostInBesedo();
            }
        });
    }

    public void dobiTezavnostInBesedo (){
        nivo=(int)(Math.random()*3+1);
        switch(nivo) {
            case 1:
                beseda = lahko[(int) (Math.random() * lahko.length)];dif.setText("Tezavnost: Lahko");break;
            case 2:
                beseda = srednje[(int) (Math.random() * srednje.length)];dif.setText("Tezavnost: Srednje");break;
            case 3:
                beseda = tezko[(int) (Math.random() * tezko.length)];dif.setText("Tezavnost: Tezko");break;
        }
        for(int i=0;i<beseda.length();i++){
            crtice=crtice+"-";
        }
        besedaText.setText(crtice);
        button2.setEnabled(false);
        sb=new StringBuffer(crtice);
        napake[0]="0";
        napake[1]="0";
        napake[2]="0";
        napake[3]="0";
        napake[4]="0";
        napake[5]="0";
        napake[6]="0";
        napake[7]="0";
        napake[8]="0";
        napake[9]="0";
        napake[10]="0";
    }
    public void preveriCrko(){
        try{
            EditText vnos = (EditText)findViewById(R.id.vnosCrke);
            if(vnos.getText().toString().length() >1){
                Toast.makeText(game.this,"Vnesili ste več kot eno črko!",Toast.LENGTH_SHORT).show();
                vnos.setText("");
            }
            if(Character.isLetter(vnos.getText().toString().charAt(0))==false){
                Toast.makeText(game.this,"Nisi vensel črke!",Toast.LENGTH_SHORT).show();
                vnos.setText("");
            }
        }catch(Exception e){
            Toast.makeText(game.this,"YOUR MESSAGE",Toast.LENGTH_SHORT).show();
        }
    }
}
