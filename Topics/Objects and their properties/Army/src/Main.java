public class Main{
public static void main(String[]args){
    String str1 = "aaabbcccdaa";
    String str2 = " ";

    for (int i = 0; i < str1.length(); i++) {
        char ch = str1.charAt(i);
        System.out.println("i = " + i + ", ch = " + ch);
        if (ch != str2.charAt(str2.length() - 1)) {
            str2 += ch;
            System.out.println(str2);
        }
    }
    System.out.println(str2);
        }
        }