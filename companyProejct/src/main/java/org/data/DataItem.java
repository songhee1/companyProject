package org.data;

import java.io.IOException;
import java.util.Map;
import org.domain.Product;

public class DataItem {
    // 싱글톤으로 변경-생성이 아예안되게 바꾸는게 좋을것같다.
    // Hash에 상품은 고정되어있음. Immutable(구글 라이브러리 guava) 개선의여지 있음
    private static Map<Integer, Product> dataItems;

    public static Map<Integer, Product> getDataItems() {
        return dataItems;
    }

    public static void setData() throws IOException {
        dataItems.put(768848, new Product("[STANLEY] GO CERAMIVAC 진공 텀블러/보틀 3종",21000,45));
        dataItems.put(748943, new Product("디오디너리 데일리 세트 (Daily set)",19000,89));
        dataItems.put(779989, new Product("버드와이저 HOME DJing 굿즈 세트",35000,43));
        dataItems.put(779943, new Product("Fabrik Pottery Flat Cup & Saucer - Mint",24900,89));
        dataItems.put(768110, new Product("네페라 손 세정제 대용량 500ml 이더블유지",7000,79));
        dataItems.put(517643, new Product("에어팟프로 AirPods PRO 블루투스 이어폰(MWP22KH/A)",260800,26));
        dataItems.put(706803, new Product("ZEROVITY™ Flip Flop Cream 2.0 (Z-FF-CRAJ-)",38000,81));
        dataItems.put(759928, new Product("마스크 스트랩 분실방지 오염방지 목걸이",2800,85));
        dataItems.put(213341, new Product("20SS 오픈 카라/투 버튼 피케 티셔츠 (6color)",33250,99));
        dataItems.put(377169, new Product("[29Edition.]_[스페셜구성] 뉴코튼베이직 브라렛 세트 (브라1+팬티2)",24900,60));
        dataItems.put(744775, new Product("SHUT UP [TK00112]",28000,35));
        dataItems.put(779049, new Product("[리퍼브/키친마켓] Fabrik Pottery Cup, Saucer (단품)",10000,64));
        dataItems.put(611019, new Product("플루크 new 피그먼트 오버핏 반팔티셔츠 FST701 / 7color M",19800,7));
        dataItems.put(628066, new Product("무설탕 프로틴 초콜릿 틴볼스",12900,8));
        dataItems.put(502480, new Product("[29Edition.]_[스페셜구성] 렉시 브라렛 세트(브라1+팬티2)",24900,41));
        dataItems.put(782858, new Product("폴로 랄프로렌 남성 수영복반바지 컬렉션 (51color)",39500,50));
        dataItems.put(760709, new Product("파버카스텔 연필1자루",200,70));
        dataItems.put(778422, new Product("캠핑덕 우드롤테이블",45000,7));
        dataItems.put(648418, new Product("BS 02-2A DAYPACK 26 (BLACK)",238000,5));

    }
}
