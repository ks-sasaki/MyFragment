package com.myfragment.myfragment;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//https://qiita.com/Reyurnible/items/dffd70144da213e1208b#2%E3%81%A4%E7%9B%AE%E3%82%B3%E3%83%BC%E3%83%89%E3%81%8B%E3%82%89%E5%8B%95%E7%9A%84%E3%81%AB%E8%BF%BD%E5%8A%A0
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //コードからFragmentを追加(com.myfragment.myfragment.MainFragment)
        MainFragment fragment = new MainFragment();
        //Fragmentの変更にはTransactionを使用する
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //@Fragment要素のID,追加するFragment変数
        transaction.add(R.id.container, MainFragment.createInstance("hoge", Color.RED));
        transaction.commit();
    }
}
