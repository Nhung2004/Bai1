package Candidate;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Set<String> usedEmails = new HashSet<>();
    static List<ExperienceCandidate> candidates = new ArrayList<>();

    public static void fakeData() {
        addCandidate(new ExperienceCandidate("Hung", "Nguyen", "038547322", "hungnguyenngoc714@gmail.com", 2));
        addCandidate(new ExperienceCandidate("Hung", "Tran", "04834738", "hung@gmail.com", 2));
        addCandidate(new ExperienceCandidate("Quynh", "Le", "0298433224", "hun@gmail12", 3));
        addCandidate(new ExperienceCandidate("Anh", "Nguyen", "092483444", "dung@example.com", 4));
    }

    public static void addCandidate(ExperienceCandidate ec) {
        boolean exists = candidates.stream()
                .anyMatch(c -> c.getEmail().equals(ec.getEmail()));
        
        if (!exists) {
            candidates.add(ec);
            System.out.println("Đã thêm: " + ec.getEmail());
        } else {
            System.out.println("Email đã tồn tại: " + ec.getEmail());
        }
    }


    public static void addNewCandidate(ExperienceCandidate ec) {
        if (!candidates.stream().anyMatch(c -> c.getEmail().equals(ec.getEmail()))) {
            addCandidate(ec);
        }
    }

    public static ExperienceCandidate findMinExp() {
        return candidates.stream().min(Comparator.comparingInt(ExperienceCandidate::getExpInYear)).orElse(null);
    }

    public static void main(String[] args) {
        
        try {
			fakeData();
			System.out.println("Danh sách sau khi giả lập:");
			candidates.forEach(c->System.out.println(c.getType()+" "+c));

			// them ung vien
			ExperienceCandidate newC = new ExperienceCandidate("Hung", "Ngoc", "0294325", "hungnguyen@gmail.com", 1);
			addNewCandidate(newC);

			// tim ung vien it exp nhast
			ExperienceCandidate minExp = findMinExp();
			System.out.println("Ứng viên ít kinh nghiệm nhất:");
			System.out.println(minExp);

			//ghi file
			DBEngine.writeToFile("candidates.dat", candidates);

			// doc file
			System.out.println("Đọc lại danh sách từ file:");
			List<ExperienceCandidate> loaded = DBEngine.readFromFile("candidates.dat");
			loaded.forEach(System.out::println);
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			System.out.println("lỗi email"+e.getMessage());
		}
    }
}
