package learn.java.myasynktask;

import android.os.AsyncTask;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<Void, Void, Integer> {

    TextView textViewST;

    public MyAsyncTask(TextView textSleepingTime){
        this.textViewST = textSleepingTime;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textViewST.setText("Loading...");
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        int sleepingTime = 5000;

        try {
            Thread.sleep(sleepingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sleepingTime;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        textViewST.setText("A thread dormiu por: " + integer);
    }

//    @Override
//    protected void onProgressUpdate(Void... values) {
//        super.onProgressUpdate(values);
//
//    }
}
