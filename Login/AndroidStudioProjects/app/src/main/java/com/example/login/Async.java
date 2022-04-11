package com.example.login;

import android.os.AsyncTask;

public class Async extends AsyncTask <Object, Void, Boolean> {
    private Comunicacion comunicacion;

    public Async(Comunicacion comunicacion){
        this.comunicacion = comunicacion;
    }

    @Override
    protected void onPreExecute(){
        comunicacion.toggleProgressBar(true);
    }

    @Override
    protected Boolean doInBackground(Object... objects) {
        try {
            Thread.sleep((int)objects[2]);
            String email = (String) objects[0];
            String pass = (String) objects[1];
            if (email.equals("admin@ipchile.cl") && pass.equals("admin")){
                return true;
            }else{
                return false;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean bo) {
        if (bo){
            this.comunicacion.lanzarActividad(BienvenidoActivity.class);
            this.comunicacion.showMessage("Datos Correctos");
            this.comunicacion.toggleProgressBar(false);
        }else{
            this.comunicacion.showMessage("Datos Incorrectos");
            this.comunicacion.toggleProgressBar(false);
        }
    }
}
