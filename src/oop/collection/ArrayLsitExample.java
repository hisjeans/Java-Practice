package oop.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayLsitExample {
    public static void main(String[] args) {
        String[] arr=new String[50]; //크기 늘어나거나 줄어들지 않음, String 기본값 null

        //배열과 굉장히 유사한데 리스트의 특징 가짐
        List<String> nick=new ArrayList<>();
        //'<>' generic type
        //제너릭(타입의 형식을 지정하여 타입 안정성을 꾀하기 위한 문법)
        //    ArrayList<String> nick=new ArrayList<>(); 가능하지만 변수는 인터페이스 타입으로 주로 선언
        
        //add(객체): 리스트에 객체를 추가하는 메서드
        //리스트는 배열이 아닌 클래스 기반으로 생성된 객체이기 때문에 메서드 호출
        nick.add("멍멍");    //제너릭에 맞춰 메소드 모두 setting됨
        //List nick=new ArrayList<>(); -> nick.add(Object e) 부모타입의 변수로는 자식 객체 선언할 수 없음

        String str="미야오";
        nick.add(str);
        nick.add(new String("개굴"));
        nick.add("꿀꿀"); //리스트는 맨 끝으로 채워나감
        //nick.add(123); (x) string 지정했기 때문
        nick.add("미야오");
        System.out.println("nick = " + nick); //soutv 리스트 내용 전부 확인 가능
        //배열과 공통점: 배열 순차적 저장, 인덱스 사용
        //차이점: 인덱스 지정하지 않아도 지정한 값의 순서대로 넣어줌
        //add(객체): 리스트에 객체를 추가하는 메서드

        nick.add(3,"어흥");
        System.out.println("nick = " + nick); //"꿀꿀" 자리에 "어흥"이 들어가고 "꿀꿀" 은 그 뒤로 밀려남
        //add(인덱스, 객체): 원하는 위치에 객체 삽입
        //중복 허용하는 경우 존재(전달하려고 하는 매개변수 개수, 매개변수 타입, 매개변수 타입 중 하나만 다르더라도 메서드 중복 선언 가능)
        //메서드 중복 선언: 메소드 오버로딩, 생성자 오버로딩 != 오버라이딩: 메서드 재정의, 부모가 물려주는 메서드가 자식에게 맞지 않거나 할 때 메서드 내부 재정의

        //get(인덱스): 리스트 내부의 객체를 참조
        //리스트는 항상 메서드로 접근
        String name=nick.get(3);
        System.out.println("name = " + name); //3번 인덱스 위치한 값 출력

        System.out.println("nick의 크기: "+nick.size());

        //set(인덱스, 수정할 객체): 리스트 내부의 객체를 수정
        nick.set(2, "삐약이"); //"개굴"->"삐약이"
        System.out.println("nick = " + nick);

        //인덱스 지정 가능 -> 반복문 가능
        //리스트 반복문 처리
        for (int i = 0; i < nick.size(); i++) {
            System.out.println(nick.get(i));  //리스트 안 모든 데이터 꺼낼 수 있음
        }

        System.out.println("------------------------------------------------");

        //향상 for문: 항상 모든 요소를 처음부터 끝까지 돌림 != 일반 for문: 범위 지정 가능
        for (String s:nick){
            //list string으로 선언했기 때문에 안에 있는 값 또한 string
            System.out.println(s);
        }

        //contains(객체): 리스트 내의 객체의 존재 유무를 파악
        //if 조건문과 사용 많음
        System.out.println(nick.contains("메뚜기")); //boolean 값 return, 현재는 false return

        //indexOf(객체): 특정 객체의 인덱스 탐색, 없다면 -1 리턴
        int idx=nick.indexOf("짹짹");
        System.out.println("idx = " + idx);

        //remove(객체 or 인덱스): 리스트 내부 객체 삭제
        nick.remove("삐약이");
        nick.remove(0);
        //메서드 중복 선언 오버로딩
        System.out.println("nick = " + nick);

        //clear(): 리스트 내부 요소 전체 삭제
        nick.clear();
        System.out.println("nick = " + nick);
        //리스트가 사라지는 게 아닌 내부 요소만 사라지는 것

        //isEmpty(): 리스트가 비어있는지의 여부 확인
        System.out.println(nick.isEmpty()); //비어 있으면 true, 아니면 false


        System.out.println("---------------------------------------------");


        /*
        # 컬렉션 객체들은 Collections의 기능을 사용할 수 있습니다.
        Collections는 컬렉션 객체들의 부가 기능들을 제공합니다.
         */

        //List<int> score=new ArrayList<>(); 타입 인수는 기본 타입일 수 없음, int는 기본 데이터 타입 -> 객체 타입이어야
        //기본 데이터 타입을 객체 형태로 포장
        List<Integer> score=new ArrayList<>();
        //컬렉션은 객체들의 모음 형식이고, 제너릭도 객체 타입만을 지정하는 것이 가능
        //기본 데이터 타입은 그냥 쓸 수 없고, 기본 데이터 타입의 객체 타입을 명시해 주어야
        //Byte, Short, Integer, Long, Boolean, Character(char를 모아 놓은 리스트)
        //자바 초창기 score.add(new Integer(90)); <- 자바 버전 9 이상에서 지원 중단
        score.add(90); //현재는 객체 포장해서 추가할 필요 없음

        /*

        고정(불변) 리스트 만들어주는 문법

        Collections.addAll: 이미 만들어진 컬렉션에 여러 요소를 추가하는 메서드

        Arrays.asList: add, remove 불가(고정 리스트를 만들어주는 것). set()으로 요소 변경은 가능. null 요소 허용
        예) System.out.println("integerList2 = " + integerList2);
        <<엄격<<
        List.of(): add, remove, set 불가. null 요소 불허. (java 9버전)
         */
        List<Integer> integerList=List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> integerList2=Arrays.asList(1,2,3,4,5,6,7,8,9);
        Collections.addAll(score, 78, 89, 98, 100, 28, 100, 100, 78);
        System.out.println("score = " + score);

        //컬렉션 내의 객체의 수 구하기
        System.out.println("100점 학생 수: "+Collections.frequency(score, 100));


        //최댓값, 최솟값
        System.out.println("최댓값: "+Collections.max(score));
        System.out.println("최솟값: "+Collections.min(score));
        
        //정렬(오름차순)
        Collections.sort(score);
        System.out.println("score = " + score);
        
        //Collections.reverse(score); //단순 역순 배치, 정렬 x
        Collections.sort(score, Collections.reverseOrder()); //내림차순 정렬
        System.out.println("score = " + score);

        //두 요소의 위치를 서로 교체 swap(리스트, i, j)
        Collections.swap(score, 3, 7);
        System.out.println("score = " + score);

        //리스트 내의 요소를 무작위로 섞기
        Collections.shuffle(score);
        System.out.println("score = " + score);

        //원하는 객체로 컬렉션을 전부 초기화
        Collections.fill(score, 100);
        System.out.println("score = " + score);

    }
    

}
