package com.example.calculator;

import java.util.ArrayList;

public class calculate {
    String expression;// 用户输入的表达式
    int flag1, flag2; // 用于标记数字长度，逐个分割数字和运算符
    ArrayList<String> list = new ArrayList(); // list用于乘除运算
    ArrayList<String> list2 = new ArrayList();// list2用于加减运算 （运算优先级）

    public calculate(String expression) {
        this.expression = expression;
    }// 构造函数，获取expression

    public String getResult() {
        flag1 = 0;
        flag2 = 0;
        for (; flag1 < expression.length(); flag1++) {

                if (expression.charAt(flag1) == '*' || expression.charAt(flag1) == '/' || expression.charAt(flag1) == '-' || expression.charAt(flag1) == '+') {
                    //flag1 和 flag2 作为数字开始和结束 ， 用于分离运算符和数字
                    //先遍历一遍式子， 将乘除计算 存入数组 ，方便之后再进行加减
                    list.add(expression.substring(flag2, flag1));
                    list.add(String.valueOf(expression.charAt(flag1)));
                    flag2 = flag1 + 1;
                }
                if (flag1 == expression.length()-1) {
                    list.add(expression.substring(flag2));
                }//最后一位数 单独插入
            }
            //获取数字和运算符

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals("*")  || list.get(j).equals("/")) {
                    Double a = Double.parseDouble(list.get(j - 1));
                    Double b = Double.parseDouble(list.get(j + 1));
                    String symbol = list.get(j);
                    String result = String.valueOf(calculator(a, b, symbol));
                    list.set(j - 1, "");
                    list.set(j, "");
                    list.set(j + 1, result);
                }
            }
            //先进行乘除运算

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != "") {
                    list2.add(list.get(i));
                }
            }
            //将数组空格位剔去

            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).equals("+")|| list2.get(i).equals("-")) {
                    Double a = Double.parseDouble(list2.get(i - 1));
                    Double b = Double.parseDouble(list2.get(i + 1));
                    String symbol = list2.get(i);
                    String result = String.valueOf(calculator(a, b, symbol));
                    list2.set(i - 1, "");
                    list2.set(i, "");
                    list2.set(i + 1, result);
                }
            }
        return list2.get(list2.size() - 1);
    }


    public double calculator (double num1, double num2, String symbol) {
        //进行加减乘除运算
        if (symbol.equals("+")) {
            return num1 + num2;
        } else if (symbol.equals("-")) {
            return num1 - num2;
        } else if (symbol.equals("*")) {
            return num1 * num2;
        } else if (symbol.equals("/")) {
            return num1 / num2;
        }
        return 0;
    }
}