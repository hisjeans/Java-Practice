package basic.array.loop;

public class LoopNesting {
    public static void main(String[] args) {

        int total=0;

        //30~100 사이의 소수가 몇 개 있는지 세봐! (for)
        for(int i=30;i<=100;i++){
            int count=0; //i가 바뀔 때마다 나누어 떨어지는 숫자를 새로 새야 하기 때문
            for(int j=1;j<=100;j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count==2){
                total++;
            }
        }
        System.out.println("소수의 개수: "+total+"개");

    }
}
