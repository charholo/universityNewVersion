package org.university;
import java.util.Random;

public class Utilities {

    public static int getRandomNumberId(int identityId){
        /*  1  - Student, 2  - Teacher, 3  - Subject  */
        Random generateRandomNumber = new Random();
        int automaticalId = 0;

        if (identityId == 1){
            return automaticalId = generateRandomNumber.nextInt(700-500+1) + 500;
        }else if (identityId == 2){
            return automaticalId = generateRandomNumber.nextInt(900-800+1) + 800;
        }else if (identityId == 3){
            return automaticalId = generateRandomNumber.nextInt(200-100+1) + 200;
        }
        return automaticalId;
    }
}
