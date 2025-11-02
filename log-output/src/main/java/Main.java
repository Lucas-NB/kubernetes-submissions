import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    List<String> outputStrings = new ArrayList<>();
    String[] letters = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "a", "b", "c", "d", "e", "f"
    };
    Random randomGenerator = new Random();

    while (true) {
      LocalDateTime now = LocalDateTime.now();
      OffsetDateTime offsetDate = now.atOffset(ZoneOffset.UTC);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss:SSSX");
      String formattedDate = offsetDate.format(formatter);
      StringBuilder randomWord = new StringBuilder();

      for (int i = 0; i < 8; i++) {
        int randomNumber = randomGenerator.nextInt(letters.length);
        randomWord.append(letters[randomNumber]);
      }

      String word = randomWord.toString();

      outputStrings.add(word);
      System.out.printf("%s: %s%n", formattedDate, word);
      Thread.sleep(5000);
    }
  }
}
