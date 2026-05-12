package oop.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {

        /*
        # Map
        - Key / Value가 한 세트를 이루는 자료구조
        - Key값을 통해 Value를 참조하는 방식 (인덱스 x)
        - Key는 중복 저장을 허용하지 않는다.
        - 2개의 값이 굉장히 밀접한 연관 띠고 있을 때 두 값을 하나의 덩어리로 저장하고자 할 때 사용한다.
        - 인덱스 제공하지 않는다.
         */

        // Map은 Key, Value 쌍을 이루기 때문에 멀티 제네릭을 선언.
        // Map interface
        Map<String, String> map=new HashMap<>();
        map.put("므엉", "한유진");
        map.put("냐옹", "마에다");
        map.put("음머", "오시온"); //key, value는 독립해 존재할 수 없음
        System.out.println("map = " + map);

        map.put("므엉", "후지나가"); //key 중복 사용해 데이터 집어 넣으면 기존의 key 값에 마지막으로 대입한 값 넣음, value 중복은 문제 없음 because, key 값으로 구분 가능
        map.put("어흥", "구정모");
        System.out.println("map = " + map);
        //key를 중복 사용해 put을 호출하면 기존 key에 맵핑된 value 수정됨

        //key의 존재 유무를 확인
        //value 얻기: get(key)
        String nick="므엉";

        /*
        String name=map.get(nick);
        System.out.println("name = " + name);
        null 위험
         */

        if(map.containsKey(nick)){
            System.out.printf("별명이 %s인 학생의 이름은 %s입니다.\n", nick, map.get(nick));
        } else{ //false-> key값 존재하지 않음
            System.out.println("그런 별명은 없는데요");
        }


        //향상 for문 for(String s: map){ } (x)
        //map은 일반 for문 또한 (x), 맵 자체가 인덱스 제공하지 않기 때문
        //=> Map에서 Key들만 추출하는 메서드 keySet()
        //모든 Key를 Set에 담아 반환 -> 향상 for문 사용 가능
        for(String k:map.keySet()){ //key만 있는 상태에서 map에서 value 꺼내옴
            System.out.printf("key: %s, value: %s\n", k, map.get(k)); //단축키 soutf
        }

        System.out.println("=======================================================");

        //entrySet() 메서드는 key와 value를 하나의 묶음(Map.Entry)으로 취급하고
        //그 묶음들을 set으로 담아 전달
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //entry는 key와 value 하나의 묶음으로 출력
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.printf("key: %s, value: %s\n", key, value);
        }

        //Map의 객체 삭제: remove(key)
        //key를 주면 value도 함께 제거
        map.remove("냐옹");
        System.out.println("map = " + map);

        map.clear();

        //Collections.addAll(map, "1", "2", "3", "4");
        //Collection 메소드와 연관이 없기 때문에 map은 collections.addAll(map, "1,"...) 전달 자체가 되지 않음
        //Collections의 메서드는 Collection 인터페이스 타입을 전달받기 때문에 Map은 사용이 힘듦
    }
}
