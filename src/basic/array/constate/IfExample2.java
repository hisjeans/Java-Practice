package basic.array.constate;

public class IfExample2 {
    public static void main(String[] args) {
        //다중분기 조건문, false 쪽으로만 갈라지고 있음 else

        int age=25;

        //다중 분기 조건문
        if(age>=20){
            //중첩 if문
            if(age<40){
                System.out.println("청년층입니다.");
            } else if(age<65){
                System.out.println("중장년층입니다.");
            } else { //위 조건들의 그 외, 마지막 else는 조건 붙지 않음
                System.out.println("노년층입니다.");
            }

            //else if 문
        } else if(age>=17){
            System.out.println("고등학생입니다.");
        } else if(age>=14){
            System.out.println("중학생입니다.");
        } else if(age>=8){
            System.out.println("초등학생입니다.");
        }
        else{ //더이상 조건이 없으면 else
            System.out.println("미취학 아동입니다.");
        }
    }
}
