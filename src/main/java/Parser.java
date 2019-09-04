public class Parser {

    public Parser(){

    }
    public String getFirstWord(String cinLine){
        int i = cinLine.indexOf(' ');//if (i==-1) or use if(i!=-1)
        String cinFirstWord = cinLine.substring(0,i);
        return cinFirstWord;
    }
    public String getCinLessFirstWord(String cinLine){
        int i = cinLine.indexOf(' ');//if (i==-1) or use if(i!=-1)
        String cinLineLessFirstWord = cinLine.substring(i+1);//less SPACE
        return cinLineLessFirstWord;
    }

}
