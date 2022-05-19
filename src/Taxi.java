import java.util.Scanner;

public class Taxi extends Car implements Feature {
    int fee;
    int goalDistance;
    String destination;
    static int basicFee = 3800;
    static int distanceFee = 10;
    static int basicDistance = 2000;
    static int taxiIndex;
    int taxiNum;
    boolean passengerState;

    public Taxi(String destination, int goalDistance, int nowSpeed, int fuelVolume) {
        this.destination = destination;
        this.goalDistance = goalDistance;
        this.nowSpeed = nowSpeed;
        this.fuelVolume = fuelVolume;

        taxiIndex++;
        taxiNum = taxiIndex;
    }

    public boolean run() {
        if (10 >= fuelVolume) {
            System.out.println("주유상태 " + fuelVolume);
            System.out.println("주유량이 10 이상이어야 운행이 가능합니다.");
            state = false;
        } else {
            System.out.println("운행이 가능한 상태입니다.");
            state = true;
        }
        return state;
    }

    public boolean board() {
        run();
        if (state == true && passengerState == false) {
            System.out.println("승객이 탑승하였습니다.");
            System.out.println("운행을 시작합니다.");
        } else if (state == true && passengerState == true)
            System.out.println("이미 택시가 운행중입니다.");
        else
            System.out.println("운행이 불가합니다.");
        return state;
    }

    public int speedChange() {
        System.out.println("변경할 속도를 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        int addSpeed = scanner.nextInt();
        nowSpeed += addSpeed;
        if (0 >= nowSpeed) {
            nowSpeed = 0;
            System.out.println("현재 속도는 0입니다.");
        } else {
            System.out.println("속도를 " + addSpeed + "만큼 변경됩니다.");
            System.out.println("현재 속도는 " + nowSpeed + " 입니다.");
        }
        return nowSpeed;
    }

    public void surcharge() {
        System.out.println("지금 거리를 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        int nowDistance = scanner.nextInt();
        if (basicDistance < nowDistance) {
            int addFee = basicFee + (distanceFee * (nowDistance - basicDistance));
            System.out.println("현재 위치는 기본거리 보다 먼 곳입니다.");
            System.out.println("추가 요금이 붙은 현재 요금은 " + addFee + "원 입니다.");
        } else
            System.out.println("현재 위치는 기본거리 이므로 요금은 " + basicFee + "원 입니다.");
    }

    public void pay() {
        state = false;
        if (goalDistance > basicDistance)
            fee = basicFee + (distanceFee * (goalDistance - basicDistance));
        else
            fee = basicFee;
        System.out.println(destination + "에 도착했습니다.");
        System.out.println("요금은 " + fee + "원 입니다.");
    }

}
