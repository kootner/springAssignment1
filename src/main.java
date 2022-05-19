
public class main {
    public static void main(String args[]) {
        SeoulBus green1 = new SeoulBus(5,20,50);
        SeoulBus green2 = new SeoulBus(10,30,40);
        SeoulTaxi orange1 = new SeoulTaxi("수원",4000,40,80);
        SeoulTaxi orange2 = new SeoulTaxi("강남", 1500,30,50);

        green1.speedChange();
        System.out.println(green1.busNum);
        System.out.println(green2.busNum);
        green1.getOn(10);
        System.out.println(green1.nowPassenger);
        green2.stateChange();

        orange1.speedChange();
        System.out.println(orange1.nowSpeed);
        System.out.println(orange1.taxiNum);
        System.out.println(orange2.taxiNum);
        System.out.println(orange1.state);
        orange1.board();
        orange2.run();
        orange1.surcharge();
        orange1.pay();


    }
}