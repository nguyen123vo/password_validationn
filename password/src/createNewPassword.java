import java.util.Scanner;
public class createNewPassword {

    public static boolean checkLength(String newPass) {
        return newPass.length() >= 8;
        }

    public static boolean checkUpperCase(String newPass) {
        for (int i = 0; i < newPass.length(); i++) {
            if (Character.isUpperCase(newPass.charAt(i))) {
                return true;
            }
        } return false;
    }

    public static boolean checkNumber(String newPass) {
        for (int i = 0; i < newPass.length(); i++) {
            if (Character.isDigit(newPass.charAt(i))) {
                return true;
            }
        } return false;
    }
    public static boolean checkSpace(String newPass) {
        for (int i = 0; i < newPass.length(); i++) {
            if (Character.isWhitespace(newPass.charAt(i))) {
                return false;
            }
        } return true;
    }
    public static boolean checkSpecial(String newPass) {
        int special = 0;
        for (int i = 0; i < newPass.length(); i++) {
            if (!Character.isLetter(newPass.charAt(i)) && !Character.isDigit(newPass.charAt(i)) && !(newPass.charAt(i) == ' ')) {
                special++;
                if (special > 0) {
                    return true;
                }
            }
        } return false;
    }
    public static boolean check3number(String newPass) {

        for (int i = 0; i < newPass.length(); i++) {
            if (Character.isDigit(newPass.charAt(i)) && Character.isDigit(newPass.charAt(i + 1)) && Character.isDigit(newPass.charAt(i + 2))) {
                return false;
            }
        } return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap mat khau moi:");
        boolean truePassword = false;
        while (!truePassword) {
            String newPass = input.nextLine();
            if (!checkLength(newPass)) {
                System.out.println("Mat khau can it nhat 8 ki tu");
            } else if (!checkUpperCase(newPass)) {
                System.out.println("Can it nhat mot chu cai viet hoa");
            } else if (!checkNumber(newPass)) {
                System.out.println("Can it nhat mot chu so");
            } else if (!checkSpecial(newPass)) {
                System.out.println("Can it nhat mot ki tu dac biet");
            } else if (!checkSpace(newPass)) {
                    System.out.println("Mat khau khong duoc chua khoang trong");
            } else if (!check3number(newPass)) {
                System.out.println("Mat khau khong duoc chua 3 chu so lien tiep");
            } else {
                System.out.println("Mat khau hop le");
                truePassword = true;
            }
        }

    }

}

