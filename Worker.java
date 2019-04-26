public class Worker extends Thread{
    float [] arr;
    public Worker (float []arr){
        this.arr = arr;
    }
    public void run(){
        for (float i : arr) {
            arr[(int) i] = 1f;
        }
        for (float i : arr) {
            arr[(int) i] = (float) (arr[(int) i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }

}
