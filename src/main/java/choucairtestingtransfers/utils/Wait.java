package choucairtestingtransfers.utils;

public class Wait {
        public static void Time(int millis){
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


}
