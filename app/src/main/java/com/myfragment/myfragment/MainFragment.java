package com.myfragment.myfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.myfragment.myfragment.R.id.textView;

public class MainFragment extends Fragment {

    // このクラス内でだけ参照する値のため、BundleのKEYの値をprivateにする
    private final static String KEY_NAME = "key_name";
    private final static String KEY_BACKGROUND = "key_background_color";
    private TextView mTextView;
    private  String mName="";
    private @ColorInt int mBackgroundColor = Color.TRANSPARENT;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Bundleの値を受け取る際はonCreateメソッド内で行う
        Bundle args = getArguments();
        // Bundleがセットされていなかった時はNullなのでNullチェックをする
        if (args != null) {
            // String型でNameの値を受け取る
            mName = args.getString(KEY_NAME);
            // int型で背景色を受け取る
            mBackgroundColor = args.getInt(KEY_BACKGROUND, Color.TRANSPARENT);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // TextViewをひも付けます
        mTextView = (TextView)view.findViewById(R.id.textView);
        // Buttonのクリックした時の処理を書きます
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
                public void  onClick(View v){
                mTextView.setText(mTextView.getText()+"!");
            }
        });

        // ラストに追加
        // 背景色をセットする
        view.setBackgroundColor(mBackgroundColor);
        // onCreateで受け取った値をセットする
        mTextView.setText(mName);
    }

    @CheckResult
    public static MainFragment createInstance(String name,@ColorInt int color){
        // Fragmentを作成して返すメソッド
        // createInstanceメソッドを使用することで、そのクラスを作成する際にどのような値が必要になるか制約を設けることができる
        MainFragment fragment = new MainFragment();

        Bundle args = new Bundle();
        args.putString(KEY_NAME,name);
        args.putInt(KEY_BACKGROUND,color);

        fragment.setArguments(args);
        return fragment;
    }

}
