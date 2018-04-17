package kr.ac.chosun.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;

public class MainActivity extends Activity {

    //cgtdt 혼잡일자 //조회일자YYYYMMDD
    //cgthm 혼잡일시 //업데이트시간 HHMM
    //gate1 2번 출국장 혼잡도
    //gate2 3번 출국장 혼잡도
    //gate3 4번 출국장 혼잡도
    //gate4 5번 출국장 혼잡도
    //gateinfo1 2번 출국장 대기인원수
    //gateinfo2 3번 출국장 대기인원수
    //gateinfo3 4번 출국장 대기인원수
    //gateinfo4 5번 출국장 대기인원수


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton congestion = (ImageButton) findViewById(R.id.congestion_button); //해당 버튼을 지정합니다.
        congestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 눌렸을 때
                Intent intent = new Intent(MainActivity.this, congestion.class);
                startActivity(intent); //액티비티 이동
            }
        });

        ImageButton landing = (ImageButton) findViewById(R.id.flight_land_button); //해당 버튼을 지정합니다.
        landing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 눌렸을 때
                Intent intent = new Intent(MainActivity.this, landing.class);
                startActivity(intent); //액티비티 이동
            }
        });

        ImageButton delay = (ImageButton) findViewById(R.id.delay_button); //해당 버튼을 지정합니다.
        delay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 눌렸을 때
                Intent intent = new Intent(MainActivity.this, delay.class);
                startActivity(intent); //액티비티 이동
            }
        });

        ImageButton parking = (ImageButton) findViewById(R.id.parking_button); //해당 버튼을 지정합니다.
        parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 눌렸을 때
                Intent intent = new Intent(MainActivity.this, parking.class);
                startActivity(intent); //액티비티 이동
            }
        });

        ImageButton takeoff = (ImageButton) findViewById(R.id.flight_takeoff_button); //해당 버튼을 지정합니다.
        takeoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 눌렸을 때
                Intent intent = new Intent(MainActivity.this, takeoffinfo.class);
                startActivity(intent); //액티비티 이동
            }
        });

        ImageButton convenience = (ImageButton) findViewById(R.id.convienience_button); //해당 버튼을 지정합니다.
        convenience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 눌렸을 때
                Intent intent = new Intent(MainActivity.this, convenience.class);
                startActivity(intent); //액티비티 이동
            }
        });

        StrictMode.enableDefaults();

        TextView status1 = (TextView)findViewById(R.id.status1); //파싱된 결과확인!
        TextView status2 = (TextView)findViewById(R.id.status2);
        TextView status3 = (TextView)findViewById(R.id.status3);
        TextView status4 = (TextView)findViewById(R.id.status4);

        boolean initem = false, inAreadiv = false, inCgtdt = false, inCgthm =false, inGateinfo1 = false, inGateinfo2 = false, inGateinfo3 = false, inGateinfo4 = false;

        String areadiv = null, cgtdt = null, cgthm = null, gateinfo1= null, gateinfo2 = null, gateinfo3 = null, gateinfo4 = null;


        try{

            URL url = new URL("http://openapi.airport.kr/openapi/service/StatusOfDepartures/getDeparturesCongestion?ServiceKey=" +
                    "Nb%2BV2BcVQ%2BjSh4zZQkvreUtW0lbjoMq4kmUkR3Inc0OHZXmUTxvqXKaDhBoqvV0HGIx0%2BodRUS8K4Vyg7qiOwg%3D%3D"
            ); //검색 URL부분

            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance(); // 위에서 생성된 URL을 통하여 서버에 요청하면 결과가 XML Resource로 전달됨
            XmlPullParser parser = parserCreator.newPullParser(); //XML Resource 를 파싱할 parser를 parserCreator로 생성

            parser.setInput(url.openStream(), null); // 파서 통하여 각 요소들의 이벤트성 처리를 반복수행


            int parserEvent = parser.getEventType();
            System.out.println("파싱시작합니다.");

            while (parserEvent != XmlPullParser.END_DOCUMENT){ //XML문이 끝날 때까지 정보를 읽는다.

                switch(parserEvent){
                    case XmlPullParser.START_TAG: //parser가 시작 태그를 만나면 실행
                        if(parser.getName().equals("areadiv")){ //title 만나면 내용을 받을수 있게 하자
                            System.out.println("여기는 걸리나?");
                            inGateinfo1 = true;
                        }
                        if(parser.getName().equals("cgtdt")){ //address 만나면 내용을 받을수 있게 하자
                            inCgtdt = true;
                        }
                        if(parser.getName().equals("cgthm")){ //address 만나면 내용을 받을수 있게 하자
                            inCgthm = true;
                        }
                        if(parser.getName().equals("gateinfo2")){ //address 만나면 내용을 받을수 있게 하자
                            inGateinfo2 = true;
                        }
                        if(parser.getName().equals("gateinfo3")){ //mapx 만나면 내용을 받을수 있게 하자
                            inGateinfo3 = true;
                        }
                        if(parser.getName().equals("gateinfo4")){ //mapy 만나면 내용을 받을수 있게 하자
                            inGateinfo4 = true;
                        }
                        if(parser.getName().equals("message")){ //message 태그를 만나면 에러 출력
                            status1.setText(status1.getText()+"에러");
                            //여기에 에러코드에 따라 다른 메세지를 출력하도록 할 수 있다.
                        }
                        break;

                    case XmlPullParser.TEXT://parser가 내용에 접근했을때
                        if(inAreadiv){ //isTitle이 true일 때 태그의 내용을 저장.
                            areadiv = parser.getText();
                            inAreadiv = false;
                        }
                        if(inCgtdt){ //isTitle이 true일 때 태그의 내용을 저장.
                            cgtdt = parser.getText();
                            inCgtdt = false;
                        }
                        if(inCgthm){ //isTitle이 true일 때 태그의 내용을 저장.
                            cgthm = parser.getText();
                            inCgthm = false;
                        }
                        if(inGateinfo1){ //isTitle이 true일 때 태그의 내용을 저장.
                            gateinfo1 = parser.getText();
                            inGateinfo1 = false;
                        }
                        if(inGateinfo2){ //isAddress이 true일 때 태그의 내용을 저장.
                            gateinfo2 = parser.getText();
                            inGateinfo2 = false;
                        }
                        if(inGateinfo3){ //isMapx이 true일 때 태그의 내용을 저장.
                            gateinfo3 = parser.getText();
                            inGateinfo3 = false;
                        }
                        if(inGateinfo4){ //isMapy이 true일 때 태그의 내용을 저장.
                            gateinfo4 = parser.getText();
                            inGateinfo4 = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")){

                            status1.setText(status1.getText()+ gateinfo1 + "명");
                            status2.setText(status2.getText()+gateinfo2 + "명");
                            status3.setText(status3.getText()+gateinfo3 + "명");
                            status4.setText(status4.getText()+gateinfo4 + "명");

                        }
                        break;
                }
                parserEvent = parser.next();
            }
        } catch(Exception e) {
            status1.setText("에러가..났습니다...");

        }
    }
}







