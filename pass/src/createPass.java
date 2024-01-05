import java.util.Scanner;
public class createPass {
    static int upper = 0, lower = 0, number = 0, space = 0, special = 0;

    public static void count(String newPass) {
        for (int i = 0; i < newPass.length(); i++) {
            char ch = newPass.charAt(i);
            if ('A' < ch && ch < 'Z') {
                upper++;
            } else if ('a' < ch && ch < 'z') {
                lower++;
            } else if ('0' < ch && ch < '9') {
                number++;
            } else if (ch == ' ') {
                space++;
            } else {
                special++;
            }
        }
    }
    public static boolean number3(String newPass) {
        for (int i = 0; i < newPass.length(); i++) {
            if (Character.isDigit(newPass.charAt(i)) && Character.isDigit(newPass.charAt(i + 1)) && Character.isDigit(newPass.charAt(i + 2))) {
                return false;
            }

        } return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mật khẩu mới!");
        boolean truePass = false;
        while (!truePass) {
            String newPass = input.nextLine();
            count(newPass);
            if (upper == 0) {
                System.out.println("Cần ít nhất một chữ cái in hoa");
            } else if (number == 0) {
                System.out.println("Cần ít nhất một chữ số");
            } else if (space > 0) {
                System.out.println("Không được chứa khoảng trống");
            } else if (special == 0) {
                System.out.println("Cần ít nhất một kí tự đặc biệt");
            } else if (!number3(newPass)) {
                System.out.println("Mật khẩu không được chứa 3 chữ số liên tiếp");
            } else {
                System.out.println("Mật khẩu hợp lệ");
                truePass = true;
            }
        }
    }

}