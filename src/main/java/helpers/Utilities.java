package helpers;
import java.util.Random;

public class Utilities {

    public static int getRandomNumberId(RandomIdentifier identityId){
        Random generateRandomNumber = new Random();
        int automaticalId = 0;

        if (identityId == RandomIdentifier.STUDENT){
            return generateRandomNumber.nextInt(700-500+1) + 500;
        }else if (identityId == RandomIdentifier.TEACHER){
            return generateRandomNumber.nextInt(900-800+1) + 800;
        }else if (identityId == RandomIdentifier.SUBJECT){
            return generateRandomNumber.nextInt(200-100+1) + 200;
        }
        return automaticalId;
    }

    public enum RandomIdentifier {
        STUDENT, TEACHER, SUBJECT;
    }
}
