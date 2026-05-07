package basic.array.array;

import java.util.Arrays;

public class Array2D {
    public static void main(String[] args) {

        int[][] arr=new int[3][4]; //2차원 배열
        arr[1][1]=100; //값을 꺼낼 때에도 더블 인덱싱해야
        //System.out.println(Arrays.toString(arr)); 각각의 주소값 확인 가능
        System.out.println(Arrays.deepToString(arr)); //값을 확인할 수 있음
        //선언하고 값을 넣지 않더라도 배열은 초기화됨
        //배열은 선언할 때 각 인덱스 자리의 값이 비어있지 않고 각 타입의 기본값으로 초기화
        //기본값: 정수 0, 실수 0.0, 논리 false, 문자 (공백), 기타(개체, 스트링...) null

        for(int[] a : arr){
            //arr이 각 인덱스마다 배열 덩어리를 가지고 있으니 배열 덩어리를 선언해야
            for(int i:a){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
