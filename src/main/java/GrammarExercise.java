import java.util.*;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner scanner = new Scanner(System.in);
        String firstWordList = scanner.nextLine();
        String secondWordList = scanner.nextLine();
        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        System.out.println(result);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) throws RuntimeException{
        //在这编写实现代码
            List<String> validFirstWordList = isInputValid(firstWordList);
            List<String> validSecondWordList = isInputValid(secondWordList);
            return  validFirstWordList.stream()
                    .filter(s->validSecondWordList.contains(s))
                    .distinct()
                    .map(s -> String.join(" ", s.split("")))
                    .sorted(Comparator.comparing(a -> ((String) a)))
                    .collect(Collectors.toList());
    }

    public static List<String>  isInputValid(String input) throws RuntimeException {
        if (input.contains(",,")){
            throw new RuntimeException("input not valid");
        }
       return Arrays.stream(input.split(",")).map(s -> {
            if ( ! s.matches("[a-zA-Z]+") ){
                throw new RuntimeException("input not valid");
            }else {
                return s.toUpperCase();
            }
        }).collect(Collectors.toList());
    }
}
