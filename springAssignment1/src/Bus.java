
import java.util.Scanner;

public class Bus extends Car implements Feature {
    public static int maxPassenger = 30;
    int nowPassenger;
    int busNum;
    int busFee;
    static int busIndex;

    Bus(int nowPassenger, int nowSpeed, int fuelVolume) {
        this.nowPassenger = nowPassenger;
        this.nowSpeed = nowSpeed;
        this.fuelVolume = fuelVolume;
        busIndex++;
        busNum = busIndex;
    }

    public boolean stateChange() {
        if (fuelVolume < 10) {
            System.out.println("주유가 필요하다");
            System.out.println("차고지행");
            return state = false;
        } else {
            System.out.println("현재 연료 상태 : " + fuelVolume);
            System.out.println("운행중");
        }

        return state = true;
    }

    public int getOn(int getOnPassenger) {
        int nowFee;
        if (state == false)
            System.out.println("버스가 운행중이지 않습니다.");
        else if (nowPassenger >= maxPassenger)
            System.out.println("버스 수용량이 한계치에 도달해서 탑승이 불가능합니다.");
        else {
            if ((nowPassenger + getOnPassenger) >= maxPassenger) {
                int inPassenger, outPassenger;
                outPassenger = (nowPassenger + getOnPassenger) - maxPassenger;
                inPassenger = getOnPassenger - outPassenger;
                nowFee = inPassenger * busFee;
                System.out.println("버스 수용량이 한계치에 도달했습니다.");
                System.out.println(inPassenger + "분의 승객이 탑승하였습니다.");
                System.out.println("버스 수용량을 넘어선 " + outPassenger + "분의 승객은 탑승하지 못했습니다.");
                System.out.println(nowFee + " 금액에 요금을 받았습니다.");
                return nowPassenger = maxPassenger;
            } else {
                nowPassenger += getOnPassenger;
                nowFee = busFee * getOnPassenger;
                System.out.println("기다리던 모든 승객 "+getOnPassenger+"분 모두 탑승했습니다.");
                System.out.println(nowFee + " 금액에 요금을 받았습니다.");
                System.out.println("현재 승객은 " + nowPassenger + " 입니다.");
                return nowPassenger;
            }
        }
        return nowPassenger;
    }

    @Override
    public int speedChange() {
        System.out.println("변경할 속도를 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        int addSpeed = scanner.nextInt();
        if (fuelVolume < 10) {
            System.out.print("주유량을 확인해 주세요.");
            System.out.println("차고지행");
            state = false;
        } else {
            nowSpeed += addSpeed;
            System.out.println("속도를 " + addSpeed + "만큼 변경됩니다.");
            System.out.println("현재 속도는 " + nowSpeed + " 입니다.");
        }
        return nowSpeed;
    }


}
