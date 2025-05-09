package core_java.theory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberFormat {
    public static void main(String[] args) {

        long rounded = Math.round(3.6); // 4
        long rounded1 = Math.round(3.4); // 3
        long rounded2 = Math.round(3.5); // 4
        System.out.println("round: " + rounded + " " + rounded1 + " " + rounded2);

        DecimalFormat df = new DecimalFormat("#########,###0.0000");
        System.out.println("DecimalFormat: " + df.format(13421512564123.784));
        System.out.println("DecimalFormat: " + df.format(1382121297897123.785));

        BigDecimal bd = new BigDecimal("13.456789");
        BigDecimal bd1 = bd.setScale(1, RoundingMode.HALF_UP);//Nếu phần thập phân ≥ 0.5 thì làm tròn lên, ngược lại làm tròn xuống.
        BigDecimal bd2 = bd.setScale(1, RoundingMode.HALF_DOWN);//Nếu phần thập phân > 0.5 thì lên, = 0.5 hoặc nhỏ hơn thì xuống.
        BigDecimal bd21 = new BigDecimal("13.45").setScale(1, RoundingMode.HALF_DOWN);//Nếu phần thập phân > 0.5 thì lên, = 0.5 hoặc nhỏ hơn thì xuống.

        // Gọi là "Banker’s rounding", dùng trong tài chính để giảm sai số tổng hợp.
        //Nếu phần thập phân = 0.5, thì làm tròn đến số nguyên chẵn gần nhất.
        BigDecimal bd31 = new BigDecimal("2.186468").setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal bd32 = new BigDecimal("2.1855").setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal bd33 = new BigDecimal("2.5").setScale(0, RoundingMode.HALF_EVEN);
        BigDecimal bd34 = new BigDecimal("3.345").setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal bd4 = new BigDecimal("3.544454").setScale(2, RoundingMode.HALF_EVEN);

        //Bỏ qua dấu thập phân, luôn tăng lên 1 đơn vị nếu không phải số nguyên.
        //Dù là số âm hay dương, magnitude tăng
        BigDecimal bd51 = new BigDecimal("2.15").setScale(0, RoundingMode.UP);
        BigDecimal bd52 = new BigDecimal("-2.14").setScale(0, RoundingMode.UP);

        //Cắt bỏ phần thập phân, không quan tâm số là âm hay dương.
        BigDecimal bd61 = new BigDecimal("2.95").setScale(0, RoundingMode.DOWN);
        BigDecimal bd62 = new BigDecimal("-2.94").setScale(0, RoundingMode.DOWN);

        //“Ceiling” nghĩa là trần nhà → hướng lên trên nếu dương.
        BigDecimal bd71 = new BigDecimal("2.3").setScale(0, RoundingMode.CEILING);
        BigDecimal bd72 = new BigDecimal("-2.3").setScale(0, RoundingMode.CEILING);

        //“Floor” nghĩa là sàn nhà → hướng xuống dưới nếu âm.
        BigDecimal bd81 = new BigDecimal("2.3").setScale(0, RoundingMode.FLOOR); // 2
        BigDecimal bd82 = new BigDecimal("-2.3").setScale(0, RoundingMode.FLOOR); // -3

        System.out.println("setScale");
        System.out.println(bd1);
        System.out.println(bd2);
        System.out.println(bd21);

        System.out.println(bd31 + " " + bd32 + " " + bd33 + " " + bd34);
        System.out.println(bd4);

        System.out.println(bd51);
        System.out.println(bd52);
        System.out.println(bd61);
        System.out.println(bd62);

        System.out.println(bd71);
        System.out.println(bd72);



    }
}
