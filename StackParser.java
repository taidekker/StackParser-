/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2;

import java.util.Stack;

/**
 *
 * @author Napapis Dekker Assignment 2 Abstract Data Types CSD
 *
 * Reference :
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 *
 */
public class StackParser {

    public static boolean Parsing(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (char string : brackets.toCharArray()) {
            // string is left bracket
            switch (string) {
                case '(':
                case '{':
                case '[':
                case '<':
                   
                    stack.push(string);
                    break;
                case ')':
                case '}':
                case ']':
                case '>':
                     case ' ':
                {
                    if (stack.empty()) {
                        System.out.println(brackets + " Cannot parse");
                        return false;
                    } else {

                        char str = stack.peek();
                        //if input string contains a right bracket , then pop the left
                        if (string == '>' && str == '<' || string == ')' && str == '(' || string == ']' && str == '[' || string == '}' && str == '{'|| string == ' ') {

                            stack.pop();

                        } else {
                            System.out.println(brackets + " Cannot parse");
                            return false;
                        }
                    }
                    break;
                }
                default:
                    System.out.println(brackets + " Invalid input character");
            }
        }

        if (stack.empty()) {
            System.out.println(brackets + " Parsed");
        } else {

            System.out.println(brackets + " Cannot parse");
        }
        return (stack.empty());
    }

    public static void main(String args[]) {
        String input_str1 = "( { } )";
        String input_str2 = ")}[>.<]{(";
        String input_str3 = " ";
        String input_str4 = ">-.-<";

        Parsing(input_str1);
        Parsing(input_str2);
        Parsing(input_str3);
        Parsing(input_str4);
    }
}
