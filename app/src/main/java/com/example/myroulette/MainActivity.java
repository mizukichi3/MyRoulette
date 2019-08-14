package com.example.myroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // ランダムに選ばれた名前
    private TextView randomNameTextView;
    // ルーレットスタートボタン
    private Button rouletteStartButton;
    // 参加者のリスト
    private ArrayList<String> participant = new ArrayList<>();
    // 参加者のリスト クライアント側から入力
    private TextView participantList;
    // 参加者リセットボタン
    private Button participantResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ビューの変数を初期化する
        randomNameTextView = findViewById(R.id.random_name);
        rouletteStartButton = findViewById(R.id.start_roulette);
        participantList = findViewById(R.id.participant_list);
        participantResetButton = findViewById(R.id.reset);

        // 選ばれた参加者の名前を表示する
        rouletteStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRouletteStart();
            }
        });

        // 参加者をリセットする
        participantResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickParticipantReset();
            }
        });
    }

    // rouletteStartButtonが押された時の処理
    private void onClickRouletteStart () {
        Log.d("MainActivity", "onClickRouletteStart");

        // 入力された参加者の名前を取得する
        String participantString = participantList.getText().toString();
        String [] participantArray = participantString.split(" ");
        Log.d("participantList is ", participantString);
        System.out.println(Arrays.asList(participantArray));

        for(int i = 0; i < participantArray.length; i++) {
            System.out.println(i + "番目の要素 =:" + participantArray[i]);
            participant.add(participantArray[i]);
        };

        // selectedParticipantをrandomTextViewに表示する
        Random rnd = new Random();
        int index = rnd.nextInt(participant.size());
        Log.d("MainActivity", participant.get(index));
        randomNameTextView.setText(participant.get(index));
        System.out.println(Arrays.asList(participant));
    }

    // RESETボタンが押された時の処理
    private void onClickParticipantReset () {
        Log.d("MainActivity", "onClickParticipantReset");
        System.out.println(Arrays.asList(participant));
        participant.clear();
        participantList.setText(null);
        randomNameTextView.setText(null);
        System.out.println(Arrays.asList(participant));
    }

}
