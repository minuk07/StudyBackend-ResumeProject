import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumeView {
    private Scanner scanner;

    public ResumeView() {
        scanner = new Scanner(System.in);
    }

    public PersonInfo inputPersonInfo(){
        System.out.println("사진 파일명을 입력하세요. : ");
        String photo = scanner.nextLine();
        System.out.println("이름을 입력하세요. : ");
        String name = scanner.nextLine();
        System.out.println("이메일을 입력하세요. : ");
        String email = scanner.nextLine();
        System.out.println("주소를 입력하세요. : ");
        String address = scanner.nextLine();
        System.out.println("전화번호를 입력하세요. : ");
        String phoneNumber = scanner.nextLine();
        System.out.println("생년월일을 입력하세요. : ");
        String birthDate = scanner.nextLine();
        return new PersonInfo(photo, name, email, address, phoneNumber, birthDate);
    }

    public List<Education> inputEducationList(){
        List<Education> educationList = new ArrayList<>();

        while(true) {
            System.out.println("학력 정보를 입력하세요 (종료는 q)");
            System.out.println("졸업년도    학교명    전공  졸업여부");

            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("q")){
                break;
            }
            String[] tokens = input.split(" ");
            if (tokens.length != 4){
                System.out.println("잘못된 입력입니다. ");
                continue;
            }

            String graduationYear = tokens[0];
            String schoolName = tokens[1];
            String major = tokens[2];
            String graduationStatus = tokens[3];

            educationList.add(new Education(schoolName, major, graduationYear, graduationStatus));
        }
        return educationList;
    }

    public List<Career> inputCareerList(){
        List<Career> careerList = new ArrayList<>();

        System.out.println("경력 정보를 입력하세요. (종료는 q): ");
        System.out.println("근무기간    근무처    담당업무   근속연수");

        while(true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens.length != 4) {
                System.out.println("잘못된 입력입니다. ");
                continue;
            }

            String workPeriod = tokens[0];
            String companyName = tokens[1];
            String jobTitle = tokens[2];
            String employmentYears = tokens[3];

            careerList.add(new Career(workPeriod, companyName, jobTitle, employmentYears));
        }
        return careerList;
    }

    public String inputSelfIntroduction(){
        System.out.println("자기소개서를 입력하세요. 여러 줄을 입력하려면 빈 줄을 읿력하세요. ");
        StringBuilder sb = new StringBuilder(); //버퍼 기능이 있는 String
        String line;
        while((line = scanner.nextLine()).trim().length() > 0){
            sb.append(line).append("\n");
        }

        return sb.toString().trim();

    }
}
