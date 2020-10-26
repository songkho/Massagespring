package com.idh.songk.healthmassage_spring;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private AdView mAdView;

    private InterstitialAd mInterstitialAd;
//    RewardedVideoAd mRewardedVideoAd;


    Vibrator vib;
    TextView sharetv, tv7;
    TextView shareEnglish;
    LinearLayout sharelay;
    Button btn7;

    ToggleButton tb1;
    ImageButton ibtn0;
    ImageButton ibtn;
    ImageButton ibtn2;
    ImageButton ibtn3;
    ImageButton ibtn4;

    private final long FINSH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    private Button bt_tab1, bt_tab2;

    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINSH_INTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
            vib.cancel();
        } else {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "'뒤로'버튼을한번더누르시면종료됩니다.\n     Click the'Back' button again to finish.", Toast.LENGTH_SHORT).show();
        }
    }


//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btn7 = (Button)findViewById(R.id.go) ;
//        tv7 = (TextView)findViewById(R.id.textView8);

        sharetv = (TextView) findViewById(R.id.sharetv);
        shareEnglish = (TextView) findViewById(R.id.shareE);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/jua.ttf");  //asset > fonts 폴더 내 폰트파일 적용
        sharetv.setTypeface(typeFace);
        shareEnglish.setTypeface(typeFace);
        ImageView img3 = (ImageView) findViewById(R.id.imageView3);
        sharelay = (LinearLayout) findViewById(R.id.sharelay);
        sharelay.setOnClickListener(this);


        MobileAds.initialize(this, "ca-app-pub-2821664824480291~6015055926");

////////////////// 하단 광고 ////////////////////////
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);


        ////////////////// 하단 광고 끝 ////////////////////////


        //////////////// 전면 광고 시작 ////////////////////////


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2821664824480291/3728885504");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("asd", "The interstitial wasn't loaded yet.");
                }
            }
        });


        //////////////// 전면 광고 끝 ////////////////////////


//        ////////////////// 리워드 광고 시작 ////////////////////////
//
//
//        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
//        mRewardedVideoAd.setRewardedVideoAdListener((RewardedVideoAdListener) this);
//        mRewardedVideoAd.loadAd("ca-app-pub-2821664824480291/2041135758", new AdRequest.Builder().build());
//
//        ////////////////// 리워드 광고 ////////////////////////


//        btn7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                btn7.setEnabled(false);
//                if(mRewardedVideoAd.isLoaded()){
//                    mRewardedVideoAd.show();
//                }
//
//            }
//        });
//
//               final ToggleButton tb1 = (ToggleButton) this.findViewById(com.idh.songk.healthmassage_spring.R.id.tb);

        final Button btn2 = (Button) findViewById(R.id.on);


        final Button btn3 = (Button) findViewById(R.id.stop);


        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long[] pattern = {0, 500, 0, 500};
                vib.vibrate(pattern, 0);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vib.cancel();

            }
        });


//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                long[] pattern = {0, 500, 0, 500};
//                vib.vibrate(pattern, 0);
//
//                if (  true ) {
//                    img.setBackgroundDrawable(getResources().getDrawable(com.idh.songk.healthmassage_spring.R.drawable.on2)
//
//                    );
//                }  else {
//                    vib.cancel();
//                    img.setBackgroundDrawable(getResources().getDrawable(com.idh.songk.healthmassage_spring.R.drawable.off2)
//                    );
//                } // end if
//
//            }
//        });


//        img.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                long[] pattern = {0, 500, 0, 500};
//                vib.vibrate(pattern, 0);
//
//                if (tb1.isChecked()) {
//                    tb1.setBackgroundDrawable(getResources().getDrawable(com.idh.songk.healthmassage_spring.R.drawable.on2)
//
//                    );
//                }  else {
//                    vib.cancel();
//                    tb1.setBackgroundDrawable(getResources().getDrawable(com.idh.songk.healthmassage_spring.R.drawable.off2)
//                    );
//                } // end if
//            } // end onClick()
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sharelay:
                Intent msg = new Intent(Intent.ACTION_SEND);
                msg.addCategory(Intent.CATEGORY_DEFAULT);
                msg.putExtra(Intent.EXTRA_SUBJECT, "https://play.google.com/store/apps/details?id=com.idh.songk.healthmassage_spring");
                msg.putExtra(Intent.EXTRA_TEXT, "");
                msg.putExtra(Intent.EXTRA_TITLE, "제목");
                msg.setType("text/plain");
                startActivity(Intent.createChooser(msg, "공유"));
                break;
        }
    }

//    @Override
//    public void onRewardedVideoAdLoaded() {
//        tv7.append("\n처음 사용자는 사용 TIP 버튼을 눌러 주세요. \n광고 시청 완료 후 사용법이 나옵니다 \n");
//        btn7.setEnabled(true);
//
//    }
//
//    @Override
//    public void onRewardedVideoAdOpened() {
//
//    }
//
//    @Override
//    public void onRewardedVideoStarted() {
//
//    }
//
//    @Override
//    public void onRewardedVideoAdClosed() {
//
//        mRewardedVideoAd.loadAd("ca-app-pub-2821664824480291/4152267770", new AdRequest.Builder().build());
//
//
//    }
//
//    @Override
//    public void onRewarded(RewardItem rewardItem) {
//
//        tv7.append("\n사용법.\n");
//        tv7.append(String.format(Locale.getDefault(),
//                "가운데 터치시 무한진동!\n사랑합니다!♥ 뀨♥\n", rewardItem.getAmount(), rewardItem.getType()  ));
//
//
//    }
//
//    @Override
//    public void onRewardedVideoAdLeftApplication() {
//        tv7.append("An ad has ideoAdLeftApplication.\n");
//
//
//    }
//
//    @Override
//    public void onRewardedVideoAdFailedToLoad(int i) {
//        tv7.append("광고 시청을 완료해 주세요.\n");
//    }
//
//    @Override
//    public void onRewardedVideoCompleted() {
//
//    }
}

