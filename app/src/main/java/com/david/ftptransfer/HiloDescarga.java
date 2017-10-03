package com.david.ftptransfer;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by david on 11/9/17.
 */

public class HiloDescarga extends AsyncTask <String, Object, Object> {

    ProgressDialog pd;
    private OnTaskCompleted tareaCompletada;

    public HiloDescarga (OnTaskCompleted activityContext) {
        this.tareaCompletada = activityContext;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(MainActivity.cntx);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setIndeterminate(true);
        pd.setTitle("Por favor epere");
        pd.setMessage("Descargando archivo...");
        pd.setCancelable(false);
        pd.show();
    }

    @Override
    protected Object doInBackground(String[] params) {

        MainActivity.download(params[0], params[1]);
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        pd.dismiss();
        tareaCompletada.onTaskCompleted();
    }
}
