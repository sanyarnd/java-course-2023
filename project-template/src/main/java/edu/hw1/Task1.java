public class Task1 {
    public static Integer minutesToSeconds(String time){
        Integer index_of_dots = time.indexOf(":");

        if(index_of_dots.equals(-1)){
            return -1;
        }

        Integer minute_time = Integer.valueOf(time.substring(0,index_of_dots));
        minute_time *= 60;
        Integer second_time = Integer.valueOf(time.substring(index_of_dots+1, time.length()));

        if(second_time >= 60){
            return -1;
        }
        return minute_time+second_time;
    }
}
