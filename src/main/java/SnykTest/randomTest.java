/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SnykTest;

/**
 *
 * @author hoang
 */
import java.util.Random;

public class randomTest {
    public static String generateCode() {
        Random rand = new Random();
        int code = rand.nextInt(1000);  // Insecure Random
        return "CT" + code;
    }

    public static void main(String[] args) {
        System.out.println(generateCode());
    }
}
