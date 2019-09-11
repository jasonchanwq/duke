public class Parser {

    public Parser(){

    }
    public String getFirstWord(String cinLine){
        String str = cinLine;
        String[] arrOfStr = str.split(" ", 2);
        return arrOfStr[0];
    }
    public String getCinLessFirstWord(String cinLine){
        String str = cinLine;
        String[] arrOfStr = str.split(" ", 2);
        return arrOfStr[1];
    }

}
