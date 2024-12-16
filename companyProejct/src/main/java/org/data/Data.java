package org.data;

import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.domain.Product;

public class Data {
    // 싱글톤으로 변경-생성이 아예안되게 바꾸는게 좋을것같다.
    // Hash에 상품은 고정되어있음. Immutable(구글 라이브러리 guava) 개선의여지 있음
//    private static Map<Integer, Integer> amountOfItems;
    private Data(){
    }

    private static class DataSingletonHelper{
        private static final ImmutableMap<Integer, Product> ITEMS;

        static {
            try {
                ITEMS = setItems();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ImmutableMap<Integer, Product> getItems(){
        return DataSingletonHelper.ITEMS;
    }

    private static ImmutableMap<Integer, Product> setItems() throws IOException {
        ImmutableMap<Integer, Product> items =  ImmutableMap.<Integer, Product>builder()
            .put(768848, new Product("[STANLEY] GO CERAMIVAC 진공 텀블러/보틀 3종",21000))
            .put(748943, new Product("디오디너리 데일리 세트 (Daily set)",19000))
            .put(779989, new Product("버드와이저 HOME DJing 굿즈 세트",35000))
            .put(779943, new Product("Fabrik Pottery Flat Cup & Saucer - Mint",24900))
            .put(768110, new Product("네페라 손 세정제 대용량 500ml 이더블유지",7000))
            .put(517643, new Product("에어팟프로 AirPods PRO 블루투스 이어폰(MWP22KH/A)",260800))
            .put(706803, new Product("ZEROVITY™ Flip Flop Cream 2.0 (Z-FF-CRAJ-)",38000))
            .put(759928, new Product("마스크 스트랩 분실방지 오염방지 목걸이",2800))
            .put(213341, new Product("20SS 오픈 카라/투 버튼 피케 티셔츠 (6color)",33250))
            .put(377169, new Product("[29Edition.]_[스페셜구성] 뉴코튼베이직 브라렛 세트 (브라1+팬티2)",24900))
            .put(744775, new Product("SHUT UP [TK00112]",28000))
            .put(779049, new Product("[리퍼브/키친마켓] Fabrik Pottery Cup, Saucer (단품)",10000))
            .put(611019, new Product("플루크 new 피그먼트 오버핏 반팔티셔츠 FST701 / 7color M",19800))
            .put(628066, new Product("무설탕 프로틴 초콜릿 틴볼스",12900))
            .put(502480, new Product("[29Edition.]_[스페셜구성] 렉시 브라렛 세트(브라1+팬티2)",24900))
            .put(782858, new Product("폴로 랄프로렌 남성 수영복반바지 컬렉션 (51color)",39500))
            .put(760709, new Product("파버카스텔 연필1자루",200))
            .put(778422, new Product("캠핑덕 우드롤테이블",45000))
            .put(648418, new Product("BS 02-2A DAYPACK 26 (BLACK)",238000))
            .build();

        setAmountOfItems(items);
        return items;
    }

    private static void setAmountOfItems(ImmutableMap<Integer, Product> items) {
        Objects.requireNonNull(items.get(768848)).setStockAmount(45);
        Objects.requireNonNull(items.get(748943)).setStockAmount(89);
        Objects.requireNonNull(items.get(779989)).setStockAmount(43);
        Objects.requireNonNull(items.get(779943)).setStockAmount(89);
        Objects.requireNonNull(items.get(768110)).setStockAmount(79);
        Objects.requireNonNull(items.get(517643)).setStockAmount(26);
        Objects.requireNonNull(items.get(706803)).setStockAmount(81);
        Objects.requireNonNull(items.get(759928)).setStockAmount(85);
        Objects.requireNonNull(items.get(213341)).setStockAmount(99);
        Objects.requireNonNull(items.get(377169)).setStockAmount(60);
        Objects.requireNonNull(items.get(744775)).setStockAmount(35);
        Objects.requireNonNull(items.get(779049)).setStockAmount(64);
        Objects.requireNonNull(items.get(611019)).setStockAmount(7);
        Objects.requireNonNull(items.get(628066)).setStockAmount(8);
        Objects.requireNonNull(items.get(502480)).setStockAmount(41);
        Objects.requireNonNull(items.get(782858)).setStockAmount(50);
        Objects.requireNonNull(items.get(760709)).setStockAmount(70);
        Objects.requireNonNull(items.get(778422)).setStockAmount(7);
        Objects.requireNonNull(items.get(648418)).setStockAmount(5);
    }
}
