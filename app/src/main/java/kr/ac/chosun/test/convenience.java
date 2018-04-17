package kr.ac.chosun.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class convenience extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convenience); //해당 아이디에 자신이 만든 레이아웃의 이름을 쓴다

        ImageButton eat = (ImageButton) findViewById(R.id.eat_btn);
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gotoeat = Uri.parse("https://www.airport.kr/ap/ko/shp/getFoodInfoMain.do");
                Intent goeat = new Intent(Intent.ACTION_VIEW, gotoeat);
                startActivity(goeat); //액티비티 이동
            }
        });

        ImageButton shopping = (ImageButton) findViewById(R.id.shopping_btn);
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gotoshop = Uri.parse("https://www.airport.kr/ap/ko/shp/getDutyInfoMain.do");
                Intent goshop = new Intent(Intent.ACTION_VIEW, gotoshop);
                startActivity(goshop); //액티비티 이동
            }
        });

        ImageButton bath = (ImageButton) findViewById(R.id.shopping_btn);
        bath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gotobath = Uri.parse("https://www.airport.kr/ap/ko/svc/getFacilityMain.do");
                Intent gobath = new Intent(Intent.ACTION_VIEW, gotobath);
                startActivity(gobath); //액티비티 이동
            }
        });

        ImageButton medical = (ImageButton) findViewById(R.id.medical_btn);
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gotomedical = Uri.parse("https://www.airport.kr/ap/ko/svc/getFacilityMain.do");
                Intent gomedical = new Intent(Intent.ACTION_VIEW, gotomedical);
                startActivity(gomedical); //액티비티 이동
            }
        });

        ImageButton telecom = (ImageButton) findViewById(R.id.telecom_btn);
        telecom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gototelecom = Uri.parse("https://www.airport.kr/ap/ko/svc/getFacilityMain.do");
                Intent gotelecom = new Intent(Intent.ACTION_VIEW, gototelecom);
                startActivity(gotelecom); //액티비티 이동
            }
        });

        ImageButton rest = (ImageButton) findViewById(R.id.rest_btn);
        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gotorest = Uri.parse("https://www.airport.kr/ap/ko/svc/getFacilityMain.do");
                Intent gorest = new Intent(Intent.ACTION_VIEW, gotorest);
                startActivity(gorest); //액티비티 이동
            }
        });
    }
}
