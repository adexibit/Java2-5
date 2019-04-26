public class Worker extends Thread {
    float[] arr;

    public Worker(float[] arr) {
        this.arr = arr;
    }

    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }

}
