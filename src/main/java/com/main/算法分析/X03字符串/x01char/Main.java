package com.main.算法分析.X03字符串.x01char;

public class Main {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        int n = a.length();
        int add = 0;
        StringBuffer res = new StringBuffer();
        for(int i = n - 1; i >= 0; i--){
            int as = i < a.length() ?  a.charAt(i) : '0';
            int bs = i < b.length() ? b.charAt(i - (b.length() - a.length())) : '0';
            int sum = (as + bs  + add ) - (2 * '0');
            if( sum > 1){
                res.append('0');
                add = 1;
            }else if( sum == 0){
                res.append('0');
                add = 0;
            }else{
                res.append('1');
                add = 0;
            }
            System.out.println(res.toString());
        }
        if( add == 1) res.append('1');

        res  = res.reverse();


        System.out.println(res.toString());
    }
}
