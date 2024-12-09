package org.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.domain.Product;

public class DataItem {
    private static Map<Integer, Product> map = new HashMap<>();
    public static Map<Integer, Product> getMap() {
        return map;
    }

    public static void setData() throws IOException {
        map.put(768848, new Product("[STANLEY] GO CERAMIVAC 진공 텀블러/보틀 3종",21000,45));
        map.put(748943, new Product("디오디너리 데일리 세트 (Daily set)",19000,89));
        map.put(779989, new Product("버드와이저 HOME DJing 굿즈 세트",35000,43));
        map.put(779943, new Product("Fabrik Pottery Flat Cup & Saucer - Mint",24900,89));
        map.put(768110, new Product("네페라 손 세정제 대용량 500ml 이더블유지",7000,79));
        map.put(517643, new Product("에어팟프로 AirPods PRO 블루투스 이어폰(MWP22KH/A)",260800,26));
        map.put(706803, new Product("ZEROVITY™ Flip Flop Cream 2.0 (Z-FF-CRAJ-)",38000,81));
        map.put(759928, new Product("마스크 스트랩 분실방지 오염방지 목걸이",2800,85));
        map.put(213341, new Product("20SS 오픈 카라/투 버튼 피케 티셔츠 (6color)",33250,99));
        map.put(377169, new Product("[29Edition.]_[스페셜구성] 뉴코튼베이직 브라렛 세트 (브라1+팬티2)",24900,60));
        map.put(744775, new Product("SHUT UP [TK00112]",28000,35));
        map.put(779049, new Product("[리퍼브/키친마켓] Fabrik Pottery Cup, Saucer (단품)",10000,64));
        map.put(611019, new Product("플루크 new 피그먼트 오버핏 반팔티셔츠 FST701 / 7color M",19800,7));
        map.put(628066, new Product("무설탕 프로틴 초콜릿 틴볼스",12900,8));
        map.put(502480, new Product("[29Edition.]_[스페셜구성] 렉시 브라렛 세트(브라1+팬티2)",24900,41));
        map.put(782858, new Product("폴로 랄프로렌 남성 수영복반바지 컬렉션 (51color)",39500,50));
        map.put(760709, new Product("파버카스텔 연필1자루",200,70));
        map.put(778422, new Product("캠핑덕 우드롤테이블",45000,7));
        map.put(648418, new Product("BS 02-2A DAYPACK 26 (BLACK)",238000,5));

    }
}
