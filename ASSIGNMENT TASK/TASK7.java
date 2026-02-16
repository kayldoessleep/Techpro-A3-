//task 7
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.io.File; // Missing import added
import java.io.IOException; // Missing import added
import javax.sound.sampled.AudioInputStream; // Missing import added
import javax.sound.sampled.AudioSystem; // Missing import added
import javax.sound.sampled.Clip; // Missing import added
import javax.sound.sampled.LineUnavailableException; // Missing import added
import javax.sound.sampled.UnsupportedAudioFileException; // Missing import added

public class TASK7 {
    public static void main(String[] args) {

        // JAVA ALARM CLOCK
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "A Caring Friend.wav"; // Ensure file exists in project root

        while (alarmTime == null) {
            try {
                System.out.print("Enter an alarm time (HH:MM:SS): ");
                String inputTime = scanner.nextLine().trim();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime.format(formatter));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use 24-hour HH:MM:SS (e.g., 08:30:00)");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}

class AlarmClock implements Runnable {

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    public AlarmClock(LocalTime alarmTime, String filePath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        System.out.println("\nCountdown active... Current time:");

        while (LocalTime.now().isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);

                LocalTime now = LocalTime.now();
                System.out.printf("\rCurrent time: %02d:%02d:%02d",
                        now.getHour(),
                        now.getMinute(),
                        now.getSecond());
            } catch (InterruptedException e) {
                System.out.println("\nThread interrupted - Alarm stopped");
                return;
            }
        }

        System.out.println("\n\n*ALARM NOISES*");
        playSound(filePath);
    }

    private void playSound(String filePath) {
        File audioFile = new File(filePath);

        if (!audioFile.exists()) {
            System.out.println("Error: File not found - " + audioFile.getAbsolutePath());
            scanner.close();
            return;
        }

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.print("Press Enter to stop the alarm: ");
            scanner.nextLine();
            clip.stop();
            clip.close();
            System.out.println("Alarm stopped successfully");
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Error: Unsupported audio format");
        } catch (LineUnavailableException e) {
            System.out.println("Error: Audio output unavailable");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
