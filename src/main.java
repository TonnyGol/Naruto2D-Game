public class main {
    public static void main(String[] args) {
        new WindowFrame();
    }

    public static void sleep(long milisec){
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
