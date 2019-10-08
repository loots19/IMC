package com.e.imcactivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mPoidText;
    private EditText mTailleText;
    private RadioButton mMetreBtn;
    private RadioButton mCentimetreBtn;
    private CheckBox mMegaFonction;
    private Button mCalculImcBtn;
    private Button mRaz;
    private TextView mResultat;
    private String mMega = "tu as un corps de rêve";
    private String defaut = "Vous devez cliquer sur le bouton Claculer l'IMC\n" +
            "pour obetenir le résultat";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPoidText =  findViewById(R.id.Poids);
        mTailleText = (EditText) findViewById(R.id.Taille);
        mMetreBtn = (RadioButton) findViewById(R.id.Mètre_btn);
        mCentimetreBtn = (RadioButton) findViewById(R.id.Centimètre_btn);
        mMegaFonction = (CheckBox) findViewById(R.id.Mega_checkbox);
        mCalculImcBtn = (Button) findViewById(R.id.calculer_btn);
        mRaz = (Button) findViewById(R.id.RAZ_btn);
        mResultat = (TextView) findViewById(R.id.Resultat);

        mCalculImcBtn.setOnClickListener(this);
        mMetreBtn.setOnClickListener(this);
        mCentimetreBtn.setOnClickListener(this);
        mRaz.setOnClickListener(this);
        mMegaFonction.setOnClickListener(this);

        mPoidText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mTailleText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == mCalculImcBtn) {
            if (!mMegaFonction.isChecked()) {

                String p = mPoidText.getText().toString();
                String t = mTailleText.getText().toString();
                float pValue = Float.valueOf(p);
                float tValue = Float.valueOf(t);
                if (tValue == 0)
                    Toast.makeText(MainActivity.this, R.string.taille_empty, Toast.LENGTH_SHORT).show();
                else {
                    tValue = (float) +Math.pow(tValue, 2);
                    float imcValue = pValue / tValue;

                    mResultat.setText("imc: " + imcValue);
                }
            } else
                mResultat.setText(mMega);


        } else if (v == mMegaFonction) {
            if (mMegaFonction.isChecked()) ;
            mResultat.setText(mMega);


        } else if (v == mRaz) {
            mPoidText.getText().clear();
            mTailleText.getText().clear();
            mResultat.setText(defaut);


        } else if (v == mMetreBtn) {
            if (mMetreBtn.isChecked()) {
                String t = mTailleText.getText().toString();
                float tValue = Float.valueOf(t);
                tValue = tValue / 100;

                mResultat.setText("" + tValue);


            } else if (v == mCentimetreBtn) {


                } else
                    mResultat.setText("");

            }

        }
    }