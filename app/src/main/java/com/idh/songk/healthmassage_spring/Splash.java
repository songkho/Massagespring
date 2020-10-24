package com.idh.songk.healthmassage_spring;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

    protected void onCreate(Bundle savedInstanceState){

        //BitmapDrawable bd = (BitmapDrawable)getResources().getDrawable(R.mipmap.lsp2);

        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(1900);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
        finish();

    }


}
